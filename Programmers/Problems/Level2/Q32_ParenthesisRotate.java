package Level2;

import java.util.Stack;

public class Q32_ParenthesisRotate {
	public static void main(String[] args) {
		Q32_ParenthesisRotate a = new Q32_ParenthesisRotate();
		String s = "[](){}";
		int ret = a.solution(s);
		System.out.println(ret);
	}
    public int solution(String s) {
        int ret = 0;
        int len = s.length();
        for(int i=0 ; i<len ; i++){
            Stack<Character> st = new Stack<>();
            String ss = rotate(s,i);
            if(chk(st,ss)){
                ret++;
            }
        }
        // System.out.println((int)'('+", "+(int)')');
        // System.out.println((int)'{'+", "+(int)'}');
        // System.out.println((int)'['+", "+(int)']');
        
        return ret;
    }
    private boolean chk(Stack<Character> st, String ss){
        for(int i=0 ; i<ss.length() ; i++){
            char ch = ss.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else{
                if(st.size()==0)
                    return false;
                if(Math.abs((int)st.peek()-(int)ch)<=2){
                    st.pop();
                }
            }
        }
        return st.size()==0;
    }
    
    private String rotate(String s, int time){
        StringBuilder sb = new StringBuilder(s);
        for(int i=0 ; i<time ; i++){
            String temp = sb.substring(0,1);
            sb.deleteCharAt(0);
            sb.append(temp);
            // System.out.println(sb.append(temp));
        }
        // System.out.println(sb);
        return sb.toString();
    }
}

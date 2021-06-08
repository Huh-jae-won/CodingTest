package Level2;

import java.util.Stack;

public class Q12_Parenthesis {
	public static void main(String[] args) {
		Q12_Parenthesis a = new Q12_Parenthesis();
		String s = "()()";
		System.out.println(a.solution(s));
	}
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        int len = s.length();
        for(int i=0 ; i<len ; i++){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(ch);
            }else{
                // ')' 인경우
                if(st.size()==0){
                    return false;
                }
                st.pop();
            }
        }
        return st.size()==0;
    }
}

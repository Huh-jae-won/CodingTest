package Level2;

import java.util.Stack;

public class Q55_RemovePair {
	public static void main(String[] args) {
		Q55_RemovePair z= new Q55_RemovePair();
		String s = "baabaa";
		z.solution(s);
	}
    public int solution(String s){
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i=1 ; i<s.length() ; i++){
            char ch = ' ';
            if(st.size()>0)
                ch = st.peek();
            char comp = s.charAt(i);
            if(ch==comp){
                st.pop();
            }else{
                st.push(comp);
            }
            
        }
        if(st.size()==0){
            return 1;
        }
            return 0;
    }
	
}

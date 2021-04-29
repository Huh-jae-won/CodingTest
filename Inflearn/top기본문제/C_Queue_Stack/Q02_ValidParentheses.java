package C_Queue_Stack;

import java.util.Stack;

public class Q02_ValidParentheses {

	public static void main(String[] args) {
		Q02_ValidParentheses q02 = new Q02_ValidParentheses();
		String str = "([])]";
		System.out.println(q02.isValid(str));
		System.out.println(q02.solution(str));
	}
	public boolean solution(String s) {
		if(s.length()%2!=0) {
			return false;
		}
		Stack<Character> st = new Stack();
		for(int i=0 ; i<s.length() ; i++) {
			switch(s.charAt(i)) {
				case ')': 
					if(!st.isEmpty() && st.peek()=='(') {
						st.pop();
					}else {
						return false;
					}
					break;
				case '}': 
					if(!st.isEmpty() && st.peek()=='{') {
						st.pop();
					}else {
						return false;
					}
					break;
				case ']': 
					if(!st.isEmpty() && st.peek()=='[') {
						st.pop();
					}else {
						return false;
					}
					break;
				case '>': 
					if(!st.isEmpty() && st.peek()=='<') {
						st.pop();
					}else {
						return false;
					}
					break;

				
				default:// open°ýÈ£ °æ¿ì
					st.push(s.charAt(i));
					break;
			}
		}
		
		return true;
	}
	
	public boolean isValid(String s) {
		String open = "({[<";
		String close = ")}]>";
		Stack<Character> st = new Stack<>();
		for(int i=0 ; i<s.length() ; i++) {
			if(open.contains(String.valueOf(s.charAt(i)))) {
				st.push(s.charAt(i));
			}else {
				if(s.charAt(i)-st.peek()>0 && s.charAt(i)-st.peek()<3) {
					st.pop();
				}else {
//					System.out.println(st);
					return false;
				}
			}
		}
		return st.empty();
	}

}

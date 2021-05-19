package E_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Q01_Parenthesis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> stack = new Stack<>();
		for(int i=0 ; i<str.length() ; i++) {
			char ch = str.charAt(i);
			if(ch=='(') {
				stack.push(ch);
			}else {
				// )인 경우
				if(stack.size()==0) {
					System.out.println("NO");
					return;
				}
				if(stack.peek()=='(') {
					stack.pop();
				}else {
					stack.push(ch);
				}
			}
		}
		if(stack.size()==0) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}

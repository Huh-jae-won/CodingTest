package E_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Q04_Postfix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Integer> st = new Stack<>();
		for(int i=0 ; i<str.length() ; i++) {
			char ch = str.charAt(i);
			if(ch>='0' && ch<='9') {
				st.push(Integer.parseInt(ch+""));
			}else {
				int get = 0;
				int n2 = st.pop();
				int n1 = st.pop();
				switch (ch) {
				case '+':
					get = n1+n2;
					break;
				case '-':
					get = n1-n2;
					break;
				case '*':
					get = n1*n2;
					break;
				case '/':
					get = n1/n2;
					break;
				default:
					break;
				}
				st.push(get);
			}
		}
		System.out.println(st.peek());
	}
}

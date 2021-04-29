package C_Queue_Stack;

import java.util.Stack;

public class Q01_Baseball {
	public static void main(String[] args) {
		String[] strs = {"5","-2","4","C","D","9","+","+"};
//		C : 제일 최근값 삭제
//		D : 제일 최근값 2배로 삽입
//		+ : 최근 2개값의 합을 삽입
		System.out.println(calPoints(strs));
//		System.out.println(solution(strs));
	}
	public static int solution(String[] strs) {
		Stack<Integer> st = new Stack<>();
		
		for(String op : strs) {
			switch(op) {
				case "C" :
					st.pop();
					break;
				case "D" :
					int num = st.peek()*2;
					st.push(num);
					break;
				case "+" :
					int pop1 = st.pop();
					int pop2 = st.pop();
					st.push(pop2);
					st.push(pop1);
					st.push(pop1+pop2);
					break;
				default :
					st.push(Integer.valueOf(op));
					break;
			}
		}
		return sumStack(st);
	}
	
	public static int calPoints(String[] ops) {
		Stack<Integer> st = new Stack<>();
		for(int i=0 ; i<ops.length ; i++) {
			int num = 0;
			if(ops[i].equals("+")){
				int pop1 = st.pop();
				int pop2 = st.pop();
				num = pop1 + pop2;
				st.add(pop2);
				st.add(pop1);
				st.add(num);
			}else if(ops[i].equals("C")) {
				num = st.pop();
			}else if(ops[i].equals("D")) {
				num = st.peek()*2;
				st.add(num);
			}else {
				num = Integer.parseInt(ops[i]);
				st.add(num);
			}
			System.out.println(ops[i] + " : "+ num);
			System.out.println(st+"\n");
		}
		return sumStack(st);
	}
	public static int sumStack(Stack<Integer> st) {
		int sum = 0;
		while(!st.isEmpty()) {
			sum += st.pop();
		}
		return sum;
	}
}

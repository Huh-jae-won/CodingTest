package E_Stack_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Q05_Stick {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> st = new Stack<>();
		Stack<Integer> stIdx = new Stack<>();
		List<Integer> lazer = new ArrayList<>();
		List<int[]> stick = new ArrayList<>();
		st.push('(');
		stIdx.push(0);
		for(int i=1 ; i<str.length() ; i++) {
			char ch = str.charAt(i);
			// 레이저인 경우
			if(ch=='(') {
				st.push(ch);
				stIdx.push(i);
			}else if(str.charAt(i-1)=='(' && ch==')'){
				lazer.add(i-1);
				st.pop();
				stIdx.pop();
			}else {
				st.pop();
				int idx = stIdx.pop();
				stick.add(new int[] {idx,i});
			}
		}
//		printList(stick);
//		System.out.println(lazer);
		int cut = 0;
		for(int[] arr : stick) {
			int start = arr[0];
			int end = arr[1];
			for(int i=0 ; i<lazer.size() ; i++) {
				int pos = lazer.get(i);
				if(pos>end)
					break;
				if(pos>start && pos<end) {
					cut++;
				}
			}
		}
		System.out.println(cut+stick.size());
		
	}
	static void printList(List<int[]> list) {
		for(int[] arr : list) {
			System.out.printf("[%d,%d] ",arr[0],arr[1]);
		}
		System.out.println();
	}
}

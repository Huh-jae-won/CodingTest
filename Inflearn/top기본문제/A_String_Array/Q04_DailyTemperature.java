package A_String_Array;
import java.util.Stack;

public class Q04_DailyTemperature {
	public static void main(String[] args) {
		Q04_DailyTemperature dt = new Q04_DailyTemperature();
		
		int[] num = {73, 74, 75, 71, 69, 72, 76, 73,77};
		int[] ret = dt.dailyTemperatures(num);
		for(int i=0 ; i<ret.length ; i++) {
			System.out.print(ret[i] + " ");
		}
		System.out.println();
		
	}
	public int[] dailyTemperatures(int[] temper) {
//		1. 자료구조
		int length = temper.length;
		Stack<Integer> st = new Stack<>(); // 공간복잡도
		int[] ret = new int[length];
//		2. for,while 알고리즘 : 시간복잡도
		for(int i=0 ; i<length ; i++) {
			System.out.println("들어올수 : "+temper[i]);
			while(!st.isEmpty() && temper[st.peek()]<temper[i]) {
//				ex) 73<74 : 빼야함
				int index = st.pop();
				System.out.println("i : "+i+", index : "+index);
				ret[index] = i-index;
			}
			st.push(i);
		}
		return ret;
	}
//	public int[] dailyTemperatures(int[] temperatures) {
//		int[] ret = new int[temperatures.length];
//		for(int i=0 ; i<temperatures.length-1 ; i++) {
//			int cnt = 0;
//			for(int j=i+1 ; j<temperatures.length ; j++) {
//				if(temperatures[i]<temperatures[j]) {
//					cnt++;
//					ret[i] = cnt;
//					break;
//				}else {
//					cnt++;
//				}
//			}
//		}
//		return ret;
//	}

}

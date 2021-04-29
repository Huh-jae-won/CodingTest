package Stack_Queue;

import java.util.Stack;

public class Q02_StockPrice {
	public static void main(String[] args) {
		Q02_StockPrice a = new Q02_StockPrice();
		int[] price = {1,3,2,3};
		print(a.stock(price));
		print(a.solution(price));
	}
	public int[] solution(int[] price) {
		int[] ret = new int[price.length];
		for(int i=0 ; i<price.length ; i++) {
			for(int j=i+1 ; j<price.length ; j++) {
				ret[i]++;
				if(price[i]>price[j])
					break;
			}
		}
		return ret;
	}
	public int[] stock(int[] price) {
		int[] ret = new int[price.length];
		Stack<Integer> st = new Stack<Integer>();
		Stack<Integer> indexSt = new Stack<Integer>();
		st.push(price[0]);
		indexSt.push(0);
		int indx = 1;
		while(indx<price.length) {
			if(st.isEmpty() || st.peek()<=price[indx]) {
				st.push(price[indx]);
				indexSt.push(indx++);
			}else {
				st.pop();
				int indxPeek = indexSt.pop();
				ret[indxPeek] = indx-indxPeek; 
			}
//			System.out.println(st);
//			System.out.println(indexSt);
//			print(ret);
//			System.out.println();
		}
		indx--;
		while(!st.isEmpty()) {
			int num = st.pop();
			int numIndex = indexSt.pop();
			ret[numIndex] = indx-numIndex; 
		}
		return ret;
	}
	private static void print(int[] arr) {
		for(int i=0 ; i<arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

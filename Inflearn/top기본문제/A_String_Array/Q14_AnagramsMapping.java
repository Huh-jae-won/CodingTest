package A_String_Array;

import java.util.HashMap;
import java.util.Map;

public class Q14_AnagramsMapping {

	public static void main(String[] args) {
		Q14_AnagramsMapping q14 = new Q14_AnagramsMapping();
		
		int[] ret = null;
		int[] A = {11, 27, 45, 31, 50};
		int[] B = {50, 11, 31, 45, 27};
		ret = q14.anagramMapping(A, B);
		System.out.println("===result===");
		q14.print(ret);
	}
	public int[] anagramMapping(int[] A, int[] B) {
		int[] ret = new int[A.length];
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0 ; i<B.length ; i++) {
			map.put(B[i], i);
		}
		for(int i=0 ; i<A.length ; i++) {
			ret[i] = map.get(A[i]);
		}
		return ret;
	}
	
	public void print(int[] arr) {
		System.out.print("[ ");
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}

}

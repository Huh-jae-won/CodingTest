package F_Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Q06_Naughty {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] sorted = new int[N];
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
			sorted[i] = arr[i];
		}
		Arrays.sort(sorted);
		for(int i=0 ; i<N ; i++) {
			if(sorted[i]!=arr[i])
				System.out.print((i+1)+" ");
		}
		System.out.println();
	}
}

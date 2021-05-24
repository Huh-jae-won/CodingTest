package F_Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Q02_BubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N-i-1 ; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
//			System.out.println(Arrays.toString(arr));
		}
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}

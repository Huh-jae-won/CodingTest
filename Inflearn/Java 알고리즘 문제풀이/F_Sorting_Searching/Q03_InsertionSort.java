package F_Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Q03_InsertionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=1 ; i<N ; i++) {
			// 정렬할 위치
			for(int j=0 ; j<i ; j++) {
				// 정렬된 곳
				if(arr[i]<arr[j]) {
					int temp = arr[i];
					for(int k=i ; k>j ; k--) {
						arr[k] = arr[k-1];
					}
					arr[j] = temp;
				}
			}
//			System.out.println(Arrays.toString(arr));
		}
		for(int n : arr) {
			System.out.print(n+" ");
		}
		System.out.println();
		
	}
}

package F_Sorting_Searching;

import java.util.Scanner;

public class Q01_SelectionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0 ; i<N-1 ; i++) {
			for(int j=i+1 ; j<N ; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					continue;
				}
			}
		}
		for(int i=0 ; i<N ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

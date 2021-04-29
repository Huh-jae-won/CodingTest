package Study_0221_1;

import java.util.Scanner;

public class Q2226_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[(int) Math.pow(2, N-1)];
		arr[0] = 1;
		int result = change(N,arr);
		System.out.println(result);
	}
	
	static int change(int num,int[] arr) {
		int cnt = 0;
		int adj = 0;
		for(int i=0 ; i<num-1 ; i++) {
			int length = (int) Math.pow(2, i);
			for(int j=length ; j<2*length ; j++) {
				arr[j] = arr[j-length];
			}
			for(int j=0 ; j<length ; j++) {
				if(arr[j]==0)
					arr[j]=1;
				else
					arr[j]=0;
			}
			if(i==num-2) {
				for(int j=0 ; j<arr.length ; j++) {
					if(arr[j]==0) {
						cnt++;
						if(arr[j+1]==0&&j+1<arr.length) {
							adj++;
						}
					}
				}
			}
		}
		return cnt-adj;
	}
}

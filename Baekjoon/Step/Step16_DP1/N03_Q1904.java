package Step16_DP1;

import java.util.Scanner;

public class N03_Q1904 {
	static int n;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+2];
		int ret = tile2(n);
		System.out.println(ret);
	}
	static int tile2(int n) {
		int cnt = 3;
		arr[1] = 1;
		arr[2] = 2;
		if(n==1 || n==2) {
			return arr[n];
		}
		for(int i=3 ; i<=n ; i++) {
			arr[i] = (arr[i-1]+arr[i-2])%15746;
		}
		return arr[n];
	}
}

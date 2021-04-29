package Step16_DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12_Q11054 {
	static int N;
	static int[] num;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		num = new int[N+1];
		dp = new int[N+2][2];
//		[i][0] : i번까지 증가
//		[i][1] : i번이후 감소
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<N+1 ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		increase();
		decrease();
		int result = max();
		print();
		System.out.println(result);

	}
	static int max() {
		int max = Integer.MIN_VALUE;
		for(int i=1 ; i<N+1 ; i++) {
			int temp = dp[i][0] + dp[i][1];
			if(max<temp)
				max = temp;
		}
		return max;
	}
	static void print() {
		System.out.print("indx");
		for(int i=0 ; i<N+2 ; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		System.out.print("0 : ");
		for(int i=0 ; i<N+2 ; i++) {
			System.out.print(dp[i][0] + " ");
		}
		System.out.println();
		
		System.out.print("1 : ");
		for(int i=0 ; i<N+2 ; i++) {
			System.out.print(dp[i][1] + " ");
		}
		System.out.println();
	}
	static void increase() {
		for(int i=1 ; i<N+1 ; i++) {
			int min = 0;
			dp[i][0] = 1;
			for(int j=1 ; j<i ; j++) {
				if(num[i]>num[j]) {
					if(min<dp[j][0]) {
						min = dp[j][0];
					}
				}
			}
			dp[i][0] += min;
		}
	}
	static void decrease() {
		for(int i=N ; i>0 ; i--) {
			int min = 0;
			dp[i][1] = 1;
			for(int j=N-1 ; j>i ; j--) {
				if(num[i]>num[j]) {
					if(min<dp[j][1]) {
						min = dp[j][1];
					}
				}
			}
			dp[i][1] += min;
		}
	}

}

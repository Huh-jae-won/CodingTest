package Step16_DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11_Q11053 {
	static int N;
	static int[] arr;
	static int[] dp;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		result = 0;
		
		int min = Integer.MIN_VALUE;
		for(int i=0 ; i<N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0 ; i<N ; i++) {
			dp[i] = 1;
			for(int j=0 ; j<i ; j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}

}

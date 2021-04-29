package Step16_DP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N11_Q11053BB {
	static int N;
	static int[] num;
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		num = new int[N+1];
		dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<N+1 ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 0;
		int max = Integer.MIN_VALUE;
		for(int i=1 ; i<N+1 ; i++) {
			int min = 0;
			dp[i] = 1;
			for(int j=1 ; j<i ; j++) {
				if(num[i]>num[j]) {
					if(min<dp[j]) {
						min = dp[j];
					}
				}
			}
			dp[i] += min;
			if(dp[i]>max)
				max = dp[i];
		}
		System.out.println(max);
	}

}

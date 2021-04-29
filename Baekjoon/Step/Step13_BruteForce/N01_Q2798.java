package Step13_BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N01_Q2798 {
	static int N;
	static int M;
	static int[] card;
	static boolean[] flag;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		card = new int[N];
		flag = new boolean[N];
		max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		System.out.println(max);
	}
	static int sum() {
		int sum = 0;
		for(int i=0 ; i<N ; i++) {
			if(flag[i])
				sum += card[i];
		}
		return sum;
	}
	static void dfs(int dep, int bef) {
		if(dep==3) {
			int sum = sum();
			if(sum<=M)
				max = Math.max(sum, max);
		}else {
			for(int i=bef ; i<N ; i++) {
				if(!flag[i]) {
					flag[i] = true;
					dfs(dep+1,i+1);
					flag[i] = false;
				}
			}
		}
	}

}

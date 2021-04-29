package Step17_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N01_Q11047 {
	static int N;
	static int K;
	static int cntCoin;
	static int[] value;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cntCoin = 0;
		value = new int[N];
		for(int i=N-1 ; i>-1 ; i--) {
			// 내림차순으로 정리
			value[i] = Integer.parseInt(br.readLine());
		}
		int leftK = K;
		while(leftK!=0) {
			for(int i=0 ; i<N ; i++) {
				if(value[i]<=leftK) {
					leftK = countCoin(value[i], leftK);
				}
			}
		}
		System.out.println(cntCoin);

	}
	static int countCoin(int value,int leftK) {
		while(leftK-value>=0) {
			cntCoin++;
			leftK -= value;
		}
		return leftK;
	}

}

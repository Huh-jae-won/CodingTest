package Step16_DP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N04_Q9461BB {
	static int N;
	static long[] P;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase =Integer.parseInt(br.readLine());
		P = new long[101];
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		P[4] = 2;
		P[5] = 2;
		for(int tc=1 ; tc<=testCase ; tc++) {
			N = Integer.parseInt(br.readLine());
			if(P[N]!=0) {
				bw.write(P[N]+"\n");
			}else {
				if(N<6) {
					bw.write(P[N]+"\n");
				}else {
					for(int i=6 ; i<=N ; i++) {
						P[i] = P[i-1] + P[i-5];
					}
					bw.write(P[N]+"\n");
				}
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}

}

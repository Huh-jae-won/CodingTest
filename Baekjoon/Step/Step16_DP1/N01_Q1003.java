package Step16_DP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class N01_Q1003 {
	static int tc = 0;
	static int[] oneCnt;
	static int[] zeroCnt;
	static int maxN = 2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		tc = Integer.parseInt(br.readLine().trim());
		int N = 0;
		oneCnt = new int[41];
		zeroCnt = new int[41];
		oneCnt[1] = 1;
		zeroCnt[0] = 1;
		oneCnt[2] = 1;
		zeroCnt[2] = 1;
		for(int testCase=1 ; testCase<=tc ; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			if(N>1) {
				if(N>maxN) {
					fibo(N);
					maxN = N;
//					System.out.print("1 :");
					bw.write(zeroCnt[N]+" "+oneCnt[N]+"\n");
				}else {
//					System.out.print("2 : ");
					bw.write(zeroCnt[N]+" "+oneCnt[N]+"\n");
				}
			}else {
				if(N==0) {
					bw.write("1 0\n");
				}else if(N==1) {
					bw.write("0 1\n");
				}
			}
		}
		br.close();
		bw.close();
	}
	static void fibo(int n) {
		for(int i=maxN+1 ; i<=n ; i++) {
			zeroCnt[i] = zeroCnt[i-1] + zeroCnt[i-2];
			oneCnt[i] = oneCnt[i-1] + oneCnt[i-2];
		}
	}

}

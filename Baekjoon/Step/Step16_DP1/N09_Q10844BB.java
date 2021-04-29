package Step16_DP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N09_Q10844BB {
	static int N;
	static long result;
	static long[][] arr;
	static int mod=1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		arr = new long[N+1][10];
//		arr[i][j] : i번째자리의 수가 j 일때 경우의 수
		for(int j=1 ; j<10 ; j++) {
			arr[1][j] = 1;
		}
		long result = stepNum();
		bw.write(result%mod +"\n");
		bw.flush();
		br.close();
		bw.close();
	}
	static long stepNum() {
		long result = 0;
		for(int i=2 ; i<N+1 ; i++) {
			for(int j=0 ; j<10 ; j++) {
				if(j==0) {
					arr[i][j] = arr[i-1][1]%mod;
				}else if(j==9) {
					arr[i][j] = arr[i-1][8]%mod;
				}else {
					arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1])%mod;
				}
			}
		}
		for(int j=0 ; j<10 ; j++) {
			result += arr[N][j];
		}
		return result;
	}
}

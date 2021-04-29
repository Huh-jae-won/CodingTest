package Step16_DP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N10_Q2156 {
	static int N;
	static int[] wine;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine().trim());
		wine = new int[N+1];
		arr = new int[N+1];
		for(int i=1 ; i<N+1 ; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		arr[1] = wine[1];
		if(N>=2)
			arr[2] = wine[1] + wine[2];
		dp();
		bw.write(arr[N]+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
	static void dp() {
		for(int i=3 ; i<N+1 ; i++) {
			int temp = Math.max(arr[i-1], arr[i-2]+wine[i]);
			arr[i] = Math.max(temp, wine[i]+wine[i-1]+arr[i-3]);
		}
	}

}

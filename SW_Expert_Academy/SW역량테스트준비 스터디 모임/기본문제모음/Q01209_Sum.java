package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Q01209_Sum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01209_Sum a = new Q01209_Sum();
		a.solution();
	}
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc=1 ; tc<=10 ; tc++) {
			StringTokenizer st;
			int N = Integer.parseInt(br.readLine());
			int rowSum = 0;
			int colSum = 0;
			int leftDiaSum = 0;
			int rightDiaSum = 0;
			int[][] arr = new int[100][100];
			for(int i=0 ; i<100 ; i++) {
				int tempRowSum = 0;
				st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<100 ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					tempRowSum += arr[i][j];
				}
				rowSum = Math.max(tempRowSum, rowSum);
			}
			for(int j=0 ; j<100 ; j++) {
				int tempColSum = 0;
				for(int i=0 ; i<100 ; i++) {
					tempColSum += arr[i][j];
				}
				colSum = Math.max(tempColSum, colSum);
			}
			for(int i=0 ; i<100 ; i++) {
				leftDiaSum += arr[i][i];
				rightDiaSum += arr[i][99-i];
			}
			int ret = Math.max(Math.max(colSum, rowSum), Math.max(leftDiaSum, rightDiaSum));
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
}

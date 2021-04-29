package Step16_DP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N06_Q1932BB {
	static int N;
	static int[][] tower;
	static int[][] max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tower = new int[N][N];
		max = new int[N][N];
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<=i ; j++) {
				tower[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max[0][0] = tower[0][0];
		maxNum();
		int result = findMax();
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
	static int findMax() {
		int result = Integer.MIN_VALUE;
		for(int j=0 ; j<N ; j++) {
			if(max[N-1][j]>result) {
				result = max[N-1][j];
			}
		}
		return result;
	}
	
	static void max(int row, int col) {
		if(col==0) {
			max[row][col] = max[row-1][col] + tower[row][col];
		}else {
			int bigger = Math.max(max[row-1][col-1], max[row-1][col]);
			max[row][col] = bigger + tower[row][col];
		}
		
	}
	
	static void maxNum() {
		for(int i=1 ; i<N ; i++) {
			for(int j=0 ; j<=i ; j++) {
				max(i,j);
			}
		}
	}
}

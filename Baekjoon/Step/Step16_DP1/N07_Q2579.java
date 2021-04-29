package Step16_DP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N07_Q2579 {
	static int N;
	static int[] step;
	static int[][] max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine().trim());
		step = new int[N];
		max = new int[2][N];
		for(int i=0 ; i<N ; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		// 행 : 0:연속0회(다음꺼 or 다다음꺼 선택가능), 1:연속1회(다다음꺼만 선택가능)
		// 열 : 현재위치
		// 값 : 현재위치일때의 누적 합
		max[0][0] = step[0];
		if(N>=2) {
			max[0][1] = step[1];
			max[1][1] = max[0][0]+step[1];
			if(N>2){
				sumMax();
			}
			bw.write(Math.max(max[0][N-1], max[1][N-1])+"\n");
		}else {
			bw.write(step[0]+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
		
	}
	static void max(int row, int col) {
		if(row==0) {
			max[row][col] = step[col] + Math.max(max[0][col-2],max[1][col-2]);
		}else {
			max[row][col] = step[col] + max[0][col-1];
		}
	}
	static void sumMax() {
		for(int col=2 ; col<N ; col++) {
			for(int row=0 ; row<2 ; row++) {
				max(row,col);
			}
		}
	}
}

package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q01220_Magnetic {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01220_Magnetic a = new Q01220_Magnetic();
		a.solution();
	}
	int N = 0;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = 10;
		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] table = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ret = move(table);
			bw.write("#"+tc+" "+ret+"\n");
		}
		bw.close();
		br.close();
	}
	private int move(int[][] table) {
		int ret = 0;
		for(int j=0 ; j<N ; j++) {
			int deadlock = 0;
			for(int i=0 ; i<N ; i++) {
				if(table[i][j]==1) {
					deadlock++;
				}
				if(table[i][j]==2 && deadlock!=0) {
					deadlock = 0;
					ret++;
				}
			}
		}
		return ret;
	}
	
	private void printArr(int[][] table) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(table[i][j]+"");
			}
			System.out.println();
		}
		for(int i=0 ; i<N ; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

}

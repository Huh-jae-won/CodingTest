package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10026 {
	static int N;
	static boolean flag[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		flag = new boolean[N][N];
		char[][] mapA = new char[N][N];
		char[][] mapB = new char[N][N];
		for(int i=0 ; i<N ; i++) {
			String str = br.readLine().trim();
			for(int j=0 ; j<N ; j++) {
				char temp = str.charAt(j);
				mapA[i][j] = temp;
				if(temp=='G')
					mapB[i][j] = 'R';
				else
					mapB[i][j] = temp;
			}
		}
	}
	static void dfs() {
		
	}
}

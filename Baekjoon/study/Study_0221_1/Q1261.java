package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1261 {
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	// ÇÏÁÂ»ó¿ì
	static int[] dN = { 1,  0, -1, 0};
	static int[] dM = { 0, -1,  0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int i=1 ; i<N+1 ; i++) {
			StringBuffer str = new StringBuffer(br.readLine());
			for(int j=1 ; j<M+1 ; j++) {
					map[i][j] = Integer.parseInt(str.charAt(j-1)+"");
			}
		}
		dfs(1,1,0);
		System.out.println(min);
	}
	
	static void dfs(int n, int m, int cnt) {
		int nN;
		int nM;
		if(n==N && m==M) {
			min = Math.min(min, cnt);
			return;
		}else {
			if(cnt>min)
				return;
			for(int i=0 ; i<4 ; i++) {
				nN = n + dN[i];
				nM = m + dM[i];
				if(nN>0 && nN<N+1 && nM>0 && nM<M+1 && !visited[nN][nM]) {
					visited[nN][nM] = true;
					if(map[nN][nM]==1)
						dfs(nN,nM,cnt+1);
					else
						dfs(nN,nM,cnt);
					visited[nN][nM] = false;
				}
			}
		}
	}

}

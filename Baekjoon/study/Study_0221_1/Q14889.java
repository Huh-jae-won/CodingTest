package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {
	static int N;
	static int[][] map;
	static boolean[] flag;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		flag = new boolean[N+1];
		result = Integer.MAX_VALUE;
		
		for(int i=1 ; i<N+1 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1 ; j<N+1 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(result);
		

	}
	static int Synergy() {
		int teamA = 0;
		int teamB = 0;
		for(int i=1 ; i<N+1 ; i++) {
			if(flag[i]) {
				for(int j=i+1 ; j<N+1 ; j++) {
					if(flag[j]) {
						teamA += map[i][j];
						teamA += map[j][i];
					}
				}
			}else {
				for(int j=i+1 ; j<N+1 ; j++) {
					if(!flag[j]) {
						teamB += map[i][j];
						teamB += map[j][i];
					}
				}
			}
		}
		int result = Math.abs(teamA-teamB);
		return result;
	}
	
	static void dfs(int dep,int bef) {
		if(dep==N/2) {
			int temp = Synergy();
			result = Math.min(temp, result);
		}else {
			for(int i=bef+1 ; i<N+1 ; i++) {
				if(!flag[i]) {
					flag[i] = true;
					dfs(dep+1,i);
					flag[i] = false;
				}
			}
		}
	}
	static void print() {
		for(int i=1 ; i<N+1 ; i++) {
			for(int j=1 ; j<N+1 ; j++) {
				System.out.printf("%2d ",map[i][j]);
			}
			System.out.println();
		}
	}

}

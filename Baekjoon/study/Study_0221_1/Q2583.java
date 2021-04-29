package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2583 {
	static int M;
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Area> q;
	static int[] dRow = {0, 0, 1, 1};
	static int[] dCol = {0, 1, 0, 1};
	
	// 상 하 좌 우
	static int[] dM = {-1, 1,  0, 0};
	static int[] dN = { 0, 0, -1, 1};
	
	
	
	static class Area{
		int area;
		Area(int area){
			this.area = area;
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("실패");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M+1][N+1];
		visited = new boolean[M+1][N+1];
		q = new LinkedList();
		
		for(int p=0 ; p<K ; p++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i=y1 ; i<=y2 ; i++) {
				for(int j=x1 ; j<=x2 ; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		int ret = 0;
		for(int i=0 ; i<M ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(checkArea(i,j)==1 && !visited[i][j]) {
					Area temp = new Area(0);
					q.add(temp);
					dfs(temp, i, j);
				}
			}
		}
		ArrayList list = new ArrayList();
		while(!q.isEmpty()) {
			Area area = q.poll();
			list.add(area.area);
		}
		list.sort(null);
		System.out.println(list.size());
		for(int i=0 ; i<list.size(); i++) {			
			System.out.print(list.get(i));
			if(i<list.size()-1)
				System.out.print(" ");
		}
	}
	static void dfs(Area area, int row, int col) {
		visited[row][col] = true;
		area.area++;
		int nRow;
		int nCol;
		for(int i=0 ; i<4 ; i++) {
			nRow = row + dM[i];
			nCol = col + dN[i];
			if(nRow>-1 && nRow<M && nCol>-1 && nCol<N && !visited[nRow][nCol]) {
				if(checkArea(nRow,nCol)==1) {
					dfs(area,nRow,nCol);
				}
			}
		}
	}
	
	static int checkArea(int row, int col) {
		int[] nRow = new int[4];
		int[] nCol = new int[4];
		for(int i=0 ; i<4 ; i++) {
			// r,c-우-하-우하
			nRow[i] = row + dRow[i];
			nCol[i] = col + dCol[i];
		}
		int temp = 1;
		for(int i=0 ; i<4 ; i++) {
			temp *= map[nRow[i]][nCol[i]];
		}
		if(temp==1)
			return 0;
		else
			return 1;
	}
}

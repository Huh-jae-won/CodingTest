package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1261_2 {
	static int N;
	static int M;
	static int min;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Node> q;
	// ÇÏÁÂ»ó¿ì
	static int[] dN = { 1,  0, -1, 0};
	static int[] dM = { 0, -1,  0, 1};

	static class Node{
		int row;
		int col;
		int cnt;
		Node(int row, int col, int cnt){
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		min = Integer.MAX_VALUE;
		
		q = new LinkedList();
		
		for(int i=1 ; i<N+1 ; i++) {
			StringBuffer str = new StringBuffer(br.readLine());
			for(int j=1 ; j<M+1 ; j++) {
				map[i][j] = Integer.parseInt(str.charAt(i-1)+"");
			}
		}
		q.add(new Node(1,1,0));
		bfs();
	}
	static void bfs() {
		Node temp = null;
		while(!q.isEmpty()) {
			temp = q.poll();
			int nN;
			int nM;
			if(temp.row==N && temp.col==M) {
				System.out.println("min : "+min+", temp : "+temp.cnt);
				min = Math.min(min, temp.cnt);
				if(min<temp.cnt) {
					break;
				}
			}
			if(min<temp.cnt) {
				continue;
			}
			for(int i=0 ; i<4 ; i++) {
				nN = temp.row + dN[i];
				nM = temp.col + dM[i];
				if(nN>0 && nN<N && nM>0 && nM<M) {
					if(map[nN][nM]==1) {
						q.add(new Node(nN,nM,temp.cnt+1));
					}else
						q.add(new Node(nN,nM,temp.cnt));
				}
			}
		}
		
	}
}

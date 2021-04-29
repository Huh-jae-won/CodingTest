package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1175_2 {
	static int N;
	static int M;
	static int minRoute;
	//					 R, D,  L,  U
	static int[] dRow = {0, 1,  0, -1};
	static int[] dCol = {1, 0, -1,  0};
	
	static String[][] map;
	static Queue<Node> q;
	static class Node{
		String str;
		int way;
		int[] pos;
		boolean[][] visited;
		Node(String str,int way, int[] pos, boolean[][] visited){
			this.str = str;
			this.way = way;
			this.pos = pos;
			this.visited = visited;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minRoute = Integer.MAX_VALUE;
		
		map = new String[N][M];
		q = new LinkedList();
		makeMap(br);
		bfs();
		if(minRoute==Integer.MAX_VALUE)
			System.out.println(-1);
	}
	static void bfs() {
		Node temp = null;
		while(!q.isEmpty()) {
			temp = q.poll();
			if(countC(temp.str)==2) {
//				System.out.printf("[%d,%d] : %s\n",temp.pos[0],temp.pos[1],temp.str);
				minRoute = Integer.min(minRoute, temp.str.length());
				if(minRoute<=temp.str.length()) {
					System.out.println(minRoute);
					break;
				}
			}else {
				int row = temp.pos[0];
				int col = temp.pos[1];
				for(int i=0 ; i<4 ; i++) {
					if(i==temp.way)
						continue;
					int nRow = row + dRow[i];
					int nCol = col + dCol[i];
					if(chkRange(nRow, nCol) && !temp.visited[nRow][nCol]) {
						int[] pos = {nRow,nCol};
						boolean[][] visited = new boolean[N][M];
						copyArr(temp.visited,visited);
						visited[nRow][nCol] = true;
//						System.out.print(temp.str+map[nRow][nCol]+" ");
						q.add(new Node(temp.str+map[nRow][nCol],i,pos,visited));
					}
				}
				System.out.println();
				temp = null;
			}
		}
	}
	
	static void copyArr(boolean[][] src, boolean[][] desti) {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				desti[i][j] = src[i][j];
			}
		}
	}
	
	static boolean chkRange(int row, int col) {
		if(row>-1 && row<N && col>-1 && col<M) {
			return true;
		}
		return false;
	}
	
	static int countC(String str) {
		int cnt = 0;
		for(int i=0 ; i<str.length() ; i++) {
			if(str.charAt(i)=='C')
				cnt++;
		}
		return cnt;
	}
	
	static void makeMap(BufferedReader br) throws IOException {
		boolean[][] visited = new boolean[N][M];
		int[] temp = new int[2];
		for(int i=0 ; i<N ; i++) {
			String line = br.readLine();
			for(int j=0 ; j<M ; j++) {
				String str = line.charAt(j)+"";
				map[i][j] = str;
				if(str.equals("S")) {
					visited[i][j] = true;
					temp[0] = i;
					temp[1] = j;
					q.add(new Node("",-1,temp,visited));
				}
			}
		}
	}
}

package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1194 {
	// 실패
	
	static char[][] map;
	static boolean[][] flag;
	static int N;
	static int M;
	static int way;
	static int[] loc;
	static Queue<Node> q;
//						  상, 좌, 하, 우
	static int[] dRow = {-1,  0, 1, 0};
	static int[] dCol = { 0, -1, 0, 1};
	
	static class Node{
		int row;
		int col;
		int cnt;
		int befDirec;
		boolean[] key;
		Node(int row, int col, int cnt,boolean[] key,int befDirec){
			this.row = row;
			this.col = col;
			this.cnt = cnt;
			this.key = key;
			this.befDirec = befDirec;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		way = Integer.MAX_VALUE;
		
		map = new char[N][M];
		flag = new boolean[N][M];
		loc = new int[2];		// 현재 좌표
		q = new LinkedList();
		
		// 입력
		for(int i=0 ; i<N ; i++) {
			String temp = br.readLine().trim();
			for(int j=0 ; j<M ; j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j]=='0') {
					loc[0] = i;
					loc[1] = j;
				}
			}
		}
		print();
		
		boolean[] temp = new boolean[6];
		q.add(new Node(loc[0],loc[1],0,temp,-1));
		bfs();
	}
	
	static boolean canMove(Node temp, int direc) {
		int nRow = temp.row + dRow[direc];
		int nCol = temp.col + dCol[direc];
		if(nRow<0 || nRow>=N || nCol<0 || nCol>=M) {
			return false;
		}
		if(map[nRow][nCol]=='#') {
			// 다음 칸이 벽인 경우
			return false;
		}
		if(map[nRow][nCol]>=65 && map[nRow][nCol]<=70) {
			// 다음 칸이  A~F일 경우
			if(temp.key[map[nRow][nCol]-65]) {
				// a~f를 가지고 있을경우
				return true;
			}else
				return false;
		}
		// 다음 칸이 . or 0 or 1인 경우
		return true;
	}
	static void bfs() {
		Node temp = null;
		while(!q.isEmpty()) {
			temp = q.poll();
			int row = temp.row;
			int col = temp.col;
			// 위치가 1인경우
			if(map[row][col]=='1') {
				int minWay = temp.cnt;
				if(minWay<way) {
					way = minWay;
				}else {
					System.out.println(way);
					return;
				}
			}else {
				// 위치가 a~f (key)일 경우
				if(map[row][col]>=97 && map[row][col]<=102) {
					temp.key[map[row][col]-97] = true;
				}
				
				// 옮기는 작업
				int befDirec = temp.befDirec;
				for(int i=0 ; i<4 ; i++) {
					if(i!=befDirec && i==(befDirec%2)) {
						if(map[temp.row][temp.col]<97 && map[temp.row][temp.col]>102) {
							continue;
						}
					}
					if(canMove(temp,i)) {
						int nRow = temp.row + dRow[i];
						int nCol = temp.col + dCol[i];
						boolean[] key = new boolean[6];
						copy(temp.key,key);
						q.add(new Node(nRow,nCol,temp.cnt+1,key,i));
					}
				}
			}
		}
		System.out.println(-1);
	}
	static void copy(boolean[] src, boolean[] desti) {
		int length = src.length;
		for(int i=0 ; i<length ; i++) {
			desti[i] = src[i];
		}
	}
	static void print() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}

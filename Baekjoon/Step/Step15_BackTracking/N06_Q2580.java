package Step15_BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N06_Q2580 {
	static boolean success;
	static int[][] map;
	static int N;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = 9;
		map = new int[N][N];
		list = new ArrayList();
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					int[] temp = {i,j};
					list.add(temp);
				}
			}
		}
//		for(int i=0 ; i<list.size() ; i++) {
//			System.out.println(list.get(i)[0]+" "+list.get(i)[1]);
//		}
		success = false;
		dfs(0,success);
		br.close();
	}
	static void dfs(int dep,boolean success) {
		if(dep==list.size()) {
//			printList();
			if(!success) {
				success = true;
				printMap();
			}
			return;
		}
		int row = list.get(dep)[0];
		int col = list.get(dep)[1];
		boolean[] flag = new boolean[10];
		if(isPossible(row, col,flag)) {
//			System.out.println(row+","+col+" : ");
//			for(int i=1 ; i<10 ; i++) {
//				System.out.printf("%5b ",flag[i]);
//			}
//			System.out.println();
			for(int i=1 ; i<10 ; i++) {
				if(flag[i]) {
					map[row][col] = i;
					dfs(dep+1,success);
					map[row][col] = 0;
				}
			}
		}
	}
	static boolean isPossible(int row,int col,boolean[] flag) {
		boolean ret = false;
		boolean[] flag4way = new boolean[10];
		boolean[] flagSquare = new boolean[10];
		ret = chk4way(row,col,flag4way);
		if(ret) {
			ret = chkSquare(row,col,flagSquare);
			if(ret) {
				for(int i=1 ; i<10 ; i++) {
					if(flag4way[i]&&!flagSquare[i]) {
						// 4way는 사용가능한 수가 true
						// Squa는 사용가능한 수가 false
						flag[i] = true;
					}
				}
			}
		}
		return ret;
	}
	static boolean chk4way(int row, int col,boolean[] flag) {
		boolean[] flagCol = new boolean[10];
		boolean[] flagRow = new boolean[10];
		for(int j=0 ; j<N ; j++) {
			if(map[row][j]==0)
				continue;
			if(!flagCol[map[row][j]]) {
				// 숫자존재하면 true -> 사용하면안되는 수
				flagCol[map[row][j]] = true;
			}else
				return false;
		}
		for(int i=0 ; i<N ; i++) {
			if(map[i][col]==0)
				continue;
			if(!flagRow[map[i][col]]) {
				// 숫자존재하면 true -> 사용하면안되는 수
				flagRow[map[i][col]] = true;
			}else
				return false;
		}
		for(int i=1 ; i<10 ; i++) {
			if(!flagCol[i]&&!flagRow[i]) {
				// 둘다 false여야 사용가능한 수
				flag[i] = true;
			}
		}
		return true;
	}
	static boolean chkSquare(int row, int col,boolean[] flag) {
		int rowIndx = row/3;
		int colIndx = col/3;
		for(int i=rowIndx*3 ; i<rowIndx*3+3 ; i++) {
			for(int j=colIndx*3 ; j<colIndx*3+3 ; j++) {
				if(map[i][j]==0)
					continue;
				if(!flag[map[i][j]]) {
					flag[map[i][j]] = true;
				}else
					return false;
			}
		}
		return true;
	}
	static void printList() {
		for(int i=0 ; i<list.size() ; i++) {
			int row = list.get(i)[0];
			int col = list.get(i)[1];
			System.out.printf("%d %d : %d\n",row,col,map[row][col]);
		}
	}
	static void printMap() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(j==N-1) {
					System.out.println(map[i][j]);
				}else {
					System.out.print(map[i][j]+" ");
				}
			}
		}
	}
}

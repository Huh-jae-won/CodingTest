package Step15_BackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class N05_Q9663 {
	static int N;
	static int result;
					  // »ó, ÁÂ»ó, ¿ì»ó
	static int[] dRow = {-1, -1,  -1};
	static int[] dCol = { 0, -1,   1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		result = 0;
		int[][] map = new int[N][N];
		dfs(0,-10,map);
		System.out.println(result);
	}
	static boolean possible(int row, int col,int[][] map) {
		int length = dRow.length;
		if(map[row][col]!=0) {
			return false;
		}
		for(int i=0 ; i<length ; i++) {
			int nRow = row;
			int nCol = col;
			while(true){
				nRow += dRow[i];
				nCol += dCol[i];
				if(nRow<0 || nRow>N-1 || nCol<0 || nCol>N-1) {
					break;
				}
				if(map[nRow][nCol]==1) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void dfs(int dep,int befJ,int[][] map) {
		if(dep==N) {
//			printMap();
//			System.out.println();
			result++;
		}else {
			int i=dep;
			for(int j=0 ; j<N ; j++) {
				if(j==befJ || i==dep&&(j==befJ-1||j==befJ+1)) {
					continue;
				}
				if(map[i][j]==0) {
					if(!possible(i, j,map)) {
						continue;
					}
					map[i][j] = 1;
					dfs(dep+1,j,map);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void printMap(int[][] map) {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}

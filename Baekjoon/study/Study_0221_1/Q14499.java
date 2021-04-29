package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14499 {
	static int N;
	static int M;
	static int K;
	static int[][] map;
	static int[] order;
	static int[] diceRow;
	static int[] diceCol;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		order = new int[K];
		diceRow = new int[4];
		diceCol = new int[4];
		// - 북 -
		// 서 위 동 뒤
		// - 남 -
		// - 뒤 -
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<K ; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
//		printMap();
		int[] nDirec = new int[2];
		for(int i=0 ; i<K ; i++) {
			nDirec = move(order[i],row,col);
			row = nDirec[0];
			col = nDirec[1];
		}
		
	}
	
	static void change(int row, int col) {
		if(map[row][col]==0) {
			map[row][col] = diceRow[3];
		}else {
			diceRow[3] = map[row][col];
			diceCol[3] = map[row][col];
			map[row][col] = 0;
		}
	}
	
	static boolean check(int direc, int row, int col) {
		boolean flag = true;
		switch (direc) {
		case 3 :	// 북쪽(위)
			if(row==0)
				flag = false;
			break;
		case 4 :	// 남쪽(아래)
			if(row==N-1)
				flag = false;
			break;
		case 1 :	// 동쪽(오른)
			if(col==M-1)
				flag = false;
			break;
		case 2 :	// 서쪽(왼)
			if(col==0)
				flag = false;
			break;
		default:
			break;
		}
		return flag;
	}
	
	static int[] move(int direc,int row, int col) {
//		(row, col) 에서 (nRow,nCol)로 이동
		int nRow = row;
		int nCol = col;
		if(check(direc,row,col)) {
			int temp;
			switch (direc) {
			case 3 :
				temp = diceRow[0];
				for(int i=1 ; i<4 ; i--) {
					diceRow[i-1] = diceRow[i];
				}
				diceRow[3] = temp;
				diceCol[1] = diceRow[1];
				diceCol[3] = temp;
				
				nRow--;
				break;
			case 4 :
				temp = diceRow[3];
				for(int i=3 ; i>0 ; i--) {
					diceRow[i] = diceRow[i-1];
				}
				diceRow[0] = temp;
				diceCol[1] = diceRow[1];
				diceCol[3] = temp;
				
				nRow++;
				break;
			case 1 :
				temp = diceCol[3];
				for(int i=3 ; i>0 ; i--) {
					diceCol[i] = diceCol[i-1];
				}
				diceCol[0] = temp;
				diceRow[1] = diceCol[1];
				diceRow[3] = temp;
				
				nCol++;
				break;
			case 2 :
				temp = diceCol[0];
				for(int i=1 ; i<4 ; i--) {
					diceCol[i-1] = diceCol[i];
				}
				diceCol[3] = temp;
				diceRow[1] = diceCol[1];
				diceRow[3] = temp;
				
				nCol--;
				break;
			default:
				break;
			}
			change(nRow,nCol);
			System.out.println(diceRow[1]);
		}
		int[] arr = {nRow,nCol};
		return arr;
	}
	
	static void printMap() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}

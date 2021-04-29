package Step13_BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N04_Q1018 {
	static int N;
	static int M;
	static char[][] board;
	static String[] BW = {"BWBWBWBW","WBWBWBWB"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		int result = Integer.MAX_VALUE;
		
		for(int i=0 ; i<N ; i++) {
			String line = br.readLine().trim();
			for(int j=0 ; j<M ; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		for(int i=0 ; i<N-8+1 ; i++) {
			for(int j=0 ; j<M-8+1 ; j++) {
				int temp = makeArr(i,j);
				result = Math.min(temp, result);
			}
		}
		System.out.println(result);
	}
	
	static int makeArr(int row, int col) {
		int cntA = 0;
		int cntB = 0;
		for(int i=row ; i<row+8 ; i++) {
			int indx = 0;
			for(int j=col ; j<col+8 ; j++) {
				if(i%2==0) {
					if(BW[0].charAt(indx)!=board[i][j]) {
						cntA++;
					}
					if(BW[1].charAt(indx)!=board[i][j]) {
						cntB++;
					}
					indx++;
				}else {
					if(BW[1].charAt(indx)!=board[i][j]) {
						cntA++;
					}
					if(BW[0].charAt(indx)!=board[i][j]) {
						cntB++;
					}
					indx++;
				}
			}
		}
//		System.out.println(cntA+", "+cntB);
		return Math.min(cntA, cntB);
	}
	
	static boolean chkRange(int row, int col) {
		if(row>=0 && row<N && col>=0 && col<M) {
			return true;
		}
		return false;
	}
	
	static void printArr() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

}

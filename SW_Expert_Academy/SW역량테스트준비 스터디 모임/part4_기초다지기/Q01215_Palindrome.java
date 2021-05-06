package part4_기초다지기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q01215_Palindrome {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01215_Palindrome a = new Q01215_Palindrome();
		a.solution();
	}
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc=1 ; tc<=10 ; tc++) {
			int N = Integer.parseInt(br.readLine());
			String str0 = br.readLine();
			int len = str0.length();
			char[][] map = new char[len][len];
			map[0] = str0.toCharArray();
			for(int i=1 ; i<len ; i++) {
				map[i] = br.readLine().toCharArray();
			}
			int ret = findPalin(N,map);
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	private int findPalin(int N, char[][] map) {
		int ret = 0;
		int len = map.length;
		for(int i=0 ; i<len ; i++) {
			for(int j=0 ; j<len ; j++) {
				ret += horizonPalin(N,map,i,j);
				ret += verticalPalin(N,map,i,j);
//				System.out.printf("[%d,%d]:%d ",i,j,ret);
			}
//			System.out.println();
		}
		return ret;
	}
	private int horizonPalin(int N, char[][] map, int row, int col) {
		if(col>map.length-N)
			return 0;
		for(int i=0 ; i<N/2 ; i++) {
			if(map[row][col+i]!=map[row][N-1+col-i])
				return 0;
		}
		return 1;
	}
	private int verticalPalin(int N, char[][] map, int row, int col) {
		if(row>map.length-N)
			return 0;
		for(int i=0 ; i<N/2 ; i++) {
			if(map[row+i][col]!=map[N-1+row-i][col])
				return 0;
		}
		return 1;
	}
	private void printArr(char[][] map) {
		int len = map.length;
		for(int i=0 ; i<len; i++) {
			for(int j=0 ; j<len ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}

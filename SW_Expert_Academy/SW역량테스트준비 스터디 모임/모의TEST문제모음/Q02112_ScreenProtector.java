package 모의TEST문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q02112_ScreenProtector {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q02112_ScreenProtector a  = new Q02112_ScreenProtector();
		a.solution();
	}
	int ret = 0;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());	// 두께
			int W = Integer.parseInt(st.nextToken());	// 가로길이
			int K = Integer.parseInt(st.nextToken());	// 합격기준
			ret = Integer.MAX_VALUE;
			int[][] screen = new int[D][W];
			for(int i=0 ; i<D ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<W ; j++) {
					screen[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			System.out.printf("%d,%d,%d\n",D,W,K);
//			printScreen(screen);
			for(int i=0 ; i<D ; i++) {
//				System.out.printf("<%d>\n",i);
				if(i<ret)
					dfs(screen, 0,i, K, -1,"");
			}
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	private void dfs(int[][] screen,int dep, int inject,int K,int bef,String log) {
		if(dep==inject) {
//			System.out.println(log);
			if(test(screen,K) && inject<ret) {
//				System.out.println("성공");
				ret = inject;
			}
			return;
		}
		int len = screen.length;
		for(int i=bef+1 ; i<len ; i++) {
			int[] rec = inject(screen, i, 0);
			dfs(screen, dep+1, inject, K, i,log+"("+i+":0)"+" ");
			recover(screen, i, rec);
		}
		for(int i=bef+1 ; i<len ; i++) {
			int[] rec = inject(screen, i, 1);
			dfs(screen, dep+1, inject, K, i,log+"("+i+","+1+")"+" ");
			recover(screen, i, rec);
		}
		return ;
	}
	private void recover(int[][] screen, int row, int[] rec) {
		int len = screen[0].length;
		for(int j=0 ; j<len ; j++) {
			screen[row][j] = rec[j];
		}
	}
	
	private int[] inject(int[][] screen, int row, int num) {
		int len = screen[0].length;
		int temp[] = new int[len];
		for(int j=0 ; j<len ; j++) {
			temp[j] = screen[row][j];
			screen[row][j] = num;
		}
		return temp;
	}
	
	private boolean test(int[][] screen, int K) {
//		printScreen(screen);
//		System.out.println();
		int colLen = screen[0].length;
		int rowLen = screen.length;
		for(int j=0 ; j<colLen ; j++) {
			int cnt = 1;
			int bef = screen[0][j]; 
			for(int i=1 ; i<rowLen ; i++) {
				if(screen[i][j]==bef) {
					cnt++;
				}else {
					cnt = 1;
					bef = screen[i][j];
				}
				if(cnt>=K) {
					break;
				}
			}
			if(cnt<K) {
				return false;
			}
		}
		return true;
	}
	
	private void printArr(int[] arr) {
		System.out.print("A : ");
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	private void printScreen(int[][] screen) {
		for(int i=0 ; i<screen.length ; i++) {
			for(int j=0 ; j<screen[i].length ; j++) {
				System.out.print(screen[i][j]+" ");
			}
			System.out.println();
		}
	}

}

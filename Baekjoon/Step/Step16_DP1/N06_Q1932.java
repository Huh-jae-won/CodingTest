package Step16_DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N06_Q1932 {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0 ; j<=i ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] result = new int[N];
		for(int i=1 ; i<N ; i++) {
			for(int j=0 ; j<=i ; j++) {
				if(j==0) {
					arr[i][j] += arr[i-1][j];
				}else if(j==i){
					arr[i][j] += arr[i-1][j-1];
				}else {
					arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
				}
			}
		}
		printMax();
	}
	static void printMax() {
		int max = Integer.MIN_VALUE;
		for(int j=0 ; j<N ; j++) {
			if(max<arr[N-1][j])
				max = arr[N-1][j];
		}
		System.out.println(max);
	}
	
	static void printArr() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<=i ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}



















package 모의TEST문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q02115_HoneyHavesting {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q02115_HoneyHavesting a = new Q02115_HoneyHavesting();
		a.solution();
	}
	int N = 0;
	int M = 0;
	int C = 0;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());  
			N = Integer.parseInt(st.nextToken());	// arr사이즈
			M = Integer.parseInt(st.nextToken());	// 벌통 갯수
			C = Integer.parseInt(st.nextToken());	// 1회 최대양
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ret = 0;
			for (int i = 0; i<N; i++) {
				for (int j=0; j<N-M+1; j++) {
					int[] tank1 = {i,j};
					ret = Math.max(ret,harvest(arr, tank1));
				}
			}
			
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	private int harvest(int[][] arr, int[] tank1) {
		int profit1 = makeProfit(arr,tank1);
//		System.out.printf("<%d,%d : %d>\n",tank1[0],tank1[1],profit1);
		int profit2 = 0;
		int row = tank1[0];
		int col = tank1[1];
		// tank1, tank2가 같은 행에 존재
		for(int j=col+M ; j<N-M+1 ; j++) {
			int[] tank2 = {row,j};
			int profit = makeProfit(arr,tank2);
//			System.out.printf("[%d,%d : %d], ",tank2[0],tank2[1],profit);
			profit2 = Math.max(profit2,profit);
		}
//		System.out.println();
		
		// tank2가 tank1보다 아래행에서
		for (int i=tank1[0]+1; i<N ; i++) {
			for (int j=0; j<N-M+1; j++) {
				int[] tank2 = {i,j};
				int profit = makeProfit(arr, tank2);
//				System.out.printf("[%d,%d : %d], ",tank2[0],tank2[1],profit);
				profit2 = Math.max(profit2, profit);
			}
//			System.out.println();
		}
//		System.out.println();
		return profit1+profit2;
	}	
	private int makeProfit(int[][] arr, int[] tank) {
		int[] temp = new int[M];
		boolean[] visited = new boolean[M];
		
		int row = tank[0];
		int col = tank[1];
		for(int i=0 ; i<M ; i++) {
			temp[i] = arr[row][i+col];
		}
		int profit = dfs(temp, visited, 0, 0);
		return profit;
	}
	private int dfs(int[] temp,boolean[] visited, int dep, int bef) {
		int sum = 0;
		int profit = 0;
		if(dep<=M) {
			for(int i=0 ; i<M ; i++) {
				if(visited[i]) {
					sum += temp[i];
				}
			}
			if(sum>C)
				return 0;
			if(sum>0)
				profit = getProfit(temp, visited);
		}
		for (int i=bef; i<temp.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				profit = Math.max(profit,dfs(temp,visited,dep+1,i));
				visited[i] = false;
			}
		}
		return profit;
	}
	private int getProfit(int[] temp, boolean[] visited) {
		int profit = 0;
		for(int i=0 ; i<M ; i++) {
			if(visited[i]) {
				profit += temp[i]*temp[i];
			}
		}
		return profit;
	}
	
	private int sumTank(int[][] arr, int[] tank) {
		// 말통이 채취할수 있는 꿀의 합
		int sum = 0;
		for(int j=tank[1] ; j<tank[1]+M ; j++) {
			sum += arr[tank[0]][j];
		}
		return sum;
	}
	
	private boolean inRange(int row, int col) {
		if(row>=0 && row<N && col>=0 && col<N)
			return true;
		return false;
	}
	
	private void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

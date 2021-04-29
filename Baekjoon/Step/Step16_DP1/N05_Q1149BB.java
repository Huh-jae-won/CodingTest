package Step16_DP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class N05_Q1149BB {
	static int N;
	static int[][] cost;
	static int[][] money;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		money = new int[N][3];
		
		StringTokenizer st;
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		money[0][0] = cost[0][0];
		money[0][1] = cost[0][1];
		money[0][2] = cost[0][2];
		int result = MinCost();
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
	static int min(int row,int col) {
		int befMin = Math.min(money[row-1][(col+1)%3], money[row-1][(col+2)%3]);
		return befMin+cost[row][col];
	}
	
	static int MinCost() {
		for(int i=1 ; i<N ; i++) {
			for(int j=0 ; j<3 ; j++) {
				money[i][j] = min(i,j);
			}
		}
		return Math.min(Math.min(money[N-1][0],money[N-1][1]), money[N-1][2]);
	}

}

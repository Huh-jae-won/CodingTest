package 모의TEST문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q02117_SecurityService {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q02117_SecurityService a = new Q02117_SecurityService();
		a.solution();
	}
	int N = 0;
	int M = 0;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[][] area = new int[N][N];
			int hIndx = 0;
			// area, house 초기화
			for(int i=0 ; i<N ; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N ; j++) {
					area[i][j] = Integer.parseInt(st.nextToken());
					if(area[i][j] == 1) {
						hIndx++;
					}
				}
			}
			
			int k = 1;
			int ret = 0;
			while(k<=N+1) {
//				System.out.println("< k = "+k+" >_"+getCost(k));
				int cost = getCost(k);
				// k에 맞는 구역 설정
				int[][] region;
				region = makeRegion(0, 0, k);
				int bRow = 0;
				int bCol = 0;
				int j=0;
				int partMaxProfit = -1;
				for(int i=0 ; i<N ; j++) {
					if(j==N) {
						i++;
						j=-1;
//						System.out.println();
						continue;
					}
//					System.out.printf("(%d,%d) ",i,j);
					moveRegion(region, bRow, bCol, i, j);
					int numOfHouse = charge(area, region);
					int profit = numOfHouse*M - cost;
					partMaxProfit = Math.max(profit, partMaxProfit);
					if(profit>=0) {
//						System.out.printf("k:%d [ %d,%d ] (h=%d)\n",k,i,j,numOfHouse);
						ret = Math.max(numOfHouse,ret);
					}
					bRow = i;
					bCol = j;
				}
//				if(partMaxProfit<0)
//					break;
				k++;
			}
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	private int charge(int[][] arr,int[][] region) {
		int numOfhouse = 0;
		for(int[] r : region) {
			if(inRange(r[0], r[1]) && arr[r[0]][r[1]]==1)
				numOfhouse++;
		}
		return numOfhouse;
	}
	
	private void moveRegion(int[][] region, int bRow, int bCol, int row, int col){
		int dRow = row - bRow;
		int dCol = col - bCol;
		int len = region.length;
		for(int i=0 ; i<len ; i++) {
			region[i][0] = region[i][0] + dRow;
			region[i][1] = region[i][1] + dCol;
		}
//		System.out.print("move : ");
//		printArr(region);
	}
	private int[][] makeRegion(int row, int col, int k){
		int cost = getCost(k);
		int[][] ret = new int[cost][2];
		int indx = 0;
		for(int i=row-k+1 ; i<row+k ; i++) {
			for(int j=col-k+1 ; j<col+k ; j++) {
				if(Math.abs(i)+Math.abs(j)<k) {
					ret[indx][0] = i;
					ret[indx][1] = j;
					indx++;
				}
			}
		}
//		System.out.print("make : ");
//		printArr(ret);
		return ret;
	}
	private int getCost(int k) {
		return k*k + (k-1)*(k-1);
	}
	private boolean inRange(int row, int col) {
		if(row>=0 && row<N && col>=0 && col<N)
			return true;
		return false;
	}
	
	
	private void printArr(int[][] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			System.out.printf("[%2d,%2d] ",arr[i][0],arr[i][1]);
		}
		System.out.println();
	}
}

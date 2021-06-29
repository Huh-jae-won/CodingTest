package D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q01249_SupplyRoute {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01249_SupplyRoute z = new Q01249_SupplyRoute();
		z.solution();
	}	

	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for(int i=0 ; i<N ; i++) {
				String s = br.readLine();
				for(int j=0 ; j<s.length() ; j++) {
					map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
				}
			}
//			printMap(map);
//			System.out.println("=============");
			int ret = bfs(map);
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	private int bfs(int[][] map) {
		int N = map.length;
		int[][] ret = new int[N][N];
		for(int[]arr : ret) {
			Arrays.fill(arr, -1);
		}
		ret[0][0] = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0});
		int bef = 0;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int row = temp[0];
			int col = temp[1];
			for(int[] dir : dirs) {
				int nRow = row + dir[0];
				int nCol = col + dir[1];
				if(inRange(N,nRow,nCol)) {
					// 다음칸이 조건을 만족한다면 ret에 값을 넣고 q에 offer
					// ret[row][col] : 확인한 칸의 누적값
					if(ret[nRow][nCol]==-1) {
						// 처음 도착했다면
						ret[nRow][nCol] = map[nRow][nCol]+ret[row][col];
						q.offer(new int[] {nRow,nCol});
					}else if(ret[nRow][nCol]<=map[nRow][nCol]+ret[row][col]){
						// 기존에 구한값이 더 작은 경우
						continue;
					}else {
						// 새로 구한 길이 더 작은 경우
						ret[nRow][nCol] = map[nRow][nCol]+ret[row][col];
						q.offer(new int[] {nRow,nCol});
					}
				}
			}

		}
//		printMap(ret);
		return ret[N-1][N-1];
	}
	private boolean inRange(int N, int nRow, int nCol) {
		if(nRow>=0 && nRow<N && nCol>=0 && nCol<N)
			return true;
		return false;
	}
	private void printMap(int[][] map) {
		for(int[] arr : map)
			System.out.println(Arrays.toString(arr));
	}
}

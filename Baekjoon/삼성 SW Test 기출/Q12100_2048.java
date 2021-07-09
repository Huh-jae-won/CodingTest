import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q12100_2048 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q12100_2048 z = new Q12100_2048();
		z.solution();
	}
	int N = 0;
	int[][] map;
	int ret = 0;
	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ret = Integer.MIN_VALUE;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				ret = Math.max(ret, map[i][j]);
			}
		}
		dfs(0,"");
//		play(map, "223");
		System.out.println(ret);
	}
	int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};	// 상 좌 하 우
	private void dfs(int dep, String dir) {
		if(dep==5) {
//			System.out.println(dir);
			play(copyArr(),dir);
//			System.out.println();
			return;
		}
		for(int i=0 ; i<4 ; i++) {
			dfs(dep+1,dir+i);
		}
	}
	private void play(int[][]arr, String dirStr) {
		for(int i=0 ; i<dirStr.length() ; i++) {
			int dir = Integer.parseInt(dirStr.charAt(i)+"");
			move(arr, dir);
			merge(arr, dir);
			move(arr, dir);
//			System.out.println(dir);
//			printArr(arr);
		}
	}
	private void move(int[][]arr, int dir) {
		if(dir<2) {	
			// 상 좌
			for(int i=0 ; i<=N-1 ; i++) {
				for(int j=0 ; j<=N-1; j++) {
					int cRow = i;
					int cCol = j;
					int nRow = i + dirs[dir][0];
					int nCol = j + dirs[dir][1];
					while(inRange(nRow, nCol) && arr[nRow][nCol]==0) {
						arr[nRow][nCol] = arr[cRow][cCol];
						arr[cRow][cCol] = 0;
						cRow = nRow;
						cCol = nCol;
						nRow = cRow + dirs[dir][0];
						nCol = cCol + dirs[dir][1];
					}
				}
			}
		}else {
			// 하 우
			for(int i=N-1 ; i>=0 ; i--) {
				for(int j=N-1 ; j>=0; j--) {
					int cRow = i;
					int cCol = j;
					int nRow = i + dirs[dir][0];
					int nCol = j + dirs[dir][1];
					while(inRange(nRow, nCol) && arr[nRow][nCol]==0) {
						arr[nRow][nCol] = arr[cRow][cCol];
						arr[cRow][cCol] = 0;
						cRow = nRow;
						cCol = nCol;
						nRow = cRow + dirs[dir][0];
						nCol = cCol + dirs[dir][1];
					}
				}
			}
		}
	}
	private void merge(int[][]arr, int dir) {
		switch (dir) {
		case 0 : // 상
			for(int j=0 ; j<N ; j++) {
				for(int i=0 ; i<N ; i++) {
					if(arr[i][j]==0)
						continue;
					int nRow = i + dirs[dir][0];
					if(inRange(nRow,j) && arr[i][j]==arr[nRow][j]) {
						arr[nRow][j] *= 2;
						ret = Math.max(ret, arr[nRow][j]);
						arr[i][j] = 0;
					}
				}
			}
			break;
		case 1 : // 좌
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					if(arr[i][j]==0)
						continue;
					int nCol = j + dirs[dir][1];
					if(inRange(i,nCol) && arr[i][j]==arr[i][nCol]) {
						arr[i][nCol] *= 2;
						ret = Math.max(ret, arr[i][nCol]);
						arr[i][j] = 0;
					}
				}
			}
			break;
		case 2 : // 하
			for(int j=0 ; j<N ; j++) {
				for(int i=N-1 ; i>=0 ; i--) {
					if(arr[i][j]==0)
						continue;
					int nRow = i + dirs[dir][0];
					if(inRange(nRow,j) && arr[i][j]==arr[nRow][j]) {
						arr[nRow][j] *= 2;
						ret = Math.max(ret, arr[nRow][j]);
						arr[i][j] = 0;
					}
				}
			}
			break;
		case 3 : // 우
			for(int i=0 ; i<N ; i++) {
				for(int j=N-1 ; j>=0 ; j--) {
					if(arr[i][j]==0)
						continue;
					int nCol = j + dirs[dir][1];
					if(inRange(i,nCol) && arr[i][j]==arr[i][nCol]) {
						arr[i][nCol] *= 2;
						ret = Math.max(ret, arr[i][nCol]);
						arr[i][j] = 0;
					}
				}
			}
			break;
		default:
			break;
		}
	}
	
	private boolean inRange(int row, int col) {
		if(row>=0 && row<N && col>=0 && col<N)
			return true;
		return false;
	}
	
	private int[][] copyArr(){
		int[][] cArr = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				cArr[i][j] = map[i][j];
			}
		}
		return cArr;
	}
	
	private void printArr(int[][] arr) {
		for(int[] temp : arr) {
			System.out.println(Arrays.toString(temp));
		}
	}
}

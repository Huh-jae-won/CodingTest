import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q14502_Lab {
	public static void main(String[] args) throws IOException {
		Q14502_Lab z = new Q14502_Lab();
		z.solution();
	}
	int N = 0;
	int M = 0;
	int ret = 0;
	int[][] map;
	List<int[]> virusList;
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ret = 0;
		map = new int[N][M];
		virusList = new ArrayList<>();
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==2) {
					virusList.add(new int[] {i,j});
				}
				map[i][j] = num;
			}
		}
		int[][] barrier = new int[3][2];
		for(int[] bar : barrier) {
			Arrays.fill(bar, -1);
		}
		dfs(barrier, 0, 0, -1);
		System.out.println(ret);
		
	}
	private void dfs(int[][] barrier, int dep, int befRow, int befCol) {
		if(dep==3) {
			int[][] copyMap = copyArr(map);
			for(int[] bar : barrier) {
				copyMap[bar[0]][bar[1]] = 9;
			}
			diffusion(copyMap);
			ret = Math.max(ret,countEmptyRoom(copyMap));
//			System.out.println(Arrays.deepToString(barrier));
//			printArr(copyMap);
			return;
		}
		int row=befRow;
		int col=befCol+1;
		if(col>=M) {
			row += 1;
			col = 0;
		}
		while(row<N && col<M) {
			if(map[row][col]==0 && !hasSamePos(barrier, dep) && !containArr(new int[] {row,col})){
				barrier[dep][0] = row;
				barrier[dep][1] = col;
				dfs(barrier, dep+1, row, col);
				barrier[dep][0] = -1;
				barrier[dep][1] = -1;
			}
			col++;
			if(col>=M) {
				row += 1;
				col = 0;
			}
		}
	}
	private boolean hasSamePos(int[][] barrier, int idx) {
		for(int i=0 ; i<idx ; i++) {
			if(Arrays.equals(barrier[i], barrier[idx]))
				return true;
		}
		return false;
	}
	
	private int[][] copyArr(int[][] arr){
		int R = arr.length;
		int C = arr[0].length;
		int[][] ret = new int[R][C];
		for(int i=0 ; i<R ; i++) {
			for(int j=0 ; j<C ; j++) {
				ret[i][j] = arr[i][j];
			}
		}
		return ret;
	}
	
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};	// 상하좌우 
	private void diffusion(int[][] lab) {
		for(int[] virus : virusList) {
			lab[virus[0]][virus[1]] = 0;
			diff(lab, virus);
		}
	}
	private void diff(int[][] lab, int[] virus) {
		int row = virus[0];
		int col = virus[1];
		if(inRange(row,col) && (lab[row][col]==0)) {
			lab[row][col] = 2;
			for(int[] dir : dirs) {
				int nRow = row + dir[0];
				int nCol = col + dir[1];
				diff(lab,new int[] {nRow, nCol});
			}
		}
	}
	
	private boolean inRange(int row, int col) {
		if(row>=0 && row<N && col>=0 && col<M)
			return true;
		return false;
	}
	
	private boolean containArr(int[] arr) {
		for(int[] virus : virusList) {
			if(Arrays.equals(arr, virus))
				return true;
		}
		return false;
	}
	
	private int countEmptyRoom(int[][] lab) {
		int R = lab.length;
		int C = lab[0].length;
		int cnt = 0;
		for(int i=0 ; i<R ; i++) {
			for(int j=0 ; j<C ; j++) {
				if(lab[i][j]==0)
					cnt++;
			}
		}
		return cnt;
	}
	
	private void printArr(int[][] lab) {
		int R = lab.length;
		int C = lab[0].length;
		for(int i=0 ; i<R ; i++) {
			for(int j=0 ; j<C ; j++) {
				System.out.print(lab[i][j]+" ");
			}
			System.out.println();
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14890_Slope {
	public static void main(String[] args) throws IOException {
		Q14890_Slope z = new Q14890_Slope();
		z.solution();
	}
	int N = 0;
	int L = 0;
	int ret = 0;
	int[][] map;
	boolean[][]visited;
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		ret = 0;
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ret += checkHorizon();
		ret += checkVertical();
		System.out.println(ret);
	}
	private int checkHorizon() {
		int ret = 0;
		for(int x=0 ; x<N ; x++) {
			boolean flag = true;
			int[] arr = map[x];
			boolean[] visited = new boolean[arr.length];
			int befo = arr[0];
			for(int j=1 ; j<N ; j++) {
				if(befo==arr[j]) {
					continue;
				}
				// cur, befo의 높이가 다른경우
				
				// 현재가 더 높은경우
				if(arr[j]-befo==1 && canPutSlopeForward(arr,visited,x,j,0)) {
					// 높이 차가 1 && 놓을공간 확보o && 오르막 슬로프
					// (x,j-L)부터 L개 오른쪽으로 put
					for(int k=j-L ; k<j ; k++) {
						visited[k] = true;
					}
				}else if (befo-arr[j]==1 && canPutSlopeBackward(arr,visited,x,j,0)) {
					// 높이 차가 1 && 놓을공간 황보o && 내리막 슬로프
					for(int k=j ; k<j+L ; k++) {
						visited[k] = true;
					}
				}else {
					// 높이차가 1보다 크거나 놓을 공간 x
					flag = false;
					break;
				}
				befo = arr[j];
			}
			if(flag) {
//				System.out.println(x);
				ret++;
			}
		}
		return ret;
	}
	
	private int checkVertical() {
		int ret = 0;
		for(int y=0 ; y<N ; y++) {
			boolean flag = true;
			int[] arr = makeColArr(y);
			boolean[] visited = new boolean[arr.length];

			int befo = arr[0];
			for(int i=1 ; i<N ; i++) {
				if(befo==arr[i]) {
					continue;
				}
				// cur, befo의 높이가 다른경우
				
				// 현재가 더 높은경우
				if(arr[i]-befo==1 && canPutSlopeForward(arr,visited,i,y,1)) {
					// 높이 차가 1 && 놓을공간 확보o && 오르막 슬로프
					// (x,j-L)부터 L개 오른쪽으로 put
					for(int k=i-L ; k<i ; k++) {
						visited[k] = true;
					}
				}else if (befo-arr[i]==1 && canPutSlopeBackward(arr,visited,i,y,1)) {
					// 높이 차가 1 && 놓을공간 황보o && 내리막 슬로프
					for(int k=i ; k<i+L ; k++) {
						visited[k] = true;
					}
				}else {
					// 높이차가 1보다 크거나 놓을 공간 x
					flag = false;
					break;
				}
				befo = arr[i];
			}
			if(flag) {
//				System.out.println(y);
				ret++;
			}
		}
		return ret;
	}
	

	private boolean canPutSlopeForward(int[] arr, boolean[] visited,int row, int col, int dir) {
		// 오르막 슬로프
		if(dir==0) {
			if(!inRange(col-1))
				return false;
			int befo = arr[col-1];
			for(int j=col-1 ; j>=col-L ; j--) {
				if(!inRange(j) || arr[j]!=befo || visited[j])
					return false;
			}
		}else {
			// 열방향
			if(!inRange(row-1))
				return false;
			int befo = arr[row-1];
			for(int i=row-1 ; i>=row-L ; i--) {
				if(!inRange(i) || arr[i]!=befo || visited[i])
					return false;
			}
		}
		return true;
	}
	private boolean canPutSlopeBackward(int[] arr, boolean[] visited, int row, int col, int dir) {
		// 내리막 슬로프
		if(dir==0) {
			int befo = arr[col];
			for(int j=col ; j<col+L ; j++) {
				if(!inRange(j) || arr[j]!=befo || visited[j])
					return false;
			}
		}else {
			// 열방향
			int befo = arr[row];
			for(int i=row ; i<row+L ; i++) {
				if(!inRange(i) || arr[i]!=befo || visited[i])
					return false;
			}
		}
		return true;
	}
	
	private boolean inRange(int num) {
		if(num>=0 && num<N)
			return true;
		return false;
	}
	
	private int[] makeColArr(int col) {
		int[] colArr = new int[N];
		for(int i=0 ; i<N ; i++) {
			colArr[i] = map[i][col];
		}
		return colArr;
	}
	
}

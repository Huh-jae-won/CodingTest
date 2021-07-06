import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q17406_RotateArr {
	public static void main(String[] args) throws IOException {
		Q17406_RotateArr z = new Q17406_RotateArr();
		z.solution();
	}
	int N = 0;
	int M = 0;
	int K = 0;
	int ret = 0;
	int[][] base;
	int[][] rotate;
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ret = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		base = new int[N+1][M+1];
		rotate = new int[K][3];
		for(int i=1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1 ; j<=M ; j++) {
				base[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0 ; i<K ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<3 ; j++) {
				rotate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		List<int[]> rotateList = new ArrayList<>();
		boolean[] visited = new boolean[K];
		dfs(rotateList, 0, visited);
		System.out.println(ret);

	}
	private void dfs(List<int[]> rotateList, int dep, boolean[] visited) {
		if(dep==K) {
			int[][] copyArr = copyArr();
			int min = rotate(copyArr,rotateList);
			ret = Math.min(ret, min);
//			System.out.println(min);
//			printMap(copyArr);
			return;
		}
		for(int i=0 ; i<K ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				rotateList.add(new int[] {rotate[i][0],rotate[i][1],rotate[i][2]});
				dfs(rotateList,dep+1,visited);
				rotateList.remove(rotateList.size()-1);
				visited[i] = false;
			}
		}
	}
	private int[][] copyArr(){
		int[][] ret = new int[N+1][M+1];
		for(int i=1 ; i<N+1 ; i++) {
			for(int j=1 ; j<M+1 ; j++) {
				ret[i][j] = base[i][j];
			}
		}
		return ret;
	}
	
	private int rotate(int[][] arr,List<int[]> rotateList) {
		for(int i=0 ; i<K ; i++) {
			int row = rotateList.get(i)[0];
			int col = rotateList.get(i)[1];
			int len = rotateList.get(i)[2];
			for(int rot=len ; rot>0 ; rot--) {
				rotateArr(arr,row-rot,col-rot,rot);
			}
		}
		return findMin(arr);
	}
	
	private void rotateArr(int[][] arr,int row, int col, int len) {
		// 오른쪽으로
		int temp1 = arr[row][col];
		int temp2 = 0;
		for(int j=col+1 ; j<=col+2*len ; j++) {
			temp2 = arr[row][j];
			arr[row][j] = temp1;
			temp1 = temp2;
		}
		// 아래쪽으로
		for(int i=row+1 ; i<=row+2*len ; i++) {
			temp2 = arr[i][col+2*len];
			arr[i][col+2*len] = temp1;
			temp1 = temp2;
		}
		// 왼쪽으로
		for(int j=col+2*len-1 ; j>=col ; j--) {
			temp2 = arr[row+2*len][j];
			arr[row+2*len][j] = temp1;
			temp1 = temp2;
		}
		// 위쪽으로
		for(int i=row+2*len-1 ; i>=row ; i--) {
			temp2 = arr[i][col];
			arr[i][col] = temp1;
			temp1 = temp2;
		}
	}
	
	private int findMin(int[][] arr) {
		int ret = Integer.MAX_VALUE;
		for(int x=1 ; x<arr.length ; x++) {
			int[] temp = arr[x];
			int sum = 0;
			for(int i=0 ; i<temp.length ; i++) {
				sum += temp[i];
			}
			ret = Math.min(ret, sum);
		}
		return ret;
	}
	
	private void printMap(int[][] arr) {
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=M ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

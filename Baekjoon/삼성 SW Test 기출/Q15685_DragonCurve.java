import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Q15685_DragonCurve {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q15685_DragonCurve z = new Q15685_DragonCurve();
		z.solution();
	}
	int N = 0;
	int[][] dirs = { {0,1}, {-1,0}, {0,-1}, {1,0}};	// (y,x)좌표로
	boolean[][] map;
	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[300][300];
		List<List<int[]>> lList = new ArrayList<>();
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<int[]> list = new ArrayList<>();
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());	// 시작방향
			int g = Integer.parseInt(st.nextToken());	// 세대
			list.add(new int[] {y,x});
			list.add(new int[] {y+dirs[d][0],x+dirs[d][1]});
			dragonCurve(list, g);
			lList.add(list);
		}
		for(List<int[]> list : lList) {
			for(int[] arr : list) {
				map[arr[0]][arr[1]] = true;
			}
		}
		int ret = 0;
		for(int i=0 ; i<=100 ; i++) {
			for(int j=0 ; j<=100 ; j++) {
				if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1])
					ret++;
			}
		}
		System.out.println(ret);
	}
	private void dragonCurve(List<int[]> list, int g) {
		for(int gene=1 ; gene<=g ; gene++) {
			int zeroY = list.get(list.size()-1)[0];
			int zeroX = list.get(list.size()-1)[1];
			int size1 = list.size()-1; 
			for(int i=size1-1 ; i>=0 ; i--) {
				int[] listArr = list.get(i);
				int y = listArr[0];
				int x = listArr[1];
				int[] arr = {y,x};
				rotate(arr, zeroY, zeroX);
				list.add(arr);
			}
		}
	}
	private void rotate(int[] arr, int zeroY, int zeroX) {
		// zeroX, zeroY 회전축 좌표
		// 시계방향 90도 회전
		arr[0] -= zeroY;
		arr[1] -= zeroX;
		int newY = arr[1];
		int newX = -arr[0];
		arr[0] = newY;
		arr[1] = newX;
		arr[0] += zeroY;
		arr[1] += zeroX;
	}
	
	private void printList(List<int[]> list) {
		for(int[] arr : list) {
			System.out.print(Arrays.toString(arr) + " ");
		}
		System.out.println();
	}
}
// -90도  회전변환
// cosA -sinA		0  1 | y =  x
// sinA  cosA	   -1  0 | x = -y
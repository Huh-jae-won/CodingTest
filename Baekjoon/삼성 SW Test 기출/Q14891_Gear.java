import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14891_Gear {
	public static void main(String[] args) throws IOException {
		Q14891_Gear z = new Q14891_Gear();
		z.solution();
	}
	int[][] gearArr;
	int[][] spinArr;
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gearArr = new int[4][8];
		for(int i=0 ; i<4 ; i++) {
			String info = br.readLine(); 
			for(int j=0 ; j<8 ; j++) {
				gearArr[i][j] = Integer.parseInt(info.charAt(j)+"");
			}
		}
		int K = Integer.parseInt(br.readLine());
		spinArr = new int[K][2];
		for(int i=0 ; i<K ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<2 ; j++) {
				spinArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int[] arr : spinArr) {
			spinGear(arr);
		}
		System.out.println(sum());
	}
	private void spinGear(int[] arr) {
		int gearIdx = arr[0]-1;
		int dir = arr[1];	// 회전방향 1:시계, -1:반시계
		int[] visited = new int[4];
		visited[gearIdx] = dir;
		dfs(gearIdx, 1, visited);
		dfs(gearIdx, -1, visited);
		spin(visited);
	}
	private void dfs(int gearIdx, int dir, int[] visited) {
		// dir 1 : 오른쪽이랑 비교,   dir -1 : 왼쪽이랑 비교
		if(visited[gearIdx]==0) {
			int befoSpin = visited[gearIdx-dir];
			visited[gearIdx] = -befoSpin;
		}
		if(inRange(gearIdx+dir)) {
			int num = gearArr[gearIdx][(8+2*dir)%8];
			int nextNum = gearArr[gearIdx+dir][(8-2*dir)%8];
			if((num^nextNum)==1) {
				// 두 값이 다르면 다음 기어도 회전해야함
				dfs(gearIdx+dir, dir, visited);
			}
		}
	}
	
	private void spin(int[] visited) {
		for(int i=0 ; i<4 ; i++) {
			int spinDir = visited[i];
			if(spinDir==1) {
				// 시계 방향
				int temp2 = gearArr[i][0];
				for(int j=1 ; j<8 ; j++) {
					int temp1 = gearArr[i][j];
					gearArr[i][j] = temp2;
					temp2 = temp1;
				}
				gearArr[i][0] = temp2;
			}else if(spinDir==-1) {
				// 반시계 방향
				int temp2 = gearArr[i][7];
				for(int j=6 ; j>=0 ; j--) {
					int temp1 = gearArr[i][j];
					gearArr[i][j] = temp2;
					temp2 = temp1;
				}
				gearArr[i][7] = temp2;
			}
		}
	}
	
	private int sum() {
		int sum = 0;
		for(int i=0 ; i<4 ; i++) {
			if(gearArr[i][0]==1) {
				sum += Math.pow(2, i);
			}
		}
		return sum;
	}
	
	private boolean inRange(int idx) {
		if(idx>=0 && idx<4)
			return true;
		return false;
	}
	
	private void printArr(int[][] arr) {
		for(int[] temp : arr) {
			System.out.println(Arrays.toString(temp));
		}
	}
}

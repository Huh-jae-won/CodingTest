import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14503_RobotCleaner {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q14503_RobotCleaner z = new Q14503_RobotCleaner();
		z.solution();
	}
	int N = 0;
	int M = 0;
	class Robot{
		int row;
		int col;
		int dir;
		public Robot(int row, int col, int dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "Robot ["+"("+row+", "+col+"):"+dir+"]";
		}
		
	}
	// 방향 :			   0북,   1동,  2남,   3서
	int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
	int[][] map;
	int ret = 0;
	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ret = 0;
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		Robot robot = new Robot(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()) );
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(robot);
		System.out.println(ret);
	}
	
	private void clean(Robot robot) {
		int nRow = 0;
		int nCol = 0;
		while(true) {
//			System.out.print(robot);
			boolean flag = false;
			// 1번 : 현재위치 청소
			if(map[robot.row][robot.col]==0) {
				map[robot.row][robot.col] = 9;
				ret++;
			}
//			System.out.println(", ret: "+ret);
			// 2번 : 탐색 시작
			for(int i=1 ; i<=4 ; i++) {
				robot.dir = (robot.dir+4-1)%4;	// 현재 기준 왼쪽방향으로 회전
				nRow = robot.row + dirs[robot.dir][0];
				nCol = robot.col + dirs[robot.dir][1];
				// A번 : 왼쪽이 청소 안된 칸인 경우 -> 청소하러가야지 
				if(checkA(nRow, nCol)) {
					robot.row = nRow;
					robot.col = nCol;
					flag = true;
					break;
				}else {
					// B번 : 왼쪽 칸이 이미 청소 or 벽인 경우
					// 한번 더 왼쪽으로 회전만, 이동x
				}
			}
			// 4방향 다 청소 or 벽인경우  
			if(!flag) {
				int backRow = robot.row + dirs[(robot.dir+2)%4][0];
				int backCol = robot.col + dirs[(robot.dir+2)%4][1];
				if(checkC(backRow, backCol)) {
					// 후진가능 -> C번
					robot.row = backRow;
					robot.col = backCol;
				}else {
					break;
				}
			}
		}
	}
	
	private boolean checkA(int row, int col) {
		if(inRange(row,col) && map[row][col]==0)
			return true;
		return false;
	}
	
	private boolean checkC(int row, int col) {
		if(inRange(row,col) && map[row][col]!=1)
			return true;
		return false;
	}
	
	private boolean inRange(int row, int col) {
		if(row>=0 && row<N && col>=0 && col<M)
			return true;
		return false;
	}
}

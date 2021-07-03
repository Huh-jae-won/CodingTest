import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q17135_CastleDefense {
	public static void main(String[] args) throws IOException {
		Q17135_CastleDefense z = new Q17135_CastleDefense();
		z.solution();
	}
	int N = 0;
	int M = 0;
	int D = 0;
	int answer = 0;
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		answer = Integer.MIN_VALUE;
		int[][] map = new int[N][M];
		for(int i=0 ; i<map.length ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<map[0].length ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		List<Integer> colList = new ArrayList<>();
		deployfArcher(map, colList, -1);
		System.out.println(answer);
	}
	private void deployfArcher(int[][] map, List<Integer> colList, int befo) {
		if(colList.size()==3) {
			int[][] cMap = copyMap(map);
			int kill = defense(cMap, colList);
			answer = Math.max(answer, kill);
			return;
		}
		for(int i=befo+1 ; i<M ; i++) {
			colList.add(i);
			deployfArcher(map,colList,i);
			colList.remove(colList.size()-1);
		}
	}
	private int defense(int[][] map, List<Integer> archerList) {
		int kill = 0;
//		System.out.println(archerList);
		for(int time=1 ; time<=N ; time++) {
			List<int[]> enemyList = new ArrayList<>();
			for(int archerCol : archerList) {
				int[] pos = findEnemy(map,archerCol);
				if(pos[0]!=-1)
					enemyList.add(pos);
			}
			int temp = killEnemy(map, enemyList);
//			System.out.printf("time %d : %d\n",time,temp);
//			printMap(map);
			kill += temp;
			moveEnemy(map);
		}
//		System.out.println("kill = "+kill);
//		System.out.println();
		return kill;
	}
	
	private int[] findEnemy(int[][] map, int archerCol) {
		int[] pos = new int[2];
		Arrays.fill(pos, -1);
		int minDist = Integer.MAX_VALUE;
		for(int i=N-1 ; i>=0 ; i--) {
			for(int j=0 ; j<M ; j++) {
				if(map[i][j]==1) {
					// 적이 있는 위치
					int dist = getDist(i,j,archerCol);
					if(dist<=D) {
						if(dist<minDist) {
							pos[0] = i;
							pos[1] = j;
							minDist = dist;
						}else if (dist==minDist) {
							if(j<pos[1]) {
								pos[0] = i;
								pos[1] = j;
							}
						}
					}
				}
			}
		}
		return pos;
	}
	private int getDist(int row, int col, int archerCol) {
		int len = 0;
		len = (N-row) + Math.abs(archerCol-col);
		return len;
	}
	
	private int killEnemy(int[][] map, List<int[]> enemyList) {
		int kill = 0;
		for(int[] pos : enemyList) {
			int row = pos[0];
			int col = pos[1];
			if(map[row][col]!=0) {
				map[row][col] = 0;
				kill++;
			}
		}
		return kill;
	}
	
	private void moveEnemy(int[][] map) {
		for(int j=0 ; j<M ; j++) {
			map[N-1][j] = 0;
		}
		for(int i=N-1 ; i>0 ; i--) {
			for(int j=0 ; j<M ; j++) {
				map[i][j] = map[i-1][j];
			}
		}
		for(int j=0 ; j<M ; j++) {
			map[0][j] = 0;
		}
	}
	

	private int[][] copyMap(int[][] map){
		int[][] copyOfMap = new int[N][M];
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				copyOfMap[i][j] = map[i][j];
			}
		}
		return copyOfMap;
	}
	
	private void printMap(int[][] map) {
		for(int[] arr : map) {
			System.out.println(Arrays.toString(arr));
		}
	}
}

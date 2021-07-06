import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17472_Bridge {
	public static void main(String[] args) throws IOException {
		Q17472_Bridge z = new Q17472_Bridge();
		z.solution();
	}
	int N;
	int M;
	int[][] map;
	List<Island> islandList;
	class Island{
		int idx;
		List<int[]> arrList;
		public Island(int idx, List<int[]> arrList) {
			this.idx = idx;
			this.arrList = arrList;
		}
		
		private int distance(Island island) {
			int dist = Integer.MAX_VALUE;
			for(int[] arr1 : this.arrList) {
				for(int[] arr2 : island.arrList) {
					if(arr1[0]==arr2[0]) {
						// 행이 같은 경우
						int start = Math.min(arr1[1], arr2[1]);
						int end = Math.max(arr1[1], arr2[1]);
						int len = 0;
						for(int j=start+1 ; j<end ; j++) {
							if(map[arr1[0]][j]!=0) {
								len = 0;
								// 바다가 아닌 부분 존재
								break;
							}else {
								len++;
							}
						}
						if(len>1) {
							dist = Math.min(dist, len);
						}
					}else if(arr1[1]==arr2[1]) {
						int start = Math.min(arr1[0], arr2[0]);
						int end = Math.max(arr1[0], arr2[0]);
						int len = 0;
						for(int i=start+1 ; i<end ; i++) {
							if(map[i][arr1[1]]!=0) {
								len = 0;
								break;
							}else {
								len++;
							}
						}
						if(len>1) {
							dist = Math.min(dist, len);
						}
					}
				}
			}
			return dist;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("<");
			for(int[]arr : arrList) {
				sb.append("("+arr[0]+","+arr[1]+")_");
			}
			sb.append(">");
			return "[ idx="+idx+", arr="+sb.toString()+" ]";
		}
		
	}
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		islandList = new ArrayList<>();
		map = new int[N][M];
		int[][] dist;
		boolean[][] visited = new boolean[N][M];
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					map[i][j] = -1;
				}else {
					map[i][j] = num;
				}
			}
		}
		int islandCnt = changeMap();
		dist = new int[islandCnt+1][islandCnt+1];
//		printArr(map,0);
		// 섬별 거리 arr
		int tempMin = Integer.MAX_VALUE;
		int[] tempMinArr = new int[2];
		for(int i=0 ; i<islandCnt ; i++) {
			for(int j=i+1 ; j<islandCnt; j++) {
				int len = islandList.get(i).distance(islandList.get(j));
				if(len<tempMin) {
					tempMin = len;
					tempMinArr = new int[] {i+1,j+1};
				}
				if(len==Integer.MAX_VALUE) {
					dist[i+1][j+1] = -1;
					dist[j+1][i+1] = -1;
				}else {
					dist[i+1][j+1] = len;
					dist[j+1][i+1] = len;
				}
			}
		}
//		printArr(dist,1);
		int sum = MakeBridge(dist, tempMinArr);
		System.out.println(sum);
	}	
	private int changeMap() {
		int idx = 1;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				if(map[i][j]==-1) {
					bfs(i,j,idx);
					idx++;
				}
			}
		}
		return idx-1;
	}
	int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};	// 하, 우, 상, 좌
	private void bfs(int row, int col,int idx) {
		List<int[]> arrList = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row,col});
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			if(map[pos[0]][pos[1]]==-1) {
				map[pos[0]][pos[1]] = idx;
				arrList.add(pos);
				for(int[] dir : dirs) {
					int nRow = pos[0] + dir[0];
					int nCol = pos[1] + dir[1];
					int[] arr = {nRow,nCol};
					if(inRange(arr)) {
						q.offer(arr);
					}
				}
			}
		}
		Island island = new Island(idx,arrList);
		islandList.add(island);
	}
	private boolean inRange(int[] arr) {
		int row = arr[0];
		int col = arr[1];
		if(row>=0 && row<N && col>=0 && col<M)
			return true;
		return false;
	}
	
	private int MakeBridge(int[][] dist, int[] start) {
		int sum = 0;
		boolean[] visited = new boolean[dist.length];
		sum += dist[start[0]][start[1]];
		visited[start[0]] = true;
		visited[start[1]] = true;
		while(!allTrue(visited)) {
			int tempMin = Integer.MAX_VALUE;
			int[] tempMinArr = new int[2];
			for(int i=1 ; i<dist.length ; i++) {
				for(int j=1 ; j<dist.length ; j++) {
					if((visited[i]&&visited[j]) || (!visited[i]&&!visited[j])) {
						// 둘다 방문 or 둘다 미방문 시 
						continue;
					}
					int len = dist[i][j];
					if(len>1 && len<tempMin) {
						tempMin = len;
						tempMinArr[0] = i;
						tempMinArr[1] = j;
					}
				}
			}
			visited[tempMinArr[0]] = true;
			visited[tempMinArr[1]] = true;
//			System.out.println(Arrays.toString(tempMinArr)+" : "+tempMin);
			if(tempMin!=Integer.MAX_VALUE) {
				sum+=tempMin;
			}else {
				return -1;
			}
		}
		return sum;
	}
	private boolean allTrue(boolean[] visited) {
		for(int i=1 ; i<visited.length ; i++) {
			if(!visited[i])
				return false;
		}
		return true;
	}
	private void printArr(int[][] arr,int start) {
		for(int i=start ; i<arr.length ; i++) {
			for(int j=start ; j<arr[0].length ; j++) {
				System.out.printf("%2d ",arr[i][j]);
			}
			System.out.println();
		}
	}
}

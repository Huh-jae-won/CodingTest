package 모의TEST문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q01953_Prisoner {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01953_Prisoner a = new Q01953_Prisoner();
		a.solution();
	}
	int N = 0;
	int M = 0;
	int[] start = new int[2];
	int time;
	int[][] map;
	boolean[][] visited;
	Map<String,String> way;
//					  0     1		2	  3	   4	 5	  6		7
	String[] dirs = {null,"상하좌우","상하","좌우","상우","하우","하좌","상좌"};
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
//			초기조건 
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
//			map
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0 ; i<N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<M ; j++) {
					 map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// way설정
			way = new HashMap<>();
			
//			printInitial();
//			printMap();
			
			Queue<int[]> q = new LinkedList<>();
			q.add(start);
			makeWay();
//			System.out.println(way);
			bfs(q,visited,1);
			int ret = countTrue();
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
	private void bfs(Queue<int[]> q,boolean[][] visited,int nowTime) {
		while(!q.isEmpty() && nowTime<=time) {
			int size = q.size();
			for(int i=0 ; i<size ; i++) {
				int[] pos = q.poll();
				visited[pos[0]][pos[1]] = true;
				// 해당 좌표의 파이프 형태 : num
				int num = map[pos[0]][pos[1]];
				if(!dirs[num].equals(null)) {
					// num==0이면 pass
					for(int j=0 ; j<dirs[num].length() ; j++) {
//						파이프 형태에 따른 갈 수 있는 방향(dirs[num])마다 갈수 있는지 체크
						String one = dirs[num].substring(j,j+1);
						if(canGo(pos, num, one)) {
//							one 방향으로 갈수있다면
							int[] next = nextDirection(pos, one);
							q.add(next);
						}
					}
				}
			}
//			printVisited();
			nowTime++;
		}
	}
	private int countTrue() {
		int ret = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				if(visited[i][j])
					ret++;
			}
		}
		return ret;
	}
	private int[] nextDirection(int[] pos,String one) {
		switch (one) {
		case "상":
			return new int[] {pos[0]-1,pos[1]};
		case "하":
			return new int[] {pos[0]+1,pos[1]};
		case "좌":
			return new int[] {pos[0],pos[1]-1};
		case "우":
			return new int[] {pos[0],pos[1]+1};
		default:
			break;
		}
		return null;
	}
	private boolean canGo(int[] pos,int num,String dir) {
		String pipeList = "";	// dir방향으로 갔을때 연결될수 있는 pipe번호 list
		int row = pos[0];
		int col = pos[1];
		switch (dir) {
		// 해당 위치에 연결가능한 pipe가 있다면 true
		case "상":
			row--;
			if(row>=0 && !visited[row][col]) {
				pipeList = way.get(dir);
				if(pipeList.contains(String.valueOf(map[row][col])) )
					return true;	
			}
			break;
		case "하":
			row++;
			if(row<N && !visited[row][col]) {
				pipeList = way.get(dir);
				if(pipeList.contains(String.valueOf(map[row][col])) )
					return true;
			}
			break;
		case "좌":
			col--;
			if(col>=0 && !visited[row][col]) {
				pipeList = way.get(dir);
				if(pipeList.contains(String.valueOf(map[row][col])) )
					return true;
			}
			break;
		case "우":
			col++;
			if(col<M && !visited[row][col]) {
				pipeList = way.get(dir);
				if(pipeList.contains(String.valueOf(map[row][col])) )
					return true;
			}
			break;
		default:
			break;
		}
		return false;
	}
	
	private void makeWay() {
		for(int i=1 ; i<8 ; i++) {
			String dir = dirs[i];
			for(int j=0 ; j<dir.length() ; j++) {
				String one = dir.substring(j,j+1);
				way.put(one,makeDir(one));
			}
		}
	}
	private String makeDir(String one) {
		StringBuilder ss = new StringBuilder();
		switch (one) {
		case "상":
			for(int i=1 ; i<8 ; i++) {
				if(dirs[i].contains("하"))
					ss.append(i);
			}
			break;
		case "하":
			for(int i=1 ; i<8 ; i++) {
				if(dirs[i].contains("상"))
					ss.append(i);
			}
			break;
		case "좌":
			for(int i=1 ; i<8 ; i++) {
				if(dirs[i].contains("우"))
					ss.append(i);
			}
			break;
		case "우":
			for(int i=1 ; i<8 ; i++) {
				if(dirs[i].contains("좌"))
					ss.append(i);
			}
			break;
		default:
			break;
		}
		return ss.toString();
	}
	
	private void printVisited() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private void printMap() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private void printInitial() {
		System.out.printf("방구조: %dx%d\n",N,M);
		System.out.printf("start %d,%d\n",start[0],start[1]);
		System.out.printf("time: %d\n",time);
	}

}

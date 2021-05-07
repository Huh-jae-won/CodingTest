package 모의TEST문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q02105_Dessert {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q02105_Dessert a = new Q02105_Dessert();
		a.solution();
	}
	int[][] dirs = {
			
//			하우,		하좌,		상좌,		상우  : 시계방향 or 반시계 방향만 가능
			{1,1}, {1,-1}, {-1,-1}, {-1,1}	
	};
	
	int N = 0;
	int[][] map;
	int cnt = 0;
	int ret = 0;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1 ; tc<=1 ; tc++) {
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			ret = 0;
			map = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			List<Integer> list = new ArrayList<>();
			
//			map 만들기
			for(int i=0 ; i<N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			시작점
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					if(!isCorner(i, j)) {
						// 귀퉁이가 아니어야 실행
						for(int dir=0 ; dir<4 ; dir++) {
							int[] start = {i,j};
							dfs(start,list,visited,i,j,dir,0,true,"");
						}
					}
				}
			}
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	private void dfs(int[] start,List<Integer> list,boolean[][] visited, int row,int col,int dir,int turn,boolean clock,String log) {
		if(start[0] == row&&start[1]==col) {
			ret = Math.max(ret, list.size());
			return;	// 도착한 경우
		}
		if(visited[row][col])
			return;	// 이미 들렸던 곳인 경우 리턴
		if(cnt>3) {
			return;	// 회전을 4번이상 한경우 리턴
		}
		if(list.contains(map[row][col]))
			return;	// 이미 먹은 디저트인 경우 리턴
		System.out.println(log);
		list.add(map[row][col]);
		visited[row][col] = true;
		// 그대로 직진(방향전환x)
		int nRow = row + dirs[dir][0];
		int nCol = row + dirs[dir][1];
		String curPos = " ["+row+","+col+"]";
		dfs(start,list,visited,nRow,nCol,dir,turn,clock,log+curPos);
		if(clock) {
			// 시계방향 회전
			dir = (dir+1)%4;
			nRow = row + dirs[dir][0];
			nCol = col + dirs[dir][1];
			// 방향 전환
			dfs(start, list, visited, nRow, nCol, dir, turn+1, clock,log+curPos);
		}else {
			// 반시계방향 회전
			dir = (dir-1)%4;
			nRow = row + dirs[dir][0];
			nCol = col + dirs[dir][1];
			dfs(start, list, visited, nRow, nCol, dir, turn+1, clock,log+curPos);
		}
		visited[row][col] = false;
	}
	
	private boolean isCorner(int row, int col) {
		if(row==0&&(col==0||col==N-1))
			return true;
		if(row==N-1&&(col==0||col==N-1))
			return true;
		return false;
	}
	private boolean inRange(int row, int col) {
		if(row>=0 && row<N && col>=0 && col<N)
			return true;
		return false;
	}


}

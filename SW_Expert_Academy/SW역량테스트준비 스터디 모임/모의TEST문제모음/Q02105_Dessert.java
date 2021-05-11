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
		System.out.println("실패");
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
			List<Integer> list = new ArrayList<>();	// 디저트 종류
			
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
							System.out.printf("<%d,%d>:%d\n",i,j,dir);
							String str = "["+i+","+j+"]";
							dfs(start,list,visited,i,j,dir,0,true,str);
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
		if(list.size()!=0 && start[0]==row && start[1]==col) {
			System.out.println("도착 : "+log+", list : "+list);
			ret = Math.max(ret, list.size());
			return;	// 도착한 경우
		}
		if(!inRange(row,col)) {
			System.out.println("범위 : "+log);
			list.remove(list.size()-1);
			return;
		}
		if(visited[row][col]) {
			System.out.println("중복 : "+log);
			return;	// 이미 들렸던 곳인 경우 리턴
		}
		if(cnt>3) {
			System.out.println("회전 : "+log);
			return;	// 회전을 4번이상 한경우 리턴
		}
		if(list.contains(map[row][col])) {
//			list.remove(list.size()-1);
//			visited[row][col] = false;
			System.out.println("같은 : "+log+", list : "+list);
			return;	// 이미 먹은 디저트인 경우 리턴
		}
		System.out.println(" "+dir+" : "+log);
		list.add(map[row][col]);
		visited[row][col] = true;
		// 그대로 직진(방향전환x)
		int nRow = row + dirs[dir][0];
		int nCol = col + dirs[dir][1];
		String nPos = "["+nRow+","+nCol+"]";
		dfs(start,list,visited,nRow,nCol,dir,turn,clock,log+" -> "+nPos);
//		list.remove(list.size()-1);
		System.out.println(" "+dir+" : "+log+" : out");
		if(clock) {
			// 시계방향 회전
			int ndir = (dir+1)%4;
			nRow = row + dirs[ndir][0];
			nCol = col + dirs[ndir][1];
			nPos = "["+nRow+","+nCol+"]";
			// 방향 전환
			dfs(start, list, visited, nRow, nCol, ndir, turn+1, clock,log+" -> "+nPos);
		}else {
			// 반시계방향 회전
			int ndir = (dir-1)%4;
			nRow = row + dirs[ndir][0];
			nCol = col + dirs[ndir][1];
			nPos = " ["+nRow+","+nCol+"]";
			dfs(start, list, visited, nRow, nCol, ndir, turn+1, clock,log+" -> "+nPos);
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

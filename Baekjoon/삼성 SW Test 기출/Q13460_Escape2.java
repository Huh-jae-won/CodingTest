import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q13460_Escape2 {
	public static void main(String[] args) throws IOException {
		Q13460_Escape2 z = new Q13460_Escape2();
		z.solution();
	}
	int N = 0;
	int M = 0;
	char[][] map;
	class Marble{
		char color;
		int row;
		int col;
		char nextCh;
		public Marble(char color, int row, int col) {
			this.color = color;
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "["+color+" : ("+row+","+col+")"+nextCh+"]";
		}
		
	}
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};	// 상 하 좌 우
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		List<Marble> mList = new ArrayList<>();
		for(int i=0 ; i<N ; i++) {
			String line = br.readLine();
			for(int j=0 ; j<M ; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j]=='R') {
					mList.add(new Marble('R', i, j));
					map[i][j] = '.';
				}else if(map[i][j]=='B') {
					mList.add(new Marble('B', i, j));
					map[i][j] = '.';
				}
			}
		}
//		System.out.println(mList);
//		listSort(mList,1);
//		System.out.println(mList);
//		System.out.println("0 : "+mList.get(0)+", "+mList.get(1));
		int time = bfs(mList);
		if(time>10) {
			System.out.println(-1);
		}else {
			System.out.println(time);
		}
	}
	private int bfs(List<Marble> mList) {
		int time = 1;
		Queue<List<Marble>> q = new LinkedList<>();
		q.offer(mList);
		while(time<=10) {
			int size = q.size();
			for(int x=0 ; x<size ; x++) {
				List<Marble> list = q.poll();
//				System.out.print(time);
//				printList(list);
				for(int i=0 ; i<4 ; i++) {
					listSort(list,i);
					Marble m1 = move(list.get(0),null,i);
					Marble m2 = move(list.get(1),m1,i);
					if(m1.nextCh=='O') {
						if(m1.color=='R') {
							if(m2.nextCh=='R')
								continue;
//							System.out.println("끝 : "+m1+", "+m2);
							return time;
						}
						continue;
					}
					if(m2.nextCh=='O') {
						if(m2.color=='R') {
//							System.out.println("끝 : "+m1+", "+m2);
							return time;
						}
						continue;
					}
//					System.out.println(direction(i)+" : "+m1+", "+m2);
					q.offer(Arrays.asList(m1,m2));
				}
			}
//			System.out.println();
			time++;
		}
		return time;
	}
	
	private void listSort(List<Marble> list, int dir) {
		list.sort((r,b)->{
			int ret = whatIsFirst(r,b,dir);
			return ret;
		});
	}
	
	private int whatIsFirst(Marble r, Marble b, int dir) {
		int ret = 0;
		switch (dir) {
		case 0:	// 상
			ret = r.row-b.row;
			break;
		case 1 : // 하
			ret = b.row-r.row;
			break;
		case 2 : // 좌
			ret = r.col-b.col;
			break;
		case 3 : // 우
			ret = b.col-r.col;
			break;
		default:
			break;
		}
		return ret;
	}
	
	private Marble move(Marble m, Marble otherM,int dir) {
		Marble newMarble;
		int row = m.row;
		int col = m.col;
		int nRow = row + dirs[dir][0];
		int nCol = col + dirs[dir][1];
		char nextCh = map[nRow][nCol];
		// 바로옆이 구슬인 경우
		if(otherM!=null && nRow==otherM.row && nCol==otherM.col) {
			newMarble = new Marble(m.color, row, col);
			newMarble.nextCh = otherM.color;
			return newMarble;
		}
		while(map[nRow][nCol]=='.') {
			nRow += dirs[dir][0];
			nCol += dirs[dir][1];
			nextCh = map[nRow][nCol];
			if(otherM!=null) {
				if(otherM.row==nRow && otherM.col==nCol) {
					// 다음칸이 구슬일 경우
					nextCh = otherM.color;
					break;
				}
			}
		}
		row = nRow - dirs[dir][0];
		col = nCol - dirs[dir][1];
		newMarble = new Marble(m.color,row,col);
		newMarble.nextCh = nextCh;
		
//		map[m.row][m.col] = '.';	// 이동 전 칸
//		map[row][col] = m.color;	// 이동 후 칸
		return newMarble;
	}
	
	
	private String direction(int dir) {
		String ret  = "";
		switch (dir) {
		case 0:
			ret = "상";
			break;
		case 1 :
			ret = "하";
			break;
		case 2 :
			ret = "좌";
			break;
		case 3 :
			ret = "우";
			break;
		default:
			break;
		}
		return ret;
	}
	
	
	private void printArr(char[][] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr[0].length ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	private void printList(List<Marble> list) {
		System.out.println(" : "+list.get(0)+", "+list.get(1));
	}
}

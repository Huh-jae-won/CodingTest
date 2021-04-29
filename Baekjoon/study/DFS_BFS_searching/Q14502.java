package DFS_BFS_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.border.EmptyBorder;

public class Q14502{
	static int N = 0;
	static int M = 0;
	static int[][] room;
	static ArrayList<Integer> virus;
	static int[] barrier;
	
	// 하, 우, 상, 좌 순으로
	static int[] dx = {1, 0, -1,  0};
	static int[] dy = {0, 1,  0, -1};
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
//			static 값 초기화
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			room = new int[N][M];
			int[][] temp = new int[N][M];
			virus = new ArrayList<Integer>();
			barrier = new int[3];
			int emptyRoom = 0;
			
//			 room에 입력 연구소 모양 그대로 입력, virus좌표  추가
			for(int i=0 ; i<N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<M ; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
					if(room[i][j]==2) {
						virus.add(10*i+j);
					}
				}
			}
			make_barrier(room);
			dup_arr(room,temp);
			boolean chk = true;
			while(chk) {
//				바이러스 확산
				for(int i=0 ; i<virus.size(); i++) {
					int row = virus.get(i)/10;
					int col = virus.get(i)%10;
					diffuse(temp, row, col);
				}
				emptyRoom = Math.max(emptyRoom, count_emptyRoom(temp));
				chk = move_barrier(room);
				dup_arr(room, temp);
			}
			System.out.println(emptyRoom);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void diffuse(int[][] arr,int row, int col) {
//		하,우,상,좌
		for(int i=0 ; i<4 ; i++) {
			int d_row = row+dx[i];
			int d_col = col+dy[i];
			if(d_row>-1 && d_row<N && d_col>-1 && d_col<M) {
				if(arr[d_row][d_col]==0) {
					arr[d_row][d_col] = 2;
					diffuse(arr, d_row, d_col);
				}
			}
		}
	}
	
	static int count_emptyRoom(int[][] arr) {
		int cnt = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				if(arr[i][j]==0)
					cnt++;
			}
		}
		return cnt;
	}
	static boolean check_emptyRoom(int[][] arr,int indx,boolean reset) {
		int row = barrier[indx]/10;
		int col = barrier[indx]%10;
		if(!reset) {
//			reset=false면 그냥 옮기기
			for(int j=col ; j<M ; j++) {
				if(arr[row][j]==0) {
					arr[row][j] = 7;
					arr[row][col] = 0;
					barrier[indx] = 10*row+j;
					return true;
				}
			}
			for(int i=row+1 ; i<N ; i++) {
				for(int j=0 ; j<M ; j++) {
					if(arr[i][j]==0) {
						arr[i][j] = 7;
						arr[row][col] = 0;
						barrier[indx] = 10*i+j;
						return true;
					}
				}
			}
		}else {
//			reset=true면 앞 barrier가 옮겨져서 다시 앞으로
			if(indx<=2) {
				int ix = barrier[indx-1]/10;
				int iy = barrier[indx-1]%10;
				arr[row][col] = 0;
				barrier[indx] = 100;
//			(ix, iy) : barrier[indx-1]의 좌표
				for(int j=iy ; j<M ; j++) {
					if(arr[ix][j]==0) {
						arr[ix][j] = 7;
						barrier[indx] = 10*ix+j;
						return true;
					}
				}
				for(int i=ix+1 ; i<N ; i++) {
					for(int j=0 ; j<M ; j++) {
						if(arr[i][j]==0) {
							arr[i][j] = 7;
							barrier[indx] = 10*i+j;
							return true;
						}
					}
				}
			}
			
		}
		return false;
	}
	static boolean move_barrier(int[][] arr) {
		int indx = 2;
		boolean reset = false;
		boolean chk = false;
		while(indx<3) {
			chk = check_emptyRoom(arr, indx, reset);
			if(chk) {
				indx++;
				reset = true;
			}
			else {
				indx--;
			}
			if(indx<0)
				return false;
		}
		return true;
	}
	static void make_barrier(int[][] arr) {
		int cnt = 0;
		for(int i=0 ; i<N ; i++) {
			if(cnt==3)
				break;
			for(int j=0 ; j<M ; j++) {
				if(arr[i][j]==0 && cnt<3) {
					arr[i][j] = 7;
					barrier[cnt++] = 10*i+j;
				}
			}
		}
	}
	
	
	static void dup_arr(int[][] src, int[][] desti) {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				desti[i][j] = src[i][j];
			}
		}
	}
	
	static void print_arr(int[][] arr) {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

package DFS_BFS_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q17141 {
	static int N=0;
	static int M=0;
	static char[][] room;
	static ArrayList<Integer> virus_list;
	static ArrayList<Integer> virus;
	// 하,우,상,좌
	static int[] dx = {-1, 0, 1,  0};
	static int[] dy = { 0, 1, 0, -1};
	static int emptyRoom;
	static char countTime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new char[N][N];
		char[][] temp = new char[N][N];
		virus_list = new ArrayList<Integer>();
		virus = new ArrayList<Integer>();
		boolean[] flag;
		
//		입력을 room배열로 옮기는 과정
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				char input = st.nextToken().charAt(0);
				if(input == '1') {
					room[i][j] = '-';
				}else if(input == '2') {
					room[i][j] = '0';
					virus_list.add(10*i+j);
				}else {
					room[i][j] = input;
				}
			}
		}
		flag = new boolean[virus_list.size()];
		System.out.println(virus_list);
		dup_arr(room, temp);
//		print_arr(temp);
		
		emptyRoom = N*N;
		countTime = 'z';
		dfs(temp,flag,0);
		if(emptyRoom>0) {
			System.out.println(-1);
		}else {
			System.out.println(countTime);
		}
	}
	static void dfs(char[][] arr,boolean[] flag,int bef) {
		if(virus.size()==M) {
			System.out.println(virus);
			dup_arr(room,arr);
			for(int i=0 ; i<M ; i++) {
				int row = virus.get(i)/10;
				int col = virus.get(i)%10;
				diffuse(arr, row, col, '0');
			}
			int temp_cnt_emptyRoom = count_emptyRoom(arr);
			if(temp_cnt_emptyRoom==0) {
				countTime = (char) Math.min(countTime, count_time(arr));				
				System.out.println(countTime);
			}
			emptyRoom = Math.min(emptyRoom,temp_cnt_emptyRoom);
			print_arr(arr);
			System.out.println();
		}else {
			for(int i=bef ; i<virus_list.size() ; i++) {
				if(!flag[i]) {
					flag[i] = true;
					virus.add(virus_list.get(i));
					dfs(arr, flag,i);
					virus.remove(virus_list.get(i));
					flag[i] = false;
				}
			}
		}
	}
	
	static int count_time(char[][] arr) {
		char time = '0';
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(arr[i][j]>time)
					time = arr[i][j];
			}
		}
		return time;
	}
	static int count_emptyRoom(char[][] arr) {
		int cnt = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(arr[i][j]=='0')
					cnt++;
			}
		}
		return cnt;
	}
	
	static void diffuse(char[][] arr, int row, int col, char cnt) {
		// 하, 우, 상, 좌 순
		if(cnt=='0') {
			arr[row][col] = '/';
		}
		for(int i=0 ; i<4 ; i++) {
			int d_row = row+dx[i];
			int d_col = col+dy[i];
			if(d_row>-1 &&  d_col>-1 && d_row<N && d_col<N) {
				if(arr[d_row][d_col]=='0' || (arr[d_row][d_col]!='0'&&arr[row][col]<arr[d_row][d_col])) {
					arr[d_row][d_col] = (char) (cnt+1);
					diffuse(arr,d_row,d_col,(char)(cnt+1));
				}
			}
		}
	}
	
	static void dup_arr(char[][] src, char[][] desti) {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				desti[i][j] = src[i][j];
			}
		}
	}
	
	static void print_arr(char[][] arr) {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}

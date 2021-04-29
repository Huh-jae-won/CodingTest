package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1175 {
	// 실패
	
	static class Class{
		int[] pos;
		boolean enter;			// # or . 경우
		boolean start = false;	// S 경우
		boolean desti = false;	// C 경우
		boolean check = false;	// 들렸는지 확인
		int way;
		int cnt;
		Class(int[] pos, boolean enter,int way,int cnt){
			this.pos = pos;
			this.enter = enter;
			this.way = way;
			this.cnt = cnt;
		}
	}
	//					 R, D,  L,  U
	static int[] dRow = {0, 1,  0, -1};
	static int[] dCol = {1, 0, -1,  0};
	static int N;
	static int M;
	static int value;
	static Class[][] map;
	static Queue<Class> route = new LinkedList();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Class[N][M];
		makeMap(br);
		bfs();
		
//		for(int i=0 ; i<N ; i++) {
//			for(int j=0 ; j<M ; j++) {
//				System.out.print(map[i][j].pos+" ");
//			}
//			System.out.println();
//		}
	}
	
	static void bfs() {
		int minRoute = Integer.MAX_VALUE;
		Class temp = null;
		while(!route.isEmpty()) {
			temp = route.poll();
			if(temp.desti==true) {
				temp.cnt++;
				if(temp.cnt==2) {
					minRoute = Math.min(minRoute,value);
					if(minRoute!=value) {
						break;
					}
				}
			}else {
				for(int i=0 ; i<4 ; i++) {
					if(temp.way == i)
						continue;
					int row = temp.pos[0] + dRow[i];
					int col = temp.pos[1] + dCol[i];
					if(map[row][col].enter && !map[row][col].check) {
						map[row][col].check = true;	// 들렸음을 체크
						map[row][col].way = i;
					}
					
				}
				
			}
		}
	}
	
	static void makeMap(BufferedReader br) throws IOException {
		for(int i=0 ; i<N ; i++) {
			String line = br.readLine();
			int[] temp = new int[2];
			for(int j=0 ; j<M ; j++) {
				String str = line.charAt(j)+"";
				temp[0] = i;
				temp[1] = j;
				if(str.equals("S")) {
					map[i][j] = new Class(temp,true,0,0);
					map[i][j].start = true;
					map[i][j].check = true;
					route.add(map[i][j]);
				}else if(str.equals("C")) {
					map[i][j] = new Class(temp,true,0,0);
					map[i][j].desti = true;
				}else if(str.equals(".")){
					map[i][j] = new Class(temp,true,0,0);
				}else{
					map[i][j] = new Class(temp,false,0,0);
				}
			}
		}
	}

}

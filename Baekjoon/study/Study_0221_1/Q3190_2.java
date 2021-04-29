package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q3190_2 {
	static int N;	// 보드의 크기
	static int K;	// 사과의 갯수
	static int L;	// 방향 변환 횟수
	static int[][] map;
	static int[][] apple;
	static String[][] direction;
	//					 R, D,  L,  U
	static int[] dRow = {0, 1,  0, -1};
	static int[] dCol = {1, 0, -1,  0};
	static ArrayList<Snake> snakeList;
	
	static class Snake{
		int[] pos;
		int way;
		Snake front;
		Snake(int[] pos, Snake front,int way,int befWay){
			this.pos = pos;
			this.front = front;
			this.way = way;	// 지금 갈 방향
			// way
			// 0 : 오른쪽
			// 1 : 아래쪽
			// 2 : 왼쪽
			// 3 : 위쪽
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		int time = 1;
		snakeList = new ArrayList();
		int[] start = {1,1};
		snakeList.add(new Snake(start,null,0,0));
		try {
			while(time<10000) {
//					System.out.println(time);
					if(!moveSnake(snakeList, time)) {
						System.out.println(time);
						break;
					}
					snakeMapping(snakeList, time);
//					printMap();
					time++;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(time);
			
		}
	}
	
	static boolean moveSnake(ArrayList<Snake> snakeList, int time) {
		int[] arr = new int[2];
		// snake 옮기기
		if(chkNextApple(snakeList.get(0),arr)) {
			// 이동할 다음칸에 사과가 있다면
			snakeList.add(0,new Snake(arr,null,snakeList.get(0).way,snakeList.get(0).way));
			snakeList.get(1).front = snakeList.get(0);
		}else {
			int length = snakeList.size();
			if(!chkFinish()) {
				return false;
			}
			for(int i=length-1 ; i>-1 ; i--) {
				// 꼬리 부터 옮김
				Snake temp = snakeList.get(i);
				if(temp.front == null) {
//					head일 때
					temp.pos[0] = temp.pos[0] + dRow[temp.way];
					temp.pos[1] = temp.pos[1] + dCol[temp.way];
				}else {
					temp.pos[0] = temp.front.pos[0];
					temp.pos[1] = temp.front.pos[1];
				}
			}
		}
		nextDirection(snakeList.get(0), time);
		return true;
	}
	
	static boolean chkFinish() {
		Boolean hit = true;
		int length = snakeList.size();
		int row = snakeList.get(0).pos[0] + dRow[snakeList.get(0).way];
		int col = snakeList.get(0).pos[1] + dCol[snakeList.get(0).way];
		for(int i=1 ; i<length ; i++) {
			int dx = snakeList.get(i).pos[0];
			int dy = snakeList.get(i).pos[1];
			if(row==dx && col==dy || row<1 || col<1) {
				return false;
			}
		}
		return true;
	}
	static void nextDirection(Snake snake, int time) {
		int nWay = snake.way;
		String turn = null;
		for(int i=0 ; i<direction.length ; i++) {
			if(Integer.parseInt(direction[i][0])==time) {
				turn = direction[i][1];
				if(turn.equals("D")) {
					nWay = (snake.way+1) % 4;
				}else if(turn.equals("L")) {
					nWay = (snake.way+3) % 4;
				}
				snake.way = nWay;
				return ;
			}
		}
	}
	
	
	static void snakeMapping(ArrayList<Snake> snakeList,int time) {
		for(int i=1 ; i<N+1 ; i++) {
			for(int j=1 ; j<N+1 ; j++) {
				if(map[i][j]==1)
					map[i][j] = 0;
			}	
		}
		int length = snakeList.size();
		for(int i=0 ; i<length ; i++) {
			int row = snakeList.get(i).pos[0];
			int col = snakeList.get(i).pos[1];
			map[row][col] = 1;
		}
	}
		
	static boolean chkNextApple(Snake node,int[] arr) {
		int[] nPos = new int[2];
		nPos[0] = node.pos[0] + dRow[node.way];
		nPos[1] = node.pos[1] + dCol[node.way];
		if(map[nPos[0]][nPos[1]]==7) {
			arr[0] = nPos[0];
			arr[1] = nPos[1];
			return true;
		}
		return false;
	}
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		apple = new int[K][2];
		for(int i=0 ; i<K ; i++) {
			st = new StringTokenizer(br.readLine());
			apple[i][0] = Integer.parseInt(st.nextToken());
			apple[i][1] = Integer.parseInt(st.nextToken());
			int row = apple[i][0];
			int col = apple[i][1];
			map[row][col] = 7;
		}
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		direction = new String[L][2];
		for(int i=0 ; i<L ; i++) {
			st = new StringTokenizer(br.readLine());
			direction[i][0] = st.nextToken();
			direction[i][1] = st.nextToken();
		}
		
	}
	
	static void printMap() {
		for(int i=1 ; i<N+1 ; i++) {
			for(int j=1 ; j<N+1 ; j++) {
				System.out.print(map[i][j]+" ");
			}	
			System.out.println();
		}
		System.out.println();
	}
}

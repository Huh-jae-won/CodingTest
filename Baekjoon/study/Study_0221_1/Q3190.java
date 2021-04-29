package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3190 {
	static int N;	// 보드의 크기
	static int K;	// 사과의 갯수
	static int L;	// 방향 변환 횟수
	static int[][] map;
	static int[][] apple;
	static String[][] direction;
	
	//					 R, D,  L,  U
	static int[] dRow = {0, 1,  0, -1};
	static int[] dCol = {1, 0, -1,  0};
	
	
	static class Snake{
		int[] head;
		int[] tail;
		Queue<int[]> body;
		int way;
		Snake(int[] head, int[] tail, Queue body,int way){
			this.head = head;
			this.body = body;
			this.tail = tail;
			this.way = way;
			// way
			// 0 : 오른쪽
			// 1 : 아래쪽
			// 2 : 왼쪽
			// 3 : 위쪽
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		int time = 0;
		int[] head = {1,1};
		int[] tail = {1,1};
		Queue<int[]> body = new LinkedList();
		Snake snake = new Snake(head,tail,body,0);
		
		snake_mapping(snake,time);
		try {
			for(time=1 ; time<20 ; time++) {
				System.out.println(time);
				move_snake(snake,time);
				snake_mapping(snake, time);
				for(int i=1 ; i<N+1 ; i++) {
					for(int j=1 ; j<N+1 ; j++) {
						System.out.print(map[i][j]+" ");
					}
					System.out.println();
				}
				System.out.println();
				if(snake.head[0]*snake.head[1] == 0) {
					System.out.println(time);
				}
			}
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(time);
		}
	}
	static void move_snake(Snake snake,int time) {
		boolean eat;
		int[] nHead = new int[2];
		int[] nTail = new int[2];
		map[snake.head[0]][snake.head[1]] = 0;
		map[snake.tail[0]][snake.tail[1]] = 0;
		
		// head 옮기기
		nHead[0] = snake.head[0] + dRow[snake.way];
		nHead[1] = snake.head[1] + dCol[snake.way];
		snake.head[0] = nHead[0];
		snake.head[1] = nHead[1];
		eat = check_apple(snake);
		
		// bdoy 옮기기
		int length = snake.body.size();
		for(int i=0 ; i<length ; i++) {
			int[] temp = new int[2];
			map[snake.body.peek()[0]][snake.body.peek()[1]] = 0;
			temp[0] = snake.body.peek()[0] + dRow[snake.way];
			temp[1] = snake.body.poll()[1] + dCol[snake.way];
			snake.body.add(temp);
		}
		// tail 옮기기
		if(!eat) {
			nTail[0] = snake.tail[0] + dRow[snake.way];
			nTail[1] = snake.tail[1] + dCol[snake.way];
			snake.tail[0] = nTail[0];
			snake.tail[1] = nTail[1];
		}
		nextDirection(snake,time);
	}
	static void nextDirection(Snake snake, int time) {
		int way = snake.way;
		String turn = null;
		for(int i=0 ; i<direction.length ; i++) {
			if(Integer.parseInt(direction[i][0])==time) {
				turn = direction[i][1];
				if(turn.equals("D")) {
					way = (way+1) % 4;
				}else if(turn.equals("L")) {
					way = (way+3) % 4;
				}
				snake.way = way;
				return ;
			}
		}
	}
	
	static boolean check_apple(Snake snake) {
		int[] nHead = new int[2];
		nHead[0] = snake.head[0];
		nHead[1] = snake.head[1];
		if(map[nHead[0]][nHead[1]]==7) {
			return true;
		}
		return false;
	}
	static void snake_mapping(Snake snake,int time) {
		int[] head = new int[2];
		int[] tail = new int[2];
		int[] temp = new int[2];
		Queue<int[]> body = new LinkedList();
		head = snake.head;
		tail = snake.tail;
		body = snake.body;
		
		int row = head[0];
		int col = head[1];
		map[row][col] = 1;
		
		row = tail[0];
		col = tail[1];
		map[row][col] = 1;
		
		int length = body.size();
		for(int i=0 ; i<length ; i++) {
			temp = body.poll();
			row = temp[0];
			col = temp[1];
			map[row][col] = 1;
			body.add(temp);
		}
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

}

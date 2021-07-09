import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q03190_Snake {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q03190_Snake z = new Q03190_Snake();
		z.solution();
	}
	class Snake{
		int[] head;
		List<int[]> body;
		int dir;
		public Snake() {
			head = new int[2];
			head[0] = 1;
			head[1] = 1;
			dir = 1;
			body = new ArrayList<>();
			body.add(new int[] {1,1});
		}
		@Override
		public String toString() {
			return "[h="+Arrays.toString(head)+", dir=" + dir + "]";
		}
	}
	int N = 0;	// 보드 크기
	int K = 0;	// 사과 갯수
	int L = 0;	// 전환 횟수
	List<int[]> appleList;
	String[] moveDir = {"상","우","하","좌"};	// 0상 1우 2하 3좌
	int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		appleList = new ArrayList<>();
		StringTokenizer st;
		for(int i=0 ; i<K ; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col= Integer.parseInt(st.nextToken());
			appleList.add(new int[] {row,col});
		}
		
		L = Integer.parseInt(br.readLine());
		char[] dirChange = new char[100000];
		for(int i=0 ; i<L ; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			dirChange[time] = dir;
		}
//		System.out.print("a : ");
//		printList(appleList);
//		System.out.println(dirChange);
		Snake snake = new Snake();
		int ret = play(snake, dirChange);
		System.out.println(ret);
	}
	private int play(Snake snake, char[] dirChange) {
		int time = 1;
		int changeTime = 0;
		while(move(snake)) {
			changeDirection(snake, dirChange[time]);
//			System.out.print(time+" : "+snake+", ");
//			printList(snake.body);
//			printBoard(snake);
			time++;
		}
		return time;
	}
	
	private boolean move(Snake snake) {
		int hRow = snake.head[0];
		int hCol = snake.head[1];	// 기존 head위치
		int nHRow = hRow + dirs[snake.dir][0];
		int nHCol = hCol + dirs[snake.dir][1];	// 새 head 위치
		snake.body.add(new int[] {nHRow,nHCol});
		snake.head[0] = nHRow;
		snake.head[1] = nHCol;
		if(hitBody(snake) || hitEdge(snake))
			return false;
		int appleIdx;
		if((appleIdx=isApple(snake))!=-1) {
			// head 위치가 사과인 경우
			appleList.remove(appleIdx);
		}else {
			// 사과 못먹은 경우
			snake.body.remove(0);
		}
		return true;
	}
	private int isApple(Snake snake) {
		int[] head = snake.head;
		for(int i=0 ; i<appleList.size() ; i++) {
			int[] temp = appleList.get(i);
			if(Arrays.equals(head, temp)) {
				return i;
			}
		}
		return -1;
	}
	private void changeDirection(Snake snake,char change) {
		if(change=='D') {
			snake.dir = (snake.dir+1)%4;
		}else if(change=='L'){
			snake.dir = (snake.dir+3)%4;
		}
	}
	
	private boolean hitBody(Snake snake) {
		for(int i=0 ; i<snake.body.size()-1 ; i++) {
			int[] body = snake.body.get(i);
			if(Arrays.equals(snake.head, body)) {
				return true;
			}
		}
		return false;
	}
	private boolean hitEdge(Snake snake) {
		int row = snake.head[0];
		int col = snake.head[1];
		if(row<1 || row>N || col<1 || col>N)
			return true;
		return false;
	}
	private void printList(List<int[]> list) {
		for(int[] arr : list) {
			System.out.print(Arrays.toString(arr)+" ");
		}
		System.out.println();
	}
	private void printBoard(Snake snake) {
		int[][] board = new int[N+1][N+1];
		for(int[] arr : snake.body) {
			board[arr[0]][arr[1]] = 1;
		}
		board[snake.head[0]][snake.head[1]] = 9;
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=N ; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

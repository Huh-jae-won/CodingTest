import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14499_RollDice {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q14499_RollDice z= new Q14499_RollDice();
		z.solution();
	}
	class Dice{
		int row;
		int col;
		int[] horizontal;	// 0:위, 1:우, 2:아, 3:좌
		int[] vertical;		// 0:위, 1:하, 2:아, 3:상
		public Dice(int row, int col) {
			this.row = row;
			this.col = col;
			horizontal = new int[4];
			vertical = new int[4];
			Arrays.fill(horizontal, 0);
			Arrays.fill(vertical, 0);
		}
		private void roll(int dir) {
			switch (dir) {
			case 1 : // 우
				int temp = horizontal[3]; 
				for(int i=3 ; i>0 ; i--) {
					horizontal[i] = horizontal[i-1];
				}
				horizontal[0] = temp;
				vertical[0] = horizontal[0];
				vertical[2] = horizontal[2];
				break;
			case 2 : // 좌
				temp = horizontal[0];
				for(int i=0 ; i<3 ; i++) {
					horizontal[i] = horizontal[i+1];
				}
				horizontal[3] = temp;
				vertical[0] = horizontal[0];
				vertical[2] = horizontal[2];
				break;
			case 3 : // 북
				temp = vertical[0];
				for(int i=0 ; i<3 ; i++) {
					vertical[i] = vertical[i+1];
				}
				vertical[3] = temp;
				horizontal[0] = vertical[0];
				horizontal[2] = vertical[2];
				break;
			case 4 : // 남
				temp = vertical[3]; 
				for(int i=3 ; i>0 ; i--) {
					vertical[i] = vertical[i-1];
				}
				vertical[0] = temp;
				horizontal[0] = vertical[0];
				horizontal[2] = vertical[2];
				break;
			default:
				break;
			}
		}
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("("+row+", "+col+") : h:");
			sb.append(Arrays.toString(horizontal));
			sb.append(", v:");
			sb.append(Arrays.toString(vertical));
			return sb.toString();
		}
	}
	int N = 0;
	int M = 0;
	int K = 0;
	int[][] board;
	int[] order;
	StringBuilder log;
	Dice dice;
	// 					0,   우,     좌,   상,    하
	int[][] dirs = {{0,0},{0,1},{0,-1},{-1,0},{1,0}}; 
	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		order = new int[K];
		
		log = new StringBuilder();
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<K ; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		dice = new Dice(row, col);
//		printArr(board);
//		System.out.println(dice);
		play(order);
//		System.out.println("log : "+log);
	}
	private void play(int[] order) {
		for(int i = 0 ; i<K ; i++) {
			int dir = order[i];
			// move
			if(move(dir)) {
				// change 값
				change(dir);
				System.out.println(dice.horizontal[0]);
//				log.append(dice.horizontal[0]+" ");
			}
//			System.out.println("<<"+i+":"+dir+">>");
//			printArr(board);
//			System.out.println(dice);
		}
	}
	private boolean move(int dir) {
		int nRow = dice.row + dirs[dir][0];
		int nCol = dice.col + dirs[dir][1];
		if(inRange(nRow,nCol)) {
			dice.row = nRow;
			dice.col = nCol;
			dice.roll(dir);
			return true;
		}
		return false;
	}
	private void change(int dir) {
		int row = dice.row;
		int col = dice.col;
		if(board[row][col]==0) {
			board[row][col] = dice.horizontal[2];
		}else {
			dice.horizontal[2] = board[row][col];
			dice.vertical[2] = dice.horizontal[2];
			board[row][col] = 0;
		}
	}
	
	
	private boolean inRange(int row, int col) {
		if(row>=0 && row<N && col>=0 && col<M)
			return true;
		return false;
	}
	
	private void printArr(int[][] arr) {
		for(int[] temp : arr) {
			System.out.println(Arrays.toString(temp));
		}
	}
}

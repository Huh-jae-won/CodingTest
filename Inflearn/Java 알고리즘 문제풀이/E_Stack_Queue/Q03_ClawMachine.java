package E_Stack_Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q03_ClawMachine {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q03_ClawMachine a = new Q03_ClawMachine();
		a.solution();
	}	
	int N=0;
	int[][] board;
	int M=0;
	Stack<Integer> stack;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N+1];
		stack = new Stack<>();
		StringTokenizer st;
		int ret = 0;
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1 ; j<N+1 ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<M ; i++) {
			int move = Integer.parseInt(st.nextToken());
			int doll = getDoll(move);
			if(stack.size()==0) {
				if(doll!=0)
					stack.push(doll);
			}else {
				if(doll!=0) {
					if(stack.peek()==doll) {
						stack.pop();
						ret += 2;
					}else {
						stack.push(doll);
					}
				}
			}
		}
		System.out.println(ret);
		br.close();
	}
	private int getDoll(int move) {
		int ret = 0;
		for(int i=0 ; i<N ; i++) {
			if(board[i][move]!=0) {
				ret = board[i][move];
				board[i][move] = 0;
				break;
			}
		}
		return ret;
	}
}

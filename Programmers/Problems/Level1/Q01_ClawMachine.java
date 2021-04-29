package Level1;

import java.util.Stack;

public class Q01_ClawMachine {
	public static void main(String[] args) {
	 Q01_ClawMachine a = new Q01_ClawMachine();
	 StringBuilder sb = new StringBuilder("abcd");
	 sb.substring(0, 1);
	 System.out.println(sb.substring(0,2));
	 int[][] board = {
			 {0,0,0,0,0},
			 {0,0,1,0,3},
			 {0,2,5,0,1},
			 {4,2,4,4,2},
			 {3,5,1,3,1}
	 };
	 int[] moves = {1,5,3,5,1,2,1,4};
	 
	 System.out.println("ret : "+a.solution(board,moves));
	}
	public int solution(int[][] board, int[] moves) {

        Stack<Integer> st = new Stack<>();
        
        int len = board.length;
        int noCount = 0;
        for(int i=0 ; i<moves.length ; i++){
             System.out.println(i+"ȸ"+", index : "+(moves[i]-1));
            if(pickUP(st,board,moves[i]-1)){
                noCount++;
            }
        }
        return moves.length-st.size()-noCount;
    }
    private boolean pickUP(Stack<Integer> st,int[][] board, int pos){
        int len = board.length;
        boolean noCount = true;
        for(int i=0 ; i<len ; i++){
            if(board[i][pos]!=0){
                 System.out.println("doll : "+board[i][pos]+",  "+st);
                 System.out.println();
                int doll = board[i][pos];
                if(!st.isEmpty() && st.peek()==doll){
                    st.pop();
                    board[i][pos] = 0;
                    noCount = false;
                    break;
                }
                if(st.isEmpty() || st.peek()!=doll){
                    board[i][pos] = 0;
                    st.push(doll);
                    noCount = false;
                    break;
                }
            }
        }
        return noCount;
    }
	
}

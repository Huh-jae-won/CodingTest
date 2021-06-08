package Level2;

public class Q14_BiggestSquare {
	public static void main(String[] args) {
		Q14_BiggestSquare a = new Q14_BiggestSquare();
		int[][] board = {
				{0,1,1,1},
				{1,1,1,1},
				{1,1,1,1},
				{0,0,1,0}
		};
		System.out.println(a.solution(board));
	}
    public int solution(int [][]board){
        int ret = board[0][0];
        int lenRow = board.length;
        int lenCol = board[0].length;
        for(int i=1 ; i<lenRow ; i++){
            for(int j=1 ; j<lenCol ; j++){
                if(board[i][j]==1){
                    board[i][j] = Math.min(Math.min(board[i-1][j-1],board[i-1][j]),board[i][j-1])+1;
                    ret = Math.max(board[i][j],ret);
                }
            }
        }
        return ret*ret;
    } 
}

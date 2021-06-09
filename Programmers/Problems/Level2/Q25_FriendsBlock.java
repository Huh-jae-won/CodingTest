package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q25_FriendsBlock {
	public static void main(String[] args) {
		Q25_FriendsBlock a = new Q25_FriendsBlock();
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		int m = board.length;
		int n = board[0].length();
		System.out.println(a.solution(m, n, board));
	}
    public int solution(int m, int n, String[] board) {
        char[][] arr = new char[m][n];
        int ret = 0;
        for(int i=0 ; i<m ; i++){
            arr[i] = board[i].toCharArray();
        }
        while(true){
            List<int[]> list = pang(arr);
            // printList(list);
            // printArr(arr);
            // System.out.println();
            if(list.size()==0)
                break;
            ret += remove(arr,list);
            move(arr);
        }
        // printArr(arr);
        return ret;
    }
    private void move(char[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        for(int j=0 ; j<n ; j++){
            for(int i=0 ; i<m-1 ; i++){
                if(arr[i][j]!=' ' && arr[i+1][j]==' '){
                    for(int k=i ; k>=0 ; k--){
                        arr[k+1][j] = arr[k][j];
                        arr[k][j] = ' ';
                    }
                }
            }
        }
    }
    
    int[][] dirs = {{0,0},{0,1},{1,0},{1,1}};
    private int remove(char[][] arr,List<int[]> list){
        int ret = 0;
        for(int[] pangArr : list){
            for(int i=0 ; i<4 ; i++){
                int nRow = pangArr[0] + dirs[i][0];
                int nCol = pangArr[1] + dirs[i][1];
                if(arr[nRow][nCol]==' ')
                    continue;
                arr[nRow][nCol] = ' ';
                ret++;
            }
        }
        return ret;
    }
    private List<int[]> pang(char[][]arr){
        List<int[]> ret = new ArrayList<>();
        int m = arr.length;
        int n = arr[0].length;
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(chkPang(arr,i,j)){
                    ret.add(new int[]{i,j});
                }
            }
        }
        return ret;
    }
    
    private boolean chkPang(char[][] arr, int row, int col){
        int m = arr.length;
        int n = arr[0].length;
        char ch = arr[row][col];
        if(ch==' ')
            return false;
        if(row>=m-1 || col>=n-1)
            return false;
        char ch2 = arr[row][col+1];
        char ch3 = arr[row+1][col];
        char ch4 = arr[row+1][col+1];
        return (ch==ch2 && ch2==ch3 && ch3==ch4);
    }
    private void printList(List<int[]> list){
        for(int[] arr : list){
            System.out.print(Arrays.toString(arr)+" ");
        }
        System.out.println();
    }
    private void printArr(char[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

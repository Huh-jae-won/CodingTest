package Level2;

import java.util.Arrays;

public class Q27_SnailRotate {
	public static void main(String[] args) {
		Q27_SnailRotate a = new Q27_SnailRotate();
		int n = 4;
		int[] ret = a.solution(n);
		System.out.println(Arrays.toString(ret));
	}
    public int[] solution(int n) {
        int[] ret = move(n);
        return ret;
    }
    int[][] dirs = {{1,0},{0,1},{-1,-1}};
    private int[] move(int n){
        int[][] arr = new int[n][n];
        int cRow = -1;
        int cCol = 0;
        int dir = 0;
        int num = 1;
        int stopCnt = 0;
        int size = 0;
        while(true){
            int nRow = cRow + dirs[dir][0];
            int nCol = cCol + dirs[dir][1];
            if(canMove(arr,nRow,nCol)){
                arr[nRow][nCol] = num;
                size = num;
                stopCnt = 0;
                num++;
                cRow = nRow;
                cCol = nCol;
            }else{
                dir = (dir+1)%3;
                stopCnt++;
            }
            if(stopCnt>1)
                break;
        }
         printArr(arr);
        int[] ret = makeRet(arr,size);
        return ret;
    }
    private int[] makeRet(int[][] arr, int size){
        int[] ret =  new int[size];
        int idx = 0;
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr.length ; j++){
                if(arr[i][j]!=0){
                    ret[idx++] = arr[i][j];
                }else{
                    break;
                }
            }
        }
        return ret;
    }
    private boolean canMove(int[][] arr, int row, int col){
        int n = arr.length;
        if(inRange(n,row,col)){
            if(arr[row][col]==0)
                return true;
        }
        return false;
    }
    private boolean inRange(int n, int row, int col){
        if(row>=0 && row<n && col>=0 && col<n)
            return true;
        return false;
    }
    private void printArr(int[][] arr){
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr.length ; j++){
                System.out.printf("%2d ",arr[i][j]);
            }
            System.out.println();
        }
    }
}

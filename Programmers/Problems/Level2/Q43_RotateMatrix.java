package Level2;

import java.util.Arrays;

public class Q43_RotateMatrix {
	public static void main(String[] args) {
		Q43_RotateMatrix z = new Q43_RotateMatrix();
		int rows = 6;
		int columns = 6;
		int[][] queries = {
				{2,2,5,4},
				{3,3,6,6},
				{5,1,6,3}	
		};
		int[]ret = z.solution(rows, columns, queries);
		System.out.println(Arrays.toString(ret));
	}
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows+1][columns+1];
        int[] ret = new int[queries.length];
        int num = 1 ;
        for(int i=1 ; i<=rows ; i++){
            for(int j=1 ; j<=columns ; j++){
                map[i][j] = num++;
            }
        }
        for(int i=0 ; i<queries.length ; i++){
            int[] pos1 = {queries[i][0],queries[i][1]};
            int[] pos2 = {queries[i][2],queries[i][3]};
            int min = rotate(map,pos1,pos2);
            ret[i] = min;
            
        }
        return ret;
    }
    private int rotate(int[][] map, int[] pos1, int[] pos2){
        int min  = Integer.MAX_VALUE;
        // 오른쪽
        int befo = map[pos1[0]][pos1[1]];
        for(int j=pos1[1]+1 ; j<=pos2[1] ; j++){
            int temp = map[pos1[0]][j];
            map[pos1[0]][j] = befo;
            min = Math.min(map[pos1[0]][j],min);
            befo = temp;
        }
        // 아래쪽
        for(int i=pos1[0]+1 ; i<=pos2[0] ; i++){
            int temp = map[i][pos2[1]];
            map[i][pos2[1]] = befo;
            min = Math.min(map[i][pos2[1]],min);
            befo = temp;
        }
        // 왼쪽
        for(int j=pos2[1]-1 ; j>=pos1[1] ; j--){
            int temp = map[pos2[0]][j];
            map[pos2[0]][j] = befo;
            min = Math.min(map[pos2[0]][j],min);
            befo = temp;
        }
        // 위쪽
        for(int i=pos2[0]-1 ; i>=pos1[0] ; i--){
            int temp = map[i][pos1[1]];
            map[i][pos1[1]] = befo;
            min = Math.min(map[i][pos1[1]],min);
            befo = temp;
        }
        // printMap(map);
        return min;
    }
    
    private void printMap(int[][] map){
        int m = map.length;
        int n = map[0].length;
        for(int i=1 ; i<m ; i++){
            for(int j=1 ; j<n ; j++){
                System.out.printf("%2d ",map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

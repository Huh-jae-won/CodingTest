package Level2;

import java.util.Arrays;

public class Q03_MatrixMultiply {
	public static void main(String[] args) {
		Q03_MatrixMultiply a = new Q03_MatrixMultiply();
		int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
		int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		int[][] ret = a.solution(arr1, arr2);
		for(int i=0 ; i<ret.length ; i++) {
			System.out.println(Arrays.toString(ret[i]));
		}
	}
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int x1 = arr1.length;
        int y1 = arr1[0].length;
        int x2 = arr2.length;
        int y2 = arr2[0].length;
        
        int[][] ret = new int[x1][y2];
        for(int i=0 ; i<x1 ; i++){
            for(int j=0 ; j<y2 ; j++){
                int num = 0;
                for(int k=0 ; k<y1 ; k++){
                    num += arr1[i][k] * arr2[k][j];
                }
                ret[i][j] = num;
            }
        }
        return ret;
    }
}

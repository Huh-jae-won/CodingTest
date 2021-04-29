package A_String_Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q16_SpiralMatrix {

	public static void main(String[] args) {
		Q16_SpiralMatrix q16 = new Q16_SpiralMatrix();
		// input 생성
		int M = 5;
		int N = 3;
		int[][] matrix = new int[M][N];
		for(int i=0 ; i<M ; i++) {
			for(int j=0 ; j<N ; j++) {
				matrix[i][j] = (int) (Math.random()*100);
			}
		}
		////////////////////////
		q16.print(matrix);
		
		System.out.println(q16.solve(matrix));
		System.out.println(q16.solution(matrix));
	}
	public List<Integer> solution(int[][] matrix){
		List<Integer> result = new ArrayList<>();
		if(matrix==null || matrix.length==0)
			return result;
		
		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		int colStart = 0;
		int colEnd = matrix[0].length - 1;
		
		while(rowStart<=rowEnd && colStart<=colEnd) {
			// right
			for(int i=colStart ; i<=colEnd ; i++) {
				result.add(matrix[rowStart][i]);
			}
			rowStart++;
			
			// down
			for(int i=rowStart ; i<=rowEnd ; i++) {
				result.add(matrix[i][colEnd]);
			}
			colEnd--;
			
			// left
			if(rowStart<=rowEnd)
			for(int i=colEnd ; i>=colStart ; i--) {
				result.add(matrix[rowEnd][i]);
			}
			rowEnd--;
			
			// up
			if(colStart<=colEnd)
			for(int i=rowEnd ; i>=rowStart ; i--) {
				result.add(matrix[i][colStart]);
			}
			colStart++;
			
		}
		
		return result;
	}
	public List<Integer> solve(int[][] matrix){
//					     상, 우, 하, 좌 
		int[] dRow = {-1, 0, 1,  0};
		int[] dCol = { 0, 1, 0, -1};
		
		List<Integer> list = new LinkedList<>();
		
		int curRow = 0;
		int curCol = 0;
		Set<Integer> set = new HashSet<>();
		set.add(curRow*10+curCol);
		list.add(matrix[0][0]);
		while(set.size()< matrix.length*matrix[0].length) {
			for(int i=0 ; i<4 ; i++) {
				while(true) {
					int nRow = curRow + dRow[i];
					int nCol = curCol + dCol[i];
					if(!range(matrix,nRow,nCol))
						break;
					if(set.contains(nRow*10+nCol)) {
						break;
					}
					curRow = nRow;
					curCol = nCol;
					list.add(matrix[curRow][curCol]);
					set.add(curRow*10+curCol);
				}
			}
		}
		return list;
	}
	private boolean range(int[][] matrix, int nRow, int nCol) {
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
		if(nRow<0 || nRow>=maxRow || nCol<0 || nCol>=maxCol)
			return false;
		return true;
	}
	
	public void print(int[][] matrix) {
		for(int i=0 ; i<matrix.length ; i++) {
			for(int j=0 ; j<matrix[0].length ; j++) {
				System.out.printf("%3d ",matrix[i][j]);
			}
			System.out.println();
		}
	}
}

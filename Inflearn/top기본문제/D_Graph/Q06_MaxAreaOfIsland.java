package D_Graph;

public class Q06_MaxAreaOfIsland {

	public static void main(String[] args) {
		Q06_MaxAreaOfIsland q06 = new Q06_MaxAreaOfIsland();
		int[][] grid = {
				 {1,1,0,1,1},
				 {0,1,1,0,0},
				 {0,0,0,0,0},
				 {1,1,0,1,1},
				 {1,0,1,1,1},
				 {1,0,1,1,1}};
		
		int ret = 0;
		ret = q06.maxArea(grid);
//		ret = q06.solution(grid);
		System.out.println("===result===");
		System.out.println(ret);
		
	}
	
	int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};	// 상하좌우
	int m,n;
	private int dfs(int[][] grid, int row, int col, int area) {
		if(row<0 || row>=m || col<0 || col>=n || grid[row][col]==0) {
			return area;
		}
		
		// 1인경우
		grid[row][col] = 0;
		area++;
		
		for(int[] dir : dirs) {
			area = dfs(grid,row+dir[0],col+dir[1],area);
		}
		
		return area;
	}
	public int solution(int[][] grid) {
		if(grid==null || grid.length==0)
			return 0;
		m = grid.length;
		n = grid[0].length;
		int max = 0;
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(grid[i][j]==1) {
					int area = dfs(grid,i,j,0);
					max = Math.max(max, area);
				}
			}
		}
		return max;
	}
	
	
	/////////////////////////////////////////////////////
	private int area(int[][] grid, int row, int col) {
		if(grid[row][col]==1) {
			grid[row][col] = 9;
		}
		System.out.printf("%d,%d\n",row,col);
//						상,하,좌,우
		int maxArea = 1;
		int[] dRow = {-1,1,0,0};
		int[] dCol = {0,0,-1,1};
		for(int i=0 ; i<4 ; i++) {
			int nRow = row + dRow[i];
			int nCol = col + dCol[i];
			if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length) {
				if(grid[nRow][nCol]==1) {
					maxArea += area(grid,nRow,nCol);
				}
			}
		}
		return maxArea;
	}
	public int maxArea(int[][] grid) {
		if(grid==null || grid.length==0 || grid[0].length==0)
			return 0;
		int maxArea = 0;
		for(int i=0 ; i<grid.length ; i++) {
			for(int j=0 ; j<grid[i].length ; j++) {
				if(grid[i][j]==1) {
					int area = area(grid,i,j);
					System.out.println("area : "+area);
					maxArea = Math.max(area, maxArea);
				}
			}
		}
		return maxArea;
	}

}

package D_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q01_NumOfIsland_DFS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int row = 4;
		int col = 5;
		char[][] grid = new char[row][col];
		// 1: 级, 0 : 拱
		for(int i=0 ; i<row ; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		Q01_NumOfIsland_DFS q01 = new Q01_NumOfIsland_DFS();
		System.out.println("===reuslt===");
		System.out.println(q01.numsIslands(grid));
//		System.out.println(q01.solution(grid));
	}
	
	
	private void dfs(char[][] grid, int row, int col) {
		int m = grid.length;
		int n = grid[0].length;
		if(row<0 || row>=m || col<0 || col>=n || grid[row][col]!='1')
			return ;
		grid[row][col] = 'x';
		dfs(grid,row-1,col);	// 惑
		dfs(grid,row+1,col);	// 窍
		dfs(grid,row,col-1);	// 谅
		dfs(grid,row,col+1);	// 快
	}
	public int solution(char[][] grid) {
		// error 贸府
		if(grid==null || grid.length==0 || grid[0].length==0) {
			return 0;
		}
		int count = 0;
		for(int i=0 ; i<grid.length ; i++) {
			for(int j=0 ; j<grid[i].length ; j++) {
				if(grid[i][j]=='1') {
//					System.out.println(i+", "+j);
					count++;
					dfs(grid,i,j);
				}
			}
		}
		return count;
	}
	////////////////////////////////////////////////////////////	
	private void dfs_search(char[][] grid,int row, int col) {
		int m = grid.length;
		int n = grid[0].length;
//					     惑, 窍, 谅, 快
		int[] dRow = {-1, 1, 0, 0};
		int[] dCol = { 0, 0,-1, 1};
		grid[row][col] = 'x';
		for(int i=0 ; i<dRow.length ; i++) {
			int nRow = row + dRow[i];
			int nCol = col + dCol[i];
			if(nRow<0 || nRow>=m || nCol<0 || nCol>=n || grid[nRow][nCol]!='1')
				continue ;
//			print(grid);
			dfs_search(grid,nRow,nCol);
		}
	}
	public int numsIslands(char[][] grid) {
		int ret = 0;
		Queue<Integer> q = new LinkedList<>();
		for(int i=0 ; i<grid.length ; i++) {
			for(int j=0 ; j<grid[i].length ; j++) {
				if(grid[i][j]=='1') {
					ret++;
					dfs_search(grid,i,j);
//					print(grid);
				}
			}
		}
		return ret;
	}
	static void print(char[][] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr[i].length ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

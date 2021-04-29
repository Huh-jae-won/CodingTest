package D_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q02_NumOfIsland_BFS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int row = 4;
		int col = 5;
		char[][] grid = new char[row][col];
		// 1: 级, 0 : 拱
		for(int i=0 ; i<row ; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		Q02_NumOfIsland_BFS q02 = new Q02_NumOfIsland_BFS();
		System.out.println("===reuslt===");
//		System.out.println(q02.numsIslands(grid));
		System.out.println(q02.solution(grid));
	}
	
	private void bfs(char[][] grid, int row, int col) {
//						       惑	      窍	    快		 谅    
		int[][] dirs = { {-1,0}, {1,0}, {0,1}, {0,-1} };
		int m = grid.length;
		int n = grid[0].length;	
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row,col});
		while(!q.isEmpty()) {
			int size = q.size();
			int[] point = q.poll();
			for(int i=0 ; i<size ; i++) {
				for(int[] dir : dirs) {
					int x = point[0] + dir[0];
					int y = point[1] + dir[1];
					if(x<0 || x>=m || y<0 || y>=n || grid[x][y]!='1')
						continue;
					q.offer(new int[] {x,y});
					grid[x][y] = 'x';
				}
			}
		}
		
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
					count++;
					bfs(grid, i, j);
				}
			}
		}
		return count;
	}
	////////////////////////// //////////////////////////////////
	private void bfs_search(char[][] grid,int row, int col) {
		Queue<Integer> q = new LinkedList<>();
		int m = grid.length;
		int n = grid[0].length;
		q.offer(row*10+col);
		while(!q.isEmpty()) {
			int num = q.poll();
			int i = num/10;
			int j = num%10;
			if(num<0 || i<0 || i>=m || j<0 || j>=n || grid[i][j]!='1')
				continue ;
			grid[i][j] = 'x';
			print(grid);
			q.offer((i-1)*10+j);
			q.offer((i+1)*10+j);
			q.offer(i*10+(j-1));
			q.offer(i*10+(j+1));
		}
		
	}
	public int numsIslands(char[][] grid) {
		int ret = 0;
		for(int i=0 ; i<grid.length ; i++) {
			for(int j=0 ; j<grid[i].length ; j++) {
				if(grid[i][j]=='1') {
					ret++;
					System.out.println(i+", "+j);
					bfs_search(grid,i,j);
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

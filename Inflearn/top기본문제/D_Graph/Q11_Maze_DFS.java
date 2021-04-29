package D_Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q11_Maze_DFS {
	public static void main(String[] args) {
		Q11_Maze_DFS q11 = new Q11_Maze_DFS();
		int[][] maze = {
				{0,0,1,0,0},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,1,0,1,1},
				{0,0,0,0,0}
		};
		int[] start = {0,4};
		int[] desti = {4,4};
//		System.out.println(q10.hasPath(maze, start, desti));
		System.out.println(q11.solution(maze, start, desti));
		}
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	int m,n;
	public boolean solution(int[][] maze, int[] start, int[] desti) { 
		if(maze==null || maze.length==0)
			return false;
		m = maze.length;
		n = maze[0].length;
		boolean[][] visited = new boolean[m][n];
		return dfs(maze,start,desti,visited);
	}
	private boolean dfs(int[][] maze, int[] start, int[] desti, boolean[][] visited) {
		if(start[0]<0 || start[0]>=m || start[1]<0 || start[1]>=n || visited[start[0]][start[1]])
			return false;
		if(Arrays.equals(start, desti))
			return true;
		
		visited[start[0]][start[1]] = true;
		
		for(int[] dir : dirs) {
			int nRow = start[0] + dir[0];
			int nCol = start[1] + dir[1];
//			벽까지 도달
			while(nRow>=0 && nRow<m && nCol>=0 && nCol<n && maze[nRow][nCol]==0) {
				nRow += dir[0];
				nCol += dir[1];
				// 한칸 더 이동하므로 밖에서 한번 빼줌
			}
			nRow -= dir[0];
			nCol -= dir[1];
			if(dfs(maze,new int[] {nRow,nCol},desti,visited)) {
				return true;
			}
		}
		
		return false;
	}
	
	//////////////////////////////////////////////////////////////////
	public boolean hasPath(int[][] maze, int[] start, int[] destination) { 
		boolean ret = false;
		if(maze==null || maze.length==0 || maze[0].length==0)
			return false;
		Set<int[]> visited = new HashSet<>();
		visited.add(start);
		ret = dfs(maze,visited,start,destination,0);
		
		return ret;
	}
	private boolean dfs(int[][] maze,Set<int[]> visited,int[] start, int[] desti,int dep) {
		boolean ret = false;
		String[] dir = {"up","left","down","right"};
		if(Arrays.equals(start, desti)) {
			System.out.println(dep);
			return true;
		}
		System.out.printf("[%d][%d]에서\n",start[0],start[1]);
		for(String str : dir) {
			if(isValid(maze,start[0],start[1],str)) {
				int[] moved = move(maze, str, start[0], start[1]);
				if(!isIn(visited,moved)) {
					visited.add(moved);
					ret = dfs(maze,visited,moved,desti,dep+1);
					if(ret)
						return ret;
					System.out.printf("back[%d][%d]에서\n",start[0],start[1]);
					printSet(visited);
					visited.remove(moved);
				}
			}
		}
		return false;
	}
	
	private boolean isIn(Set<int[]> visited, int[] arr) {
		for(int[] visit : visited) {
			int x = visit[0];
			int y = visit[1];
			if(x==arr[0] && y==arr[1]) 
				return true;
		}
		return false;
	}
	private boolean isValid(int[][] maze, int row, int col, String dir) {
		int nRow = row;
		int nCol = col;
		switch (dir) {
		case "up":
			nRow--;
			if(nRow>=0 && maze[nRow][nCol]!=1)
				return true;
			break;
		case "down":
			nRow++;
			if(nRow<maze.length && maze[nRow][nCol]!=1)
				return true;
			break;
		case "left":
			nCol--;
			if(nCol>=0 && maze[nRow][nCol]!=1)
				return true;
			break;
		case "right":
			nCol++;
			if(nCol<maze[0].length && maze[nRow][nCol]!=1)
				return true;
			break;
		default:
			break;
		}
		return false;
	}
	
	private int[] move(int[][] maze,String str,int row, int col) {
		int[] ret = new int[2];
		switch (str) {
		case "up":
			while(row>=0 && maze[row][col]==0) {
				row--;
			}
			ret[0] = row+1;
			ret[1] = col;
			System.out.printf("%5s : [%d][%d]\n",str,ret[0],ret[1]);
			break;
		case "down":
			while(row<maze.length && maze[row][col]==0) {
				row++;
			}
			ret[0] = row-1;
			ret[1] = col;
			System.out.printf("%5s : [%d][%d]\n",str,ret[0],ret[1]);
			break;
		case "left":
			while(col>=0 && maze[row][col]==0) {
				col--;
			}
			ret[0] = row;
			ret[1] = col+1;
			System.out.printf("%5s : [%d][%d]\n",str,ret[0],ret[1]);
			break;
		case "right":
			while(col<maze[0].length && maze[row][col]==0) {
				col++;
			}
			ret[0] = row;
			ret[1] = col-1;
			System.out.printf("%5s : [%d][%d]\n",str,ret[0],ret[1]);
			break;
		default:
			break;
		}
		
		return ret;
	}
	
	static void printSet(Set<int[]> visited) {
		for(int[] arr : visited) {
			System.out.printf("(%d,%d) ",arr[0],arr[1]);
		}
		System.out.println();
	}
	static void print(int[][] maze) {
		for(int i=0 ; i<maze.length ; i++) {
			for(int j=0 ; j<maze[i].length ; j++) {
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

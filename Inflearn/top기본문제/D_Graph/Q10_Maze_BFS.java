package D_Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q10_Maze_BFS {
	public static void main(String[] args) {
		Q10_Maze_BFS q10 = new Q10_Maze_BFS();
		int[][] maze = {
				{0,0,1,0,0},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,1,0,1,1},
				{0,0,0,0,0}
		};
		int[] start = {0,4};
		int[] desti = {4,4};
		print(maze);
//		System.out.println(q10.hasPath(maze, start, desti));
		System.out.println(q10.solution(maze, start, desti));
		}
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	int m,n;
	public boolean solution(int[][] maze, int[] start, int[] desti) { 
		m = maze.length;
		n = maze[0].length;
		if(Arrays.equals(start, desti))
			return true;
		boolean[][] visited = new boolean[m][n];
		visited[start[0]][start[1]] = true;
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start[0],start[1]});
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			for(int[] dir : dirs) {
				int nRow = pos[0] + dir[0];
				int nCol = pos[1] + dir[1];
//				벽까지 도달
				while(nRow>=0 && nRow<m && nCol>=0 && nCol<n && maze[nRow][nCol]==0) {
					nRow += dir[0];
					nCol += dir[1];
					// 한칸 더 이동하므로 밖에서 한번 빼줌
				}
				nRow -= dir[0];
				nCol -= dir[1];
				
				if(visited[nRow][nCol])
					continue;
				visited[nRow][nCol] = true;
				if(nRow==desti[0] && nCol==desti[1])
					return true;
				
				q.offer(new int[] {nRow,nCol});
			}
		}
		
		return false;
	}
	////////////////////////////////////////////////////////////////
	public boolean hasPath(int[][] maze, int[] start, int[] destination) { 
		if(maze==null || maze.length==0 || maze[0].length==0)
			return false;
		return(bfs(maze,start,destination));
	}
	private boolean bfs(int[][] maze, int[] start, int[] desti) {
		Queue<int[]> q = new LinkedList<>();
		Queue<String> strQ = new LinkedList<>();
		String[] dir = {"up","left","down","right"};

		q.offer(start);
		strQ.add("");
		int count = 1;
		while(!q.isEmpty()) {
			System.out.printf("==========%d==========\n",count++);
			int size = q.size();
			for(int i=0 ; i<size ; i++) {
				int[] pos = q.poll();
				String befMoved = strQ.poll();
				for(int k=0 ; k<4 ; k++) {
					if(befMoved.equals(dir[k]))
						befMoved = dir[(k+2)%4];
				}
				System.out.printf("[%d][%d]에서 이전 : %s\n",pos[0],pos[1],befMoved);
				for(String str : dir) {
					if(!befMoved.equals(str) && isValid(maze, pos[0], pos[1], str)) {
						int[] moved = move(maze,str,pos[0],pos[1]);
						// 이동한 위치에 대해서 
						if(Arrays.equals(moved, desti)) {
							return true;
						}
						q.offer(moved);
						strQ.add(str);
					}
				}
			}
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
			System.out.printf("%s : [%d][%d]\n",str,ret[0],ret[1]);
			break;
		case "down":
			while(row<maze.length && maze[row][col]==0) {
				row++;
			}
			ret[0] = row-1;
			ret[1] = col;
			System.out.printf("%s : [%d][%d]\n",str,ret[0],ret[1]);
			break;
		case "left":
			while(col>=0 && maze[row][col]==0) {
				col--;
			}
			ret[0] = row;
			ret[1] = col+1;
			System.out.printf("%s : [%d][%d]\n",str,ret[0],ret[1]);
			break;
		case "right":
			while(col<maze[0].length && maze[row][col]==0) {
				col++;
			}
			ret[0] = row;
			ret[1] = col-1;
			System.out.printf("%s : [%d][%d]\n",str,ret[0],ret[1]);
			break;
		default:
			break;
		}
		
		return ret;
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

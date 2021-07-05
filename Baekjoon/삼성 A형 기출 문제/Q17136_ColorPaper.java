import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q17136_ColorPaper {
	public static void main(String[] args) throws IOException {
		Q17136_ColorPaper z = new Q17136_ColorPaper();
		z.solution();
	}
	int[][] map;
	int ret = 0;
	List<int[]> list;
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ret = Integer.MAX_VALUE;
		int[] paper = new int[6];
		list = new ArrayList<>();
		Arrays.fill(paper, 5);
		boolean[][] visited = new boolean[10][10];
		map = new int[10][10];
		for(int i=0 ; i<10 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<10 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					list.add(new int[] {i,j});
				}
			}
		}
		dfs(0, visited, paper, 0);
		if(ret<Integer.MAX_VALUE) {
			System.out.println(ret);
		}else {
			System.out.println(-1);
		}
	}
	/*
	 	// 반례!
		1 1 0 1 1 0 0 0 0 0
		1 1 1 1 1 0 0 0 0 0
		1 1 1 1 1 1 0 0 0 0
		1 1 1 1 1 1 0 0 0 0
		1 1 1 1 1 1 0 0 0 0
		1 1 1 1 1 1 0 0 0 0
		0 0 0 0 0 0 0 0 0 0
		0 0 0 0 0 0 0 0 0 0
		0 0 0 0 0 0 0 0 0 0
		0 0 0 0 0 0 0 0 0 0
	 */
	private void dfs(int dep,boolean[][] visited,int[] paper, int curIdx) {
		if(allPass(visited)) {
//			System.out.println(Arrays.toString(paper));
			ret = Math.min(ret, dep);
			return;
		}
		if(curIdx>=list.size()) {
			return;
		}
		int row = list.get(curIdx)[0];
		int col = list.get(curIdx)[1];
		int[] pos = {row,col};
		if(map[row][col]==1 && !visited[row][col]) {
			for(int x = 5 ; x>0 ; x--) {
				if(Arrays.equals(pos, new int[] {-1,-1})) {
					break;
				}
				if(chkOne_and_True(visited, pos, x)) {
//					System.out.println(Arrays.toString(pos)+", "+x);
					if(countPaper(paper, x)) {
						// 종이 사용 가능
						visit(visited, pos, x, true);
//						paper[x]--;
						dfs(dep+1,visited,paper,curIdx+1);
						paper[x]++;
						visit(visited, pos, x, false);
					}else {
						continue;
					}
				}
			}
		}else {
			dfs(dep, visited, paper, curIdx+1);
		}
		
	}
	
	private boolean allPass(boolean[][] visited) {
		for(int i=0 ; i<10 ; i++) {
			for(int j=0 ; j<10 ; j++) {
				if(map[i][j]==1) {
					if(!visited[i][j]) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private void visit(boolean[][] visited, int[] pos, int len,boolean b) {
		int row = pos[0];
		int col = pos[1];
		for(int i=row ; i<row+len ; i++) {
			for(int j=col ; j<col+len ; j++) {
				visited[i][j] = b;
			}
		}
	}
	
	private int[] nextPos(int[] befo) {
		int[] nPos = new int[2];
		int row = befo[0];
		int col = befo[1];
		if(col<9) {
			nPos[0] = row;
			nPos[1] = col+1;
		}else if(row<9){
			nPos[0] = row+1;
			nPos[1] = 0;
		}else {
			nPos[0] = -1;
			nPos[1] = -1;
		}
		return nPos;
	}
	
	private boolean chkOne_and_True(boolean[][] visited, int[] pos, int len) {
		if(!inRange(pos,len)) {
			return false;
		}
		int row = pos[0];
		int col = pos[1];
		for(int i=row ; i<row+len ; i++) {
			for(int j=col ; j<col+len ; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					continue;
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean countPaper(int[] paper, int len) {
		if(paper[len]>0) {
			paper[len]--;
			return true;
		}
		return false;
	}
	private boolean inRange(int[] pos, int len) {
		int row = pos[0];
		int col = pos[1];
		if(row+len<=10 && col+len<=10)
			return true;
		return false;
	}
}

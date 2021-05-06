package 모의TEST문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q01949_Trail {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01949_Trail a = new Q01949_Trail();
		a.solution();
	}
	int N = 0;
	int K = 0;
	int longestTrail = 0;
	List<String> list;
	int[][] dirs = {
			{-1,0},{0,-1},
			{1,0}, {0,1} };	// 상 좌 하 우
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			List<Integer> maxPos = new ArrayList<>();
			int max = 0;
			longestTrail = 0;
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			boolean[][] visited;
			for(int i=0 ; i<N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(max<map[i][j]) {
						maxPos.clear();
						maxPos.add(10*i+j);
						max = map[i][j];
					}else if(max==map[i][j]) {
						maxPos.add(10*i+j);
					}
				}
			}
			
//			System.out.println(max+" : "+maxPos);
			
			for(int i=0 ; i<maxPos.size() ; i++) {
				visited = new boolean[N][N];
				int pos = maxPos.get(i);
				visited[pos/10][pos%10] = true;
				dfs(map,visited,pos,true,1,"["+pos+"]"+max);
			}
			bw.write("#"+tc+" "+longestTrail+"\n");
			bw.flush();
//			printList(list);
		}
		bw.close();
		br.close();
	}
	private void dfs(int[][] map,boolean[][] visited ,int pos,boolean canDig ,int dep, String str) {
//		longestTrail = Math.max(longestTrail, dep);
		if(longestTrail<dep) {
			longestTrail = dep;
			list.clear();
			list.add(str);
		}else if(longestTrail==dep) {
			list.add(str);
		}
		int row = pos/10;
		int col = pos%10;
		int height = map[row][col];
//		int cnt = 0;
//		for(int i=0 ; i<4 ; i++) {
//			int nRow = row + dirs[i][0];
//			int nCol = col + dirs[i][1];
//		}
		if(canDig) {
			for(int i=0 ; i<4 ; i++) {
				int nRow = row + dirs[i][0];
				int nCol = col + dirs[i][1];
				// 1. 팔수있지만 안 파는경우
				if(inRange(nRow,nCol) && !visited[nRow][nCol] && map[nRow][nCol]<height){
					visited[nRow][nCol] = true;
					dfs(map,visited,nRow*10+nCol,true,dep+1,str+"->"+"["+(10*nRow+nCol)+"]"+map[nRow][nCol]);
					visited[nRow][nCol] = false;
				}
			}
			// 2. 다음칸을 파는 경우
			for(int i=0 ; i<4 ; i++) {
				int nRow = row + dirs[i][0];
				int nCol = col + dirs[i][1];
				if(inRange(nRow,nCol) && !visited[nRow][nCol] && map[nRow][nCol]>=height){
					int nHeight = map[nRow][nCol];
					for(int j=1 ; j<=K ; j++) {
						if(nHeight-j<height) {
							map[nRow][nCol] = nHeight-j;
							visited[nRow][nCol] = true;
							dfs(map,visited,nRow*10+nCol,false,dep+1,str+"->"+"*"+(10*nRow+nCol)+"*"+map[nRow][nCol]+j);
							map[nRow][nCol] = nHeight;
							visited[nRow][nCol] = false;
						}
					}
				}
			}
		}else {
			// 이미 판경우
			for(int i=0 ; i<4 ; i++) {
				int nRow = row + dirs[i][0];
				int nCol = col + dirs[i][1];
				if(inRange(nRow,nCol) && !visited[nRow][nCol] && map[nRow][nCol]<height){
					visited[nRow][nCol] = true;
					dfs(map,visited,nRow*10+nCol,false,dep+1,str+"->"+"["+(10*nRow+nCol)+"]"+map[nRow][nCol]);
					visited[nRow][nCol] = false;
				}
			}
		}
	}
	
	private boolean inRange(int row,int col) {
		if(row>=0 && row<N && col>=0 && col<N)
			return true;
		return false;
	}
	
	private void printList(List<String> list) {
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
	}
	
	private void printArr(int[][] map) {
		int N = map.length;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}

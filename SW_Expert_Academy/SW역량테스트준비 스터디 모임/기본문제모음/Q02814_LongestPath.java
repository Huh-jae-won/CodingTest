package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q02814_LongestPath {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q02814_LongestPath a = new Q02814_LongestPath();
		a.solution();
	}
	int ret = 0;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			ret = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[N+1];
			List<int[]> line = new ArrayList<>();
			for(int i=0 ; i<M ; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				if(v1>v2) {
					int temp = v1;
					v1 = v2;
					v2 = temp;
				}
				line.add(new int[] {v1,v2});
			}
			boolean[] lineVisited = new boolean[line.size()];
			line.sort(comp);
//			printLine(line);
			for(int i=1 ; i<=N ; i++) {
				dfs(visited,lineVisited,line,0,i);
			}
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	private void dfs(boolean[] visited, boolean[] lineVisited, List<int[]> line, int dep, int now) {
		visited[now] = true;
		ret = Math.max(ret, dep+1);
		for(int i=0 ; i<line.size() ; i++) {
			if(lineVisited[i])
				continue;
			int[] edge = line.get(i);
			int next = canGo(visited,edge,now);
			if(next!=-1){
				lineVisited[i] = true;
				dfs(visited,lineVisited,line,dep+1,next);
				lineVisited[i] = false;
			}
		}
		visited[now] = false;
		return ;
	}
	private int canGo(boolean[] visited, int[] edge, int now ) {
		if(edge[0]!=now&&edge[1]!=now)
			return -1;
		int next;
		if(edge[0]==now) {
			next = edge[1];
		}else {
			next = edge[0];
		}
		if(visited[next])
			return -1;
		return next;
	}
	
	Comparator<int[]> comp = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[0]!=o2[0]) {
				return o1[0]-o2[0];
			}
			return o1[1]-o2[1];
		}
	};
	private void printLine(List<int[]> line) {
		for(int[] arr : line) {
			System.out.print("["+arr[0]+", "+arr[1]+"] ");
		}
		System.out.println();
	}
}

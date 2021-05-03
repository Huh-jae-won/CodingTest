package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q02806_Queen {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q02806_Queen a = new Q02806_Queen();
		a.solution();
	}

	int ret = 0;

	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			ret = 0;
			int N = Integer.parseInt(br.readLine());
			int[] visited = new int[N];
			for (int i = 0; i < N; i++) {
				visited[i] = -1;
			}
			dfs(visited, N, 0, "");
			bw.write("#" + tc + " " + ret + "\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}

	private void dfs(int[] visited, int N, int dep, String str) {
		if (dep == N) {
//			System.out.println(str);
//			printArr(visited);
			ret++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] == -1 && chk(visited,i,dep)) {
				visited[i] = dep;
				dfs(visited, N, dep + 1, str+i);
				visited[i] = -1;
			}
		}
	}

	private boolean chk(int[] visited, int loc,int dep) {
		int len = visited.length;
//		int num = visited[loc];
		for(int i=0 ; i<len ; i++) {
			if(visited[i]!=-1) {
				int range = Math.abs(i-loc);
				int depRange = Math.abs(dep-visited[i]);
				if(range==depRange)
					return false;
			}
		}
		return true;
	}

	private void printArr(int[] visited) {
		int len = visited.length;
		int[][] arr = new int[len][len];
		for (int i=0; i<len; i++) {
			arr[visited[i]][i] = 1;
		}

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}

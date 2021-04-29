package DFS_base;

import java.util.Scanner;

public class Q15649 {
	static int N = 0;
	static int M = 0;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N+1];
		dfs(0,"");
	}
	static void dfs(int dep,String ans) {
		if(dep==M) {
			System.out.println(ans);
			return;
		}else {
			for(int i=1 ; i<=N ; i++) {
				if(!visited[i]) {
					visited[i] = true;
					dfs(dep+1,ans+Integer.toString(i)+" ");
					visited[i] = false;
				}
			}
		}
	}
}

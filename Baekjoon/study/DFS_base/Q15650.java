package DFS_base;

import java.util.Scanner;

public class Q15650 {
	static int N = 0;
	static int M = 0;
	static boolean[] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		flag = new boolean[N+1];
		dfs(0,"",0);
	}
	static void dfs(int dep,String ans,int bef) {
		if(dep == M) {
			System.out.println(ans);
			return;
		}else {
			for(int i=1 ; i<=N ; i++) {
				if(flag[i]==false && i>bef) {
					flag[i] = true;
					dfs(dep+1,ans+Integer.toString(i)+" ",i);
					flag[i] = false;
				}
			}
		}
	}
}

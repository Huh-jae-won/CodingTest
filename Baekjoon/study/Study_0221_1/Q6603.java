package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6603 {
	static int K;
	static int[] S;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K==0)
				break;
			S = new int[K];
			visited = new boolean[K];
			for(int i=0 ; i<K ; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0,"");
			System.out.println();
		}
	}
	
	static void dfs(int bef,int dep,String str) {
		if(dep==6) {
			System.out.println(str);
		}else {
			for(int i=bef ; i<K ; i++) {
				if(!visited[i]) {
					visited[i] = true;
					dfs(i,dep+1,str+S[i]+" ");
					visited[i] = false;
				}
			}
		}
	}

}

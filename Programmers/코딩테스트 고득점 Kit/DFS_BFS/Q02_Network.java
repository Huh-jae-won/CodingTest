package DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q02_Network {

	public static void main(String[] args) {
		Q02_Network a = new Q02_Network();
		
		int n = 3;
		int[][] computers = {
				{1, 1, 0}, 
				{1, 1, 0}, 
				{0, 0, 1}	
		};
//		int[][] computers = {
//				{1, 1, 0}, 
//				{1, 1, 1}, 
//				{0, 1, 1}	
//		};
		System.out.println(a.network(n, computers));
		System.out.println(a.solution(n, computers));
	}
	public int solution(int n, int[][] computers) {
		 int answer = 0;
	        boolean[] chk = new boolean[n];
	        for(int i = 0; i < n; i++) {
	            if(!chk[i]) {
	                dfs(computers, chk, i);
	                answer++;
	            }
	        }
	        return answer;
	}
	private void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[start][i] == 1 && !chk[i]) {
                dfs(computers, chk, i);
            }
        }
    }
	/////////////////////////////////////////////////////
	public int network(int n, int[][] computers) {
		int ret = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
//			System.out.println(i);
			if(list.contains(i)) {
//				System.out.println("skip");
				continue;
			}
			list.addAll(bfs(i,computers));
			ret++;
		}
		return ret;
	}
	private List<Integer> bfs(int start, int[][] computers){
		List<Integer> ret = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		int len = computers.length;
		boolean[] visited = new boolean[len];
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty()) {
//			System.out.println(q);
			int num = q.poll();
			for(int i=0 ; i<len ; i++){
				if(i==num || visited[i])
					continue;
				if(computers[num][i]==1) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		for(int i=0 ; i<len ; i++) {
			if(visited[i])
				ret.add(i);
		}
//		System.out.println("ret : "+ret);
		return ret;
	}
}

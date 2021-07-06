import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17471_Gerrymandering {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q17471_Gerrymandering z = new Q17471_Gerrymandering();
		z.solution();
	}
	int N = 0;
	int ret = 0;
	int[][] map;
	int[] population;
	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ret = Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		population = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<=N ; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			for(int j=0 ; j<len ; j++) {
				int city = Integer.parseInt(st.nextToken());
				map[i][city] = 1;
				map[city][i] = 1;
			}
		}
		boolean[] visited = new boolean[N+1];
		////////////////////////////////
		for(int i=1 ; i<=N/2 ; i++) {
			dfs(i,0,visited,0);
		}
		if(ret!=Integer.MAX_VALUE) {
			System.out.println(ret);
		}else {
			System.out.println(-1);
		}
		
	}
	private void dfs(int len, int dep,boolean[] visited,int befo) {
		if(dep==len) {
			List<Integer> region1 = new ArrayList<>();
			List<Integer> region2 = new ArrayList<>();
			for(int i=1 ; i<visited.length ; i++) {
				if(visited[i]) {
					region1.add(i);
				}else {
					region2.add(i);
				}
			}
//			System.out.println(region1+", "+region2);
			if(canGo(region1) && canGo(region2)) {
				int sum1 = getPopulation(region1);
				int sum2 = getPopulation(region2);
				int comp = Math.abs(sum1-sum2);
				ret = Math.min(comp, ret);
			}
			return;
		}
		for(int i=befo+1 ; i<visited.length ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(len,dep+1,visited,i);
				visited[i] = false;
			}
		}
	}
	
	private boolean canGo(List<Integer> region) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(region.get(0));
		while(!q.isEmpty()) {
			int city = q.poll();
			if(region.contains(city) && !visited[city]) {
				visited[city] = true;
				for(int j=1 ; j<=N ; j++) {
					if(map[city][j]==1) {
						q.offer(j);
					}
				}
			}
		}
		for(int city : region) {
			if(!visited[city])
				return false;
		}
		return true;
	}
	
	private int getPopulation(List<Integer> region) {
		int sum = 0;
		for(int city : region) {
			sum += population[city];
		}
		return sum;
	}
	
	private void printMap() {
		for(int i=1 ; i<map.length ; i++) {
			for(int j=1 ; j<map[0].length ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}

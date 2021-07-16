import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889_StartAndLink {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q14889_StartAndLink z = new Q14889_StartAndLink();
		z.solution();
	}
	int N = 0;
	int[][] map;
	int ret = 0;
	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ret = Integer.MAX_VALUE;
		map = new int[N][N];
		
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[] visited = new boolean[N];
		dfs(0, visited, -1);
		System.out.println(ret);
	}
	
	
	private void dfs(int dep,boolean[] visited,int befo) {
		if(dep==N/2) {
			ret = Math.min(ret, getSynergy(visited));
			return;
		}
		for(int i=befo+1 ; i<N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(dep+1, visited, i);
				visited[i] = false;
			}
				
		}
	}
	private int getSynergy(boolean[] visited){
//		String T="";
//		String F="";
//		for(int i=0 ; i<visited.length ; i++) {
//			if(visited[i]) {
//				T+=(i+1);
//			}else {
//				F+=(i+1);
//			}
//		}
		int teamT = 0;
		int teamF = 0;
		for(int i=0 ; i<N-1 ; i++) {
			for(int j=i+1 ; j<N ; j++) {
				if(visited[i] && visited[j]==true) {
					teamT += map[i][j];
					teamT += map[j][i];
				}else if(visited[i]==false && visited[j]==false) {
					teamF += map[i][j];
					teamF += map[j][i];
				}else {
				}
			}
		}
		int ret = Math.abs(teamF-teamT);
//		System.out.printf("(%s : %3d), (%s : %3d) -> %d\n",T,teamT,F,teamF,ret);
		return ret;
	}
}

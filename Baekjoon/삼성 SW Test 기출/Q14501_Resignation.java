import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14501_Resignation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q14501_Resignation z = new Q14501_Resignation();
		z.solution();
	}
	int N = 0;
	int[][] counsel;
	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		counsel = new int[N+1][2];
		boolean[] visited = new boolean[N+1];
		StringTokenizer st;
		for(int i=1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			counsel[i][0] = Integer.parseInt(st.nextToken());
			counsel[i][1] = Integer.parseInt(st.nextToken());
			int wait = counsel[i][0];
			if(wait+i>N+1) {
				counsel[i][0] = 0;
				counsel[i][1] = 0;
			}
		}
		dp();
	}
	
	private int dp() {
		int[] dp = new int[N+1];
		int ret = Integer.MIN_VALUE;
		for(int i=1 ; i<=N ; i++) {
			int next = counsel[i][0];
			if(next+i<=N+1) {
				dp[i] = Math.max((dp[i-1]-counsel[i-1][1]),dp[i]);
				dp[i] += counsel[i][1];
				if(i+next<=N)
					dp[i+next] = Math.max(dp[i],dp[i+next]);
			}
		}
		for(int i=0 ; i<=N ; i++) {
			if(dp[i]>ret)
				ret = dp[i];
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(ret);
		return ret;
	}
	
	private void printArr(int[][] arr) {
		for(int[] temp : arr) {
			if(Arrays.equals(temp,new int[] {0,0}))
				continue;
			System.out.println(Arrays.toString(temp));
		}
	}
}

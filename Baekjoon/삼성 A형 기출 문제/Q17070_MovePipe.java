import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Q17070_MovePipe {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q17070_MovePipe z= new Q17070_MovePipe();
		z.solution();
	}
	int N = 0;
	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		int[][][] ret = new int[N+1][N+1][3]; 
		for(int i=1 ; i<N+1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1 ; j<N+1 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
				}
			}
		}
		ret[1][2][0] = 1;
		// ret[i][j][0,1,2] : 0:가로, 1:세로, 2:대각
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=N ; j++) {
				if((i==1 && j==1) || (i==1&&j==2))
					continue;
				if(map[i][j]==1)
					continue;
				ret[i][j][0] += ret[i][j-1][0];
				ret[i][j][0] += ret[i][j-1][2];
				
				ret[i][j][1] += ret[i-1][j][1];
				ret[i][j][1] += ret[i-1][j][2];
				if(canMove(map,i,j)) {
					ret[i][j][2] += ret[i-1][j-1][2];
					ret[i][j][2] += ret[i-1][j-1][1];
					ret[i][j][2] += ret[i-1][j-1][0];
				}
			}
		}
		
		System.out.println(ret[N][N][0]+ret[N][N][1]+ret[N][N][2]);
	}
	private boolean canMove(int[][]map, int row, int col) {
		for(int i=row-1 ; i<=row ; i++) {
			for(int j=col-1 ; j<=col ; j++) {
				if(map[i][j]==1)
					return false;
			}
		}
		return true;
	}
}

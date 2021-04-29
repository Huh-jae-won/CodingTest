package DFS_BFS_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.plaf.SliderUI;

public class Q17281 {
	static int N;
	static int[] batter_order;
	static int[][] inning;
	static int[] base;
	static int score;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		batter_order = new int[10];
		batter_order[1] = 4;
		
		inning = new int[N+1][10];
		base = new int[4];
		result = -1;
		
		for(int i=1 ; i<N+1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1 ; j<10 ; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] flag = new boolean[10];
		dfs(flag,0);
		System.out.println(result);
	}
	static void play() {
		int bef_batting_order = 0;	// 타순이 0번째
		int out = 0;
		for(int inn=1 ; inn<=N ; inn++) {
			while(out<3) {
				int batter = find_next_batter(bef_batting_order);	// batter : 타자의 등번호
				out = batting(inn, batter, out);
				bef_batting_order = (bef_batting_order+1)%9;
			}
			for(int i=1 ; i<4 ; i++) {
				base[i] = 0;
			}
			out = 0;
		}
		
	}
	
	static int batting(int inn, int batter,int out) {
		int outt;
		outt = base_running(inning[inn][batter],out);
		return outt;

	}
	static int base_running(int hit,int out) {
		if(hit==0) {
			out++;
		}else {
			for(int i=3 ; i>0 ; i--) {
				if(base[i]!=0) {
					if(i+hit<4) {
						base[i+hit] = 1;
						base[i] = 0;
					}
					else {
						base[i] = 0;
						score++;
					}
				}
			}
			if(hit<4) {
				base[hit] = 1;
			}else {
				score++;
			}
		}
		return out;
	}
	
	static int find_next_batter(int bef_batter) {
		if(bef_batter==9)
			bef_batter = 0;
		for(int i=1 ; i<10 ; i++) {
			if( batter_order[i]==bef_batter+1 )
				return i;
		}
		return 0;
	}
	
	static void dfs(boolean[] flag,int dep) {
		if(dep==9) {
//			print_arr(batter_order, dep);
			play();
			result = Math.max(result, score);
			score = 0;
			return ;
		}else if(dep==0){
			batter_order[dep+1] = 4;
			flag[4] = true;
			dfs(flag,dep+1);
		}else {
			for(int i=1 ; i<10 ; i++) {
				if(!flag[i]) {
					flag[i] = true;
					batter_order[dep+1] = i; 
					dfs(flag,dep+1);
					flag[i] = false;
				}
			}
		}
	}
	
	static String order_tostring() {
		String str = "";
		for(int i=1 ; i<10 ; i++) {
			str += Integer.toString(batter_order[i]);
		}
		return str;
	}
	
	static void print_arr(int[] arr,int num) {
		for(int i=1 ; i<=num ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//실패
public class Q14500 {
	static int N;
	static int M;
	static int[][] map;
	static String[] type23 = {"111100", "001111", "100111", "111001", "011110", "110011", "010111", "111010"};
	static String[] type32 = {"101011", "110101", "111010", "010111", "101101", "011110", "101110", "011101"};
	static String[][] type;
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for(int i=0 ; i<N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<M ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			type = new String[5][8];
			type[0] = type23;
			type[1] = type32;
			type[2][0] = "1111";
			type[3][0] = "1111";
			type[4][0] = "1111";
			int result = 0; 
			result = max_type();
			System.out.println(result);
	}
	
	static int max_num(int k, int row, int col, int x, int y) {
		int max_num = 0;
		int indx=0;
		int last;
		if(x*y==6)
			last = 8;	// 8가지 방법
		else
			last = 1;	// 1가지 방법
		while(indx<last) {
			int sum = 0;
			int cnt = 0;
			for(int i=row ; i<row+x ; i++) {
				for(int j=col ; j<col+y ; j++) {
					sum += map[i][j] * Integer.parseInt(type[k][indx].charAt(cnt)+"");
					cnt++;
				}
			}
			max_num = Math.max(max_num, sum);
			indx++;
		}
		return max_num;
	}
	
	static int max_type() {
		ArrayList<Integer> list = new ArrayList();
		// (2,3), (3,2), (1,4), (4,1), (2,2)
		int[] shape = {23, 32, 14, 41, 22}; 
		
		for(int k=0 ; k<5 ; k++) {
			int x = shape[k] / 10;
			int y = shape[k] % 10;
			for(int i=0 ; i<N+1-x ; i++) {
				for(int j=0 ; j<M+1-y ; j++) {
					int num = max_num(k,i,j,x,y);
					if(!list.contains(num))
						list.add(num);
				}
			}
		}
		list.sort(null);
//		System.out.println(list);
		return list.get(list.size()-1);
	}
}

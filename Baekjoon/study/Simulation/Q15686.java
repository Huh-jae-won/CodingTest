package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15686 {
	// 실패
	static int N;
	static int M;
	static int[][] map;
	static ArrayList<Integer> house_list;
	static ArrayList<Integer> store_list;
	static boolean[] flag;
	static int result;
	
	public static void main(String[] args) throws IOException {
//		System.out.println("시간초과");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house_list = new ArrayList<Integer>();
		store_list = new ArrayList<Integer>();
		map = new int[N][N];
		result = 100;
		
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num==1)
					house_list.add(10*i+j);
				else if(num==2)
					store_list.add(10*i+j);
			}
		}
		flag = new boolean[store_list.size()];
		dfs(0,0);
		System.out.println(result);
		
	}

	static void dfs(int dep,int bef) {
		if(dep == M) {
			int length;
			 length = find_length();
			 result = Math.min(result, length);
		}else {
			for(int i=bef ; i<store_list.size() ; i++) {
				if(!flag[i]) {
					flag[i] = true;
					dfs(dep+1,i);
					flag[i] = false;
				}
			}
		}
	}
	static int find_length() {
		int size = house_list.size();
		int sum = 0;
		for(int i=0 ; i<size ; i++) {
			int x = house_list.get(i)/10;
			int y = house_list.get(i)%10;
			sum += chic_distance(x, y);
		}
		return sum;
	}
	
	static int chic_distance(int row, int col) {
		// (row,col) : house 좌표
		int min_dist = Integer.MAX_VALUE;
		for(int i=0 ; i<store_list.size() ; i++) {
			if(flag[i]) {
				int x_store = store_list.get(i)/10;
				int y_store = store_list.get(i)%10;
				int length = Math.abs(row-x_store)+Math.abs(col-y_store);
				min_dist = Math.min(min_dist, length);
			}
		}
		return min_dist;
	}
}

package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12100 {
	static int cnt=0;
	static int max;
	static int N;
	static Block[][] map;
	// »óÇÏÁÂ¿ì
	static String[] direction = {"up","down","left","right"};
	static int[] visited;
	
	static class Block{
		int row;
		int col;
		int num;
		boolean flag = true;
		Block(int row,int col, int num){
			this.row = row;
			this.col = col;
			this.num = num;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new Block[N][N];
		Block[][] temp = new Block[N][N];
		
		visited = new int[4];
		max = Integer.MIN_VALUE;
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				String a = st.nextToken();
				map[i][j] = new Block(i,j,Integer.parseInt(a));
				temp[i][j] = new Block(i,j,Integer.parseInt(a));
			}
		}
		
		dfs(0,temp,"");
		System.out.println(max);
		
	}
	static void copy_arr(Block[][] src, Block[][] desti) {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				desti[i][j].row = src[i][j].row;
				desti[i][j].col = src[i][j].col;
				desti[i][j].num = src[i][j].num;
				desti[i][j].flag = src[i][j].flag;
			}
		}
	}
	static int find_Max(Block[][] temp) {
		int max_value = Integer.MIN_VALUE;
		for(int i=0 ; i<N ; i++){
			for(int j=0 ; j<N ; j++) {
				max_value =Math.max(max_value, temp[i][j].num); 
			}
		}
		return max_value;
	}
	static void dfs(int dep,Block[][] temp,String str) {
		if(dep==5) {
			copy_arr(map,temp);
//			System.out.println(++cnt+" : "+str);
//			if(cnt==780) {
//				System.out.println("DEBUGGING");
//			}
			StringTokenizer st2 = new StringTokenizer(str," ");
			for(int i=0 ; i<5 ; i++) {
				move(st2.nextToken(),temp);
			}
			max = Math.max(max, find_Max(temp));
		}else {
			for(int i=0 ; i<4 ; i++) {
				if(visited[i]<4) {
					visited[i]++;
					dfs(dep+1,temp,str+direction[i]+" ");
					visited[i]--;
				}
			}
		}
	}
	
	static void flag_change(boolean bool,Block[][] temp) {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				temp[i][j].flag = bool;
			}
		}
	}
	static boolean move(String str,Block[][] temp) {
		boolean ret = true;
		switch (str) {
		case "up":
			while(ret) {
				ret = move_up(temp);
			}
			break;
		case "down":
			while(ret) {
				ret = move_down(temp);
			}
			break;
		case "left" :
			while(ret) {
				ret = move_left(temp);
			}
			break;
		case "right" :
			while(ret) {
				ret = move_right(temp);
			}
			break;
		default:
			System.out.println("default");
			break;
				
		}
		flag_change(true,temp);
		
//		System.out.println(str);
//		for(int i=0 ; i<N ; i++) {
//			for(int j=0 ; j<N ; j++) {
//				System.out.printf("%2d ",temp[i][j].num);
//			}
//			System.out.println();
//		}
		
		return ret;
	}
	
	static boolean move_up(Block[][] temp) {
		boolean ret = false;
		for(int j=0 ; j<N ; j++) {
			for(int i=1 ; i<N ; i++) {
				if(temp[i-1][j].num==0 && temp[i][j].num!=0) {
					ret = true;
					temp[i-1][j].num = temp[i-1][j].num + temp[i][j].num;
					temp[i][j].num = 0;
				}
				else if( temp[i][j].num!=0 && temp[i-1][j].num==temp[i][j].num && temp[i-1][j].flag && temp[i][j].flag ) {
					ret = true;
					temp[i-1][j].num = temp[i-1][j].num + temp[i][j].num;
					temp[i-1][j].flag = false;
					temp[i][j].num = 0;
				}
			}
		}
		return ret;
	}
	static boolean move_down(Block[][] temp) {
		boolean ret = false;
		for(int j=0 ; j<N ; j++) {
			for(int i=N-2 ; i>-1 ; i--) {
				if( temp[i+1][j].num==0 && temp[i][j].num!=0) {
					ret = true;
					temp[i+1][j].num = temp[i+1][j].num + temp[i][j].num;
					temp[i][j].num = 0;
				}
				else if(temp[i][j].num!=0 && temp[i+1][j].num==temp[i][j].num && temp[i+1][j].flag && temp[i][j].flag) {
					ret = true;
					temp[i+1][j].num = temp[i+1][j].num + temp[i][j].num;
					temp[i+1][j].flag = false;
					temp[i][j].num = 0;
				}
			}
		}
		return ret;
	}
	static boolean move_left(Block[][] temp) {
		boolean ret = false;
		for(int i=0 ; i<N ; i++) {
			for(int j=1 ; j<N ; j++) {
				if( temp[i][j-1].num==0 && temp[i][j].num!=0) {
					ret = true;
					temp[i][j-1].num = temp[i][j-1].num + temp[i][j].num;
					temp[i][j].num = 0;
				}
				else if(temp[i][j].num!=0 && temp[i][j-1].num==temp[i][j].num && temp[i][j-1].flag && temp[i][j].flag) {
					ret = true;
					temp[i][j-1].num = temp[i][j-1].num + temp[i][j].num;
					temp[i][j-1].flag = false;
					temp[i][j].num = 0;
				}
			}
		}
		return ret;
	}
	static boolean move_right(Block[][] temp) {
		Boolean ret = false;
		for(int i=0 ; i<N ; i++) {
			for(int j=N-2 ; j>-1 ; j--) {
				if( temp[i][j+1].num==0 && temp[i][j].num!=0 ) {
					ret = true;
					temp[i][j+1].num = temp[i][j+1].num + temp[i][j].num;
					temp[i][j].num = 0;
				}
				else if(temp[i][j].num!=0 && temp[i][j+1].num==temp[i][j].num && temp[i][j+1].flag && temp[i][j].flag) {
					ret = true;
					temp[i][j+1].num = temp[i][j+1].num + temp[i][j].num;
					temp[i][j+1].flag = false;
					temp[i][j].num = 0;
				}
			}
		}
		return ret;
	}

}

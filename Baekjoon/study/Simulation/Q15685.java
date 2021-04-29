package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15685 {
	static int N;
	static ArrayList<Integer>[] x_list;
	static ArrayList<Integer>[] y_list;
	static ArrayList<Integer> x_point;
	static ArrayList<Integer> y_point;
	static int[] gen;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		x_list = new ArrayList[N];
		y_list = new ArrayList[N];
		x_point = new ArrayList();
		y_point = new ArrayList();
		
		gen = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			x_list[i] = new ArrayList<Integer>();
			y_list[i] = new ArrayList<Integer>();
			
			x_list[i].add(Integer.parseInt(st.nextToken()));
			y_list[i].add(Integer.parseInt(st.nextToken()));
			int direction = Integer.parseInt(st.nextToken());
			gen[i] = Integer.parseInt(st.nextToken());
			switch (direction) {
			case 0:
				x_list[i].add(x_list[i].get(0)+1);
				y_list[i].add(y_list[i].get(0));
				break;
			case 1:
				x_list[i].add(x_list[i].get(0));
				y_list[i].add(y_list[i].get(0)-1);
				break;
			case 2:
				x_list[i].add(x_list[i].get(0)-1);
				y_list[i].add(y_list[i].get(0));
				break;
			case 3:
				x_list[i].add(x_list[i].get(0));
				y_list[i].add(y_list[i].get(0)+1);
				break;
			default:
				System.out.println("ERROR");
				break;
			}
		}
		for(int i=0 ; i<N ; i++) {
			rotate(i,gen[i]);
		}
		
		for(int i=0 ; i<N ; i++) {
			x_point.addAll(x_list[i]);
			y_point.addAll(y_list[i]);
		}
//		System.out.println(x_point+", "+x_point.size());
//		System.out.println(y_point+", "+y_point.size());
		remove_duplicate();
		
		int result = 0;
		for(int i=0 ; i<x_point.size(); i++) {
			int x = x_point.get(i);
			int y = y_point.get(i);
			result += find_square(x, y);
		}
		System.out.println(result);
		
	}
	
	static void remove_duplicate() {
		int size = x_point.size();
		int[] indx = new int[size];
		for(int i=0 ; i<size-1; i++) {
			int x = x_point.get(i);
			int y = y_point.get(i);
			for(int j=i+1 ; j<size ; j++) {
				if(x==x_point.get(j) && y==y_point.get(j)) {
					indx[j] = 1;
				}
			}
		}
		for(int i=size-1 ; i>-1 ; i--) {
			if(indx[i]==1) {
				x_point.remove(i);
				y_point.remove(i);
			}
		}
//		System.out.println(x_point);
//		System.out.println(y_point);
	}
	
	static int find_square(int x, int y) {
//		[0]:우, [1]:하, [2]:우하 
		int[] square = new int[3];
		for(int i=0 ; i<x_point.size(); i++) {
			if(x_point.get(i)==x+1 && y_point.get(i)==y)
				square[0] = 1;
			if(x_point.get(i)==x && y_point.get(i)==y+1)
				square[1] = 1;
			if(x_point.get(i)==x+1 && y_point.get(i)==y+1)
				square[2] = 1;
		}
		int result = square[0]*square[1]*square[2];
		return result;
	}
	
	static void rotate(int i,int gen) {
		for(int k=0 ; k<gen ; k++) {
			int pivot_x = x_list[i].get(x_list[i].size()-1);
			int pivot_y = y_list[i].get(y_list[i].size()-1);
			
			for(int j=x_list[i].size()-2 ; j>-1 ; j--) {
				int bef_x = x_list[i].get(j) - pivot_x;
				int bef_y = y_list[i].get(j) - pivot_y;
				
				int rotate_x = -bef_y + pivot_x;
				int rotate_y =  bef_x + pivot_y;
				
				x_list[i].add(rotate_x);
				y_list[i].add(rotate_y);
			}
		}
	}

}

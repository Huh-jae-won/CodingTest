package DFS_BFS_searching;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2667 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		int cnt = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		String[][] town = new String[N][N];
		for(int i=0 ; i<N ; i++) {
			String temp = sc.nextLine();
			for(int j=0 ; j<N ; j++) {
				town[i][j] = temp.substring(j,j+1);
			}
		}

		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(town[i][j].equals("1")) {					
					if(near(town,i,j,Integer.toString(cnt)+Integer.toString(cnt))) {
						cnt++;
					}
				}
			}
		}
		for(int i=1 ; i<cnt ; i++) {
			list.add(count_arr(town, Integer.toString(i)+Integer.toString(i)));
		}
		list.sort(null);
		// 정답출력
		System.out.println(cnt-1);
		for(int i=1 ; i<cnt ; i++) {
			System.out.println(list.get(i-1));
		}
	}
	static boolean near(String[][] arr,int i, int j,String num) {
		if(i>=0 && i<N && j>=0 && j<N) {			
			if(arr[i][j].equals("1")) {
				arr[i][j]=num;
				near(arr,i-1,j,num);	// 상
				near(arr,i+1,j,num);	// 하
				near(arr,i,j-1,num);	// 좌
				near(arr,i,j+1,num);	// 우
			}
			return true;
		}
		return false;
	}
	static int count_arr(String[][] arr, String num) {
		int count = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(arr[i][j].equals(num))
					count++;
			}
		}
		return count;
	}
}

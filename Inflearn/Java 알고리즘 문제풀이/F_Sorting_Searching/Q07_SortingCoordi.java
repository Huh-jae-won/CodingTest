package F_Sorting_Searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q07_SortingCoordi {
	public static void main(String[] args){
		Q07_SortingCoordi a = new Q07_SortingCoordi();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0 ; i<N ; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		a.solution(arr);
	}
	public void solution(int[][] arr) {
		Arrays.sort(arr,comp);
		for(int[] a : arr) {
			System.out.println(a[0]+" "+a[1]);
		}
	}
	Comparator<int[]> comp = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[0]!=o2[0]) {
				return o1[0]-o2[0];
			}
			return o1[1]-o2[1];
		}
	};
}

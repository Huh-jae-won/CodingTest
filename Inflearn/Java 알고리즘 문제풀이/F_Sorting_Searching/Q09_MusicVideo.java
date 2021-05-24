package F_Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Q09_MusicVideo {
	public static void main(String[] args) {
		Q09_MusicVideo a = new Q09_MusicVideo();
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int sum = 0;
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int start = sum/M;
		a.solution(arr, M);
	}
	public void solution(int[] arr, int M) {
		System.out.println(Arrays.toString(arr));
		int[] dvd = new int[M];
		
		int N = arr.length;
		boolean[] visited = new boolean[N];
		int len = startLen(arr, M);
		while(true) {
			int start = 0;
			for(int idx=0 ; idx<3 ; idx++) {
				int partSum = 0;
				for(int i=start ; i<N ; i++) {
					if(partSum+arr[i]>len) {
						// i번은 포함 x
						dvd[idx] = partSum;
						start = i;
						partSum = 0;
						break;
					}else {
						partSum += arr[i];
						visited[i] = true;
					}
				}
				if(partSum!=0) {
					dvd[idx] = partSum;
					partSum = 0;
				}
			}
			if(allVisit(visited)) {
				break;
			}else {
				System.out.println("len : "+len);
				System.out.print(Arrays.toString(dvd)+" ");
				for(int i=0 ; i<N ; i++) {
					if(!visited[i]) {
						System.out.print(arr[i]+" ");
					}
				}
				System.out.println();
				System.out.println();
				makeFalse(visited);
				clearDVD(dvd);
				len++;
			}
		}
		System.out.println("len : "+len);
		System.out.println(Arrays.toString(dvd));
	}
	private void makeFalse(boolean[] visited) {
		for(int i=0 ; i<visited.length ; i++) {
			visited[i] = false;
		}
	}
	
	private boolean allVisit(boolean[] visited) {
		for(boolean b : visited) {
			if(!b) {
				return false;
			}
		}
		return true;
	}
	private int startLen(int[] arr,int M) {
		int start = 0;
		for(int i=0 ; i<arr.length; i++)
			start += arr[i];
		return start/M;
	}
	private void clearDVD(int[] dvd) {
		for(int i=0 ; i<3 ; i++) {
			dvd[i] = 0;
		}
	}
}

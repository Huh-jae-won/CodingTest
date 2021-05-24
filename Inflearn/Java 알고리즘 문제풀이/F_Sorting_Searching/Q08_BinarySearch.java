package F_Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Q08_BinarySearch {
	public static void main(String[] args) {
		Q08_BinarySearch a = new Q08_BinarySearch();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		a.solution(arr, M);
	}
	public void solution(int[] arr, int M) {
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		int n = arr.length;
		int start = 0;
		int end = n-1;
		int mid = (end+start)/2;;
		int ret = 0;
		while(start<=end) {
//			System.out.printf("%d, %d, %d\n",start,mid,end);
			int midNum = arr[mid];
			if(M>midNum) {
				start = mid+1;
			}else if(M<midNum){
				end = mid-1;
			}else {
				ret = mid+1;
				break;
			}
			mid = (end+start)/2;
		}
		System.out.println(ret);
	}
}

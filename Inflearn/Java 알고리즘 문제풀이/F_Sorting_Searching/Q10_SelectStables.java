package F_Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q10_SelectStables {
	static int N = 0;
	static int C = 0;
	public static void main(String[] args) throws IOException {
		Q10_SelectStables a = new Q10_SelectStables();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 마굿간 수
		C = Integer.parseInt(st.nextToken());	// 말 마릿수
		int[] arr = new int[N];	// 마굿간 위치
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		a.solution(arr);
//		System.out.println(Arrays.toString(arr));
	}
	public void solution(int[] arr) {
		int ret = 0;
		int start = 1;
		int end = arr[N-1];
		while(start<=end) {
			int mid = (start+end)/2;
			if(count(arr, mid)) {
				ret = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		System.out.println(ret);
	}
	private boolean count(int[] arr, int dist) {
		int cnt = 1;
		int num = arr[0];
		for(int i=1 ; i<N ; i++) {
			if(arr[i]-num>=dist) {
				cnt++;
				num = arr[i];
			}
			if(cnt>=C)
				return true;
		}
		return false;
	}
}

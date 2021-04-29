package BinarySearch;

import java.util.Arrays;

public class Q01_Immigration {
	public static void main(String[] args) {
		Q01_Immigration a = new Q01_Immigration();
		
		int n = 6;
		int[] times = {7,10};
		System.out.println(a.solution(n, times));
		
	}
	public long solution(int n, int[] times) {
		Arrays.sort(times);
		long end = (long)times[times.length-1]*(long)n;
		long start = 1;
		long mid;
		int len = times.length;
		long ret = 0;
		while(start<end) {
			long people = 0;
			mid = (start+end)/2;
			System.out.printf("(L:%d,M:%d,R:%d)\n",start,mid,end);
			for(int t : times) {
				people += mid/t;
			}
			if(people>=n) {
				ret = mid;
				end = mid;
			}else {
				start = mid+1;	//왜 start에 +1은 되고 end에 -1은 시간초과지??
			}
		}
		return ret;
	}
}

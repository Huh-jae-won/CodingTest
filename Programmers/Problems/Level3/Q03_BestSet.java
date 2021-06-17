package Level3;

import java.util.Arrays;

public class Q03_BestSet {
	public static void main(String[] args) {
		Q03_BestSet z = new Q03_BestSet();
		int n = 2;
		int s = 9;
		int[] ret = z.solution(n, s);
		System.out.println(Arrays.toString(ret));
	}
    public int[] solution(int n, int s) {
        int[] arr = new int[n];
        if(n>s){
            return new int[]{-1};
        }else if(n==s){
            Arrays.fill(arr,1);
            return arr;
        }
        int mod = s/n;
        int rem = s%n;
        Arrays.fill(arr,mod);
        for(int i=n-1 ; rem+i>=n ; i--){
            arr[i]++;
        }
        return arr;
    }
}

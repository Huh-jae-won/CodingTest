package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q04_LineUp {
	public static void main(String[] args) {
		Q04_LineUp z = new Q04_LineUp();
		int n = 5;
		long k = 10;
		int[] ret = z.solution(n, k);
		System.out.println(Arrays.toString(ret));
	}
    public int[] solution(int n, long k) {
        long[] fact  = new long[n+1];
        int[] ret;
        List<String> list = new ArrayList<>();
        factorial(fact,n);
        // System.out.println(Arrays.toString(fact));
        ret = does(fact,n,k);
        return ret;
    }
    private int[] does(long[] fact, int n, long k){
        boolean[] visited = new boolean[n+1];
        int[] ret = new int[n];
        List<Integer> list = new ArrayList<>();
        visited[0] = true;
        
        while(n>0){
            long range = fact[n]/n; // 한구간 크기
            int idx = inRange(k,n,range);
            int boo = chkBoolean(idx,visited);
            list.add(boo);
            k -= (idx-1) * fact[n]/n;
            // System.out.printf("n%d : range:%d, idx:%d, k:%d, ",n,range,idx,k);
            // System.out.println(list+", "+Arrays.toString(visited));
            n--;
        }
        for(int i=0 ; i<list.size() ; i++){
            ret[i] = list.get(i);
        }
        return ret;
        
    }
    private int chkBoolean(int idx,boolean[] visited){
        int cnt = 0;
        for(int i=1 ; i<visited.length ; i++){
            if(!visited[i])
                cnt++;
            if(cnt==idx){
                visited[i] = true;
                return i;
            }
        }
        return 0;
    }
    private int inRange(long k, int n, long range){
        int idx = 1;
        for(int i=1 ; i<= n ; i++){
            if(k>(i-1)*range && k<=i*range){
                return i;
            }
        }
        return n;
    }
    private void factorial(long[] fact, int n){
        fact[0] = 1L;
        for(int i=1 ; i<=n ; i++){
            fact[i] = fact[i-1]*i;
        }
    }
}

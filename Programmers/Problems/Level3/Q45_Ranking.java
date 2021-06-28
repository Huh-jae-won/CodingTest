package Level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q45_Ranking {
	public static void main(String[] args) {
		Q45_Ranking z = new Q45_Ranking();
		int n= 5;
		int[][] results = {
				{4,3},
				{4,2},
				{3,2},
				{1,2},
				{2,5}
		};
		int ret = z.solution(n, results);
		System.out.println(ret);
	}
    public int solution(int n, int[][] results) {
        int[][] fight = new int[n+1][n+1];
        int ret = 0;
        for(int i=1 ; i<=n ; i++){
            List<Integer> list = order(n,results,i);
            makeFight(fight,list);
        }
        // printArr(fight);
        
        for(int[] arr : fight){
            int cnt = 0;
            for(int i=1 ; i<arr.length ; i++){
                if(arr[i]==0)
                    cnt++;
            }
            if(cnt==1)
                ret++;
        }
        return ret;
    }
    private void makeFight(int[][] fight, List<Integer> list){
        int idx = list.get(0);
        int ret = 0;
        for(int i=1 ; i<list.size() ; i++){
            int oppo = list.get(i);
            fight[idx][oppo] = 1;
            fight[oppo][idx] = -1;
        }
    }
    private List<Integer> order(int n, int[][] results, int idx){
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        while(!q.isEmpty()){
            int num = q.poll();
            if(list.contains(num))
                continue;
            list.add(num);
            for(int[] arr : results){
                if(arr[0]==num){
                    q.offer(arr[1]);
                }
            }
        }
        // System.out.println(list);
        return list;
    }
    private void printArr(int[][] arr){
        for(int i=1 ; i<arr.length ; i++){
            for(int j=1 ; j<arr.length ; j++){
                System.out.printf("%2d ",arr[i][j]);
            }
            System.out.println();
        }
    }
}

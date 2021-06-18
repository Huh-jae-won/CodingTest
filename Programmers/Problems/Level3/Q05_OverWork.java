package Level3;

import java.util.PriorityQueue;

public class Q05_OverWork {
	public static void main(String[] args) {
		Q05_OverWork z = new Q05_OverWork();
		int[] works = {4,3,3};
		int n = 4;
		long ret = z.solution(n, works);
		System.out.println(ret);
	}
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int work : works){
            pq.offer(work);
        }
        for(int i=1 ; i<=n ; i++){
            int work = 1;
            int remain = pq.poll();
            if(remain>0){
                pq.offer(remain-1);
            }else{
                pq.offer(remain);
            }
        }
        long answer = 0;
        for(int work : pq){
            answer += Math.pow(work,2);
        }
        return answer;
    }
}

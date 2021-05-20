package Level2;

import java.util.PriorityQueue;

public class Spicier {
	public static void main(String[] args) {
		Spicier a = new Spicier();
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		int ret = a.solution(scoville, K);
		System.out.println(ret);
	}
    public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((q1,q2)->q1-q2);
		for(int i=0 ; i<scoville.length ; i++) {
			pq.offer(scoville[i]);
		}
		int ret = 0;
		while(pq.size()>=2) {
			if(pq.peek()>=K)
				break;
			int dish1 = pq.poll();
			int dish2 = pq.poll();
			int newDish = dish1+dish2*2;
			pq.offer(newDish);
			ret++;
		}
		// System.out.println(pq);
		// System.out.println(ret);
		if(pq.peek()>=K) {
			return ret;
		}else {
			return -1;
		}
    }
}

package Heap;

import java.util.PriorityQueue;

public class Q01_Spicy {
	public static void main(String[] args) {
//		int[] scoville = {1, 2, 3, 9, 10, 12};
		int[] scoville = {1,3};
		int K = 7;
		Q01_Spicy a = new Q01_Spicy();
		a.moreSpicy(scoville, K);
	}
	public int moreSpicy(int[] scoville, int K) {
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
		System.out.println(pq);
		System.out.println(ret);
		if(pq.peek()>=K) {
			return ret;
		}else {
			return -1;
		}
	}
}

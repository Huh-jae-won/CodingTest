package D_HashMap_TreeSet;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Q05_KthBiggest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		PriorityQueue<Integer> q = new PriorityQueue<>(comp);
		for(int i=0 ; i<N-2 ; i++) {
			for(int j=i+1 ; j<N-1 ; j++) {
				for(int k=j+1 ; k<N ; k++) {
					int num = arr[i]+arr[j]+arr[k];
					if(!q.contains(num)) {
						if(q.size()>K-1) {	// q사이즈가 K 넘어갈때
							if(num>q.peek()) {
								q.poll();
								q.offer(num);
							}
						}else {
							q.offer(num);
						}
					}
				}
			}
		}
		if(q.size()<K) {
			System.out.println(-1);
		}else
			System.out.println(q.poll());
	}
	static Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1-o2;
		}
	};
	
}

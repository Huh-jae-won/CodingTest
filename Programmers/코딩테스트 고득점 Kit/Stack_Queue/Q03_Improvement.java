package Stack_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q03_Improvement {

	public static void main(String[] args) {
		Q03_Improvement a = new Q03_Improvement();
//		int[] progress = {93,30,55};
//		int[] speed = {1,30,5};
		
		int[] progress = {95, 90, 99, 99, 80, 99};
		int[] speed = {1, 1, 1, 1, 1, 1};
		System.out.println(a.improve(progress, speed));
	}
	public int[] improve(int[] progress, int[] speed) {
		List<Integer> list = new ArrayList<>();
		Queue<Integer> proQ = new LinkedList<>();
		Queue<Integer> spdQ = new LinkedList<>();
		int len = progress.length;
		for(int i=0 ; i<len ; i++) {
			proQ.offer(progress[i]);
			spdQ.offer(speed[i]);
		}
		while(!proQ.isEmpty()) {
			int size = proQ.size();
			for(int i=0 ; i<size ; i++) {
				int num = proQ.poll();
				int spd = spdQ.poll();
				if(num<100) {
					proQ.offer(num+spd);
					spdQ.offer(spd);
				}else {
					proQ.offer(num);
					spdQ.offer(spd);
				}
			}
			// ÆÇ´Ü
			int count = 0;
//			System.out.println(proQ);
			while(!proQ.isEmpty() && proQ.peek()>=100) {
				count++;
				proQ.poll();
				spdQ.poll();
			}
			if(count!=0)
				list.add(count);
		}
		int[] ret = new int[list.size()];
		for(int i=0 ; i<ret.length ; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}	
	
	static void print(int[] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q03_dupPriorityQueue {
	public static void main(String[] args) {
		Q03_dupPriorityQueue a = new Q03_dupPriorityQueue();
		
//		String[] operations = {"I 7","I 5","I -5","D -1"};
//		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};`
		String[] operations = {"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"};
//		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		int[] ret = a.dupPriority(operations);
		System.out.println(ret[0]+", "+ret[1]);
	}
	public int[] dupPriority(String[] operations) {
		PriorityQueue<Integer> maxPq = new PriorityQueue<>((s1,s2)->s2-s1);
		PriorityQueue<Integer> minPq = new PriorityQueue<>((s1,s2)->s1-s2);
		int len = operations.length;
		for(int i=0 ; i<len ; i++) {
			System.out.println("====="+i+"=====");
			doOperation(operations[i], maxPq, minPq);
			System.out.println("max : "+maxPq);
			System.out.println("min : "+minPq);
		}
		int[] ret = new int[2];
		if(maxPq.isEmpty() || minPq.isEmpty()) {
			ret[0] = 0;
			ret[1] = 0;
		}else {
			ret[0] = maxPq.poll();
			ret[1] = minPq.poll();
		}
		return ret;
	}
	private void doOperation(String ope,PriorityQueue<Integer> maxPq,PriorityQueue<Integer> minPq) {
		StringTokenizer st = new StringTokenizer(ope);
		if(st.nextToken().equals("I")) {
			int num = Integer.parseInt(st.nextToken());
			System.out.println("추가 : " + num);
			maxPq.offer(num);
			minPq.offer(num);
		}else {
			if(maxPq.isEmpty() || minPq.isEmpty()) {
				return;
			}
			if(st.nextToken().equals("1")) {
				int num = maxPq.poll();
				minPq.remove(num);
				System.out.println("max삭제 : "+num);
			}else {
				int num = minPq.poll();
				maxPq.remove(num);
				System.out.println("min삭제 : "+num);
			}
		}
	}
}

package Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q01_KthNum {

	public static void main(String[] args) {
		Q01_KthNum a = new Q01_KthNum();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
				{2, 5, 3},
				{4, 4, 1},
				{1, 7, 3}
		};
		int[] ret = a.Kth(array, commands);
		System.out.printf("%d,%d,%d",ret[0],ret[1],ret[2]);
	}
//		Arrays.copyOfRange(original, from, to)
	public int[] Kth(int[] array, int[][] commands) {
		int len = commands.length;
		int[] ret = new int[len];
		for(int x=0 ; x<len ; x++) {
			int i = commands[x][0];
			int j = commands[x][1];
			int k = commands[x][2];
			PriorityQueue<Integer> pq = new PriorityQueue<>((s1,s2)->s1-s2);
			for(int m=i-1 ; m<j ; m++) {
				pq.add(array[m]);
			}
			for(int m=0 ; m<k ; m++) {
				ret[x] = pq.poll();
			}
		}
		return ret;
	}
	static void print(PriorityQueue<Integer> pq) {
		while(!pq.isEmpty()) {
			System.out.print(pq.poll()+" ");
		}
		System.out.println();
	}

}

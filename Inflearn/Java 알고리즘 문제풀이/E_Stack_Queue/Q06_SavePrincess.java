package E_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q06_SavePrincess {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for(int i=1 ; i<=N ; i++) {
			q.add(i);
		}
		int k = 1;
		while(q.size()!=1) {
			int num = q.poll();
			if(k==K) {
				k = 1;
				continue;
			}
			k++;
			q.offer(num);
		}
		System.out.println(q.poll());
	}
}

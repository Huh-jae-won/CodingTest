package E_Stack_Queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q08_Emergency {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int curIdx = M;
		Queue<Integer> q = new LinkedList<>();
		for(int i=0 ; i<N ; i++) {
			q.offer(sc.nextInt());
		}
		while(!q.isEmpty()) {
			int risk = q.poll();
			if(!chkRisk(q, risk)) {
				// 다시 넣어야함
				q.offer(risk);
				if(curIdx==0) {
					curIdx = q.size();
				}
			}else {
				// 빼야함
				if(curIdx==0) {
					System.out.println(N-q.size());
					break;
				}
			}
			curIdx--;
		}
	}
	static boolean chkRisk(Queue<Integer> q,int risk) {
		for(int n : q) {
			if(risk<n)
				return false;
		}
		return true;	// 본인 보다 큰 리스크 없음
	}
}

package Study_0221_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q12851 {
	static int N;
	static int K;
	static Queue<Node> q;
	static boolean[] visited;
	
	static class Node{
		int pos;
		int time;
		Node(int pos, int time){
			this.pos = pos;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 수빈 : N-1 or N+1 or 2N로 이동
		K = sc.nextInt();	// 동생
		q = new LinkedList();
		visited = new boolean[100001];
		
		q.add(new Node(N,0));
		bfs();
	}
	
	static void bfs() {
		Node temp = null;
		int cnt = 0;
		int minTime = Integer.MAX_VALUE;
		while(q.isEmpty()==false) {
			temp = q.poll();	// 하나 꺼내옴
//			if(temp.past.equals("5 4 8 16 17 ")) {
//				System.out.println("debugging");
//			}
			if(temp.pos == K) {
				minTime = Math.min(minTime, temp.time);
				if(minTime != temp.time) {
					break;
				}
//				System.out.println(temp.past);
				cnt++;
			}
			visited[temp.pos] = true;
			
			
			for(int i=0 ; i<3 ; i++) {
				int nx = move(i,temp.pos);	// temp에서 다음 위치 반환
				if( nx>=0 && nx<=100000 && !visited[nx] ) {
					if(minTime >= temp.time) {
						q.add(new Node(nx,temp.time+1));
					}
				}
			}
		}
		System.out.println(minTime);
		System.out.println(cnt);
	}
	
	static int move(int indx, int value) {
		switch(indx) {
		case 0 :
			return value+1;
		case 1 :
			return value-1;
		case 2 :
			return 2*value;
		}
		return -1;
	}

}

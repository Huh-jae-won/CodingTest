package Step16_DP1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N08_Q1463 {
	static int N;
	static int result;
	static boolean[] visited;
	static Queue<Node> q;
	static class Node{
		int num;
		int cnt;
		Node(int num, int cnt){
			this.cnt = cnt;
			this.num = num;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		result = Integer.MAX_VALUE;
		visited = new boolean[N+1];
		q = new LinkedList();
		q.add(new Node(1,0));
		if(N==1) {
			System.out.println(0);
		}else {
			bfs();
		}
	}
	static void bfs() {
		while(!q.isEmpty()) {
			Node temp = null;
			temp = q.poll();
			if(temp.num == N) {
				if(temp.cnt<result) {
					result = temp.cnt;
					System.out.println(result);
					break;
				}
			}else {
				if(temp.num>N || visited[temp.num]) {
					continue;
				}
				visited[temp.num] = true; 
				int num = temp.num;
				int nCnt = temp.cnt+1;
				q.add(new Node(num+1,nCnt));
				q.add(new Node(num*2,nCnt));
				q.add(new Node(num*3,nCnt));
			}
			
		}
	}
}

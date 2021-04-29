package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11403 {
	
	static class Node{
		int pos;
		int[] desti;
		Node(int pos,int[] desti){
			this.pos = pos;
			this.desti = desti;
		}
	}
	static int N;
	static Queue<Node> q;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		q = new LinkedList();
		Node[] node_arr = new Node[N];
		
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			node_arr[i] = new Node(i,arr);
			for(int j=0 ; j<N ; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp==1) {
					node_arr[i].desti[j] = 1;
				}
			}
		}
		
		for(int i=0 ; i<N ; i++) {
			bfs(node_arr,i);
		}
		
	}
	static void bfs(Node[] node_arr,int indx) {
		boolean[] visited = new boolean[N];
		int cnt = 0;
		q.add(node_arr[indx]);
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(visited[temp.pos]) {
				// 도착한적 있는 곳
				continue;
			}
			if(cnt!=0) {
				visited[temp.pos] = true;
			}
			cnt++;
			for(int i=0 ; i<N ; i++) {
				int dest = temp.desti[i];
				if(dest == 1) {
					q.add(node_arr[i]);
				}
			}
		}
		for(int i=0 ; i<N ; i++) {
			if(visited[i]) {
				System.out.print(1+" ");
			}else {
				System.out.print(0+" ");
			}
		}
		System.out.println();
	}
}

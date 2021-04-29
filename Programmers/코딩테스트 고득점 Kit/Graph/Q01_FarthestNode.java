package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q01_FarthestNode {
	public static void main(String[] args) {
		Q01_FarthestNode a = new Q01_FarthestNode();
		
		int n = 6;
		int[][] edge = {
				{3,6}, {4,3}, {3,2},
				{1,3}, {1,2}, {2,4}, {5,2}
		};
		System.out.println(a.findNode(n, edge));
	}
	public int findNode(int n, int[][] edge) {
		int ret = 0;
//		1로 부터의 거리 ex) distance[3] = 3과 1사이 거리
		int[] distance = new int[n+1];	
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		int dist = 0;
		while(!q.isEmpty()) {
			int size = q.size();
//			System.out.println(q);
			for(int x=0 ; x<size ; x++) {
				int befNode = q.poll();
				visited[befNode] = true;
				distance[befNode] = dist;
				for(int i=0 ; i<edge.length ; i++) {
					int nextNode = chkNode(befNode,edge[i]);
					if(nextNode!=-1 && !visited[nextNode]) {
						visited[nextNode] = true;
						q.add(nextNode);
					}
				}
			}
//			printArr(distance);
			dist++;
		}
		int maxDist = maxDist(distance);
		for(int num : distance) {
			if(num==maxDist)
				ret++;
		}
		return ret;
	}
	private int maxDist(int[] dist) {
		int max = Integer.MIN_VALUE;
		for(int i=0 ; i<dist.length ; i++) {
			if(max<dist[i]) {
				max = dist[i];
			}
		}
		return max;
	}
	
	private int chkNode(int befNode, int[] node) {
		if(node[0]==befNode) {
			return node[1];
		}else if(node[1]==befNode) {
			return node[0];
		}else
			return -1;
	}
	
	static void printArr(int[] arr) {
		System.out.print("dist : ");
		for(int i=1 ; i<arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

package G_DFS_BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q01_FindCalf {
	public static void main(String[] args) {
		Q01_FindCalf aa = new Q01_FindCalf();
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();	// 현수 시작 위치
		int E = sc.nextInt();	// 송아지 위치
//		aa.solution(S, E);
		aa.sol2(S, E);
	}
	class Node{
		int pos;
		int cnt;
		public Node(int pos, int cnt) {
			this.pos = pos;
			this.cnt = cnt;
		}
	}
	public void sol2(int S, int E) {
		int ret = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(S,0));
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0 ; i<size ; i++) {
				Node node = q.poll();
				if(node.pos<S || node.pos>E+10)
					continue;
				if(node.pos!=E) {
					q.add(new Node(node.pos+1,node.cnt+1));
					q.add(new Node(node.pos-1,node.cnt+1));
					q.add(new Node(node.pos+5,node.cnt+1));
				}else {
					ret = node.cnt;
					break;
				}
			}
			if(ret!=0) {
				System.out.println(ret);
				break;
			}
		}
	}
	
	public void solution(int S, int E) {
		if(E-S<5) {
			System.out.println(E-S);
			return;
		}
		int[] idx = new int[E+6];
		int[] arr = new int[E+6];
		for(int i=0 ; i<idx.length ; i++) {
			idx[i] = i;
		}
		for(int i=S+5 ; i<arr.length ; i+=5) {
			arr[i] = arr[i-5]+1;
		}
		arr[S] = 0;
		arr[S+1] = 1;
		arr[S+2] = 2;
		arr[S+3] = 3;
		arr[S+4] = 2;
		
		for(int i=S+5 ; i<=E ; i+=5) {
			arr[i] = arr[i-5]+1;
			arr[i+1] = arr[i]+1;
			arr[i+2] = arr[i+1]+1;
			arr[i+3] = arr[i+2]+1;
			arr[i+4] = arr[i+5]+1;		
		}
//		printArr(idx,S);
//		printArr(arr,S);
		System.out.println(arr[E]);
	}
	private void printArr(int[] arr,int S) {
		for(int i=S ; i<arr.length ; i++) {
			System.out.printf("%2d ",arr[i]);
		}
		System.out.println();
	}
}

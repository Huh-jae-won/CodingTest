package Step10_Math2;

import java.util.Scanner;

public class N03_Q1929 {
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		visited = new boolean[N+1];
		for(int i=M ; i<=N ; i++) {
			visited[i] = true;
		}
		visited[1] = false;
		
		for(int i=M ; i<=N ; i++) {
			if(visited[i]) {
				if(findNum(i)) {
					System.out.println(i);
				}
				eraseNum(i,N);
			}
		}
	}
	static void eraseNum(int num,int N) {
		int dx = 2;
		while(num*dx<=N) {
			visited[num*dx] = false;
			dx++;
		}
	}
	
	static boolean findNum(int num) {
		boolean flag = true;
		for(int i=2 ; i<=(int)Math.pow(num, 0.5) ;i++) {
			if(num%i==0) {
				flag = false;
				visited[num] = false;
				break;
			}
		}
		return flag;
	}

}

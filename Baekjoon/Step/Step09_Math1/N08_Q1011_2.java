package Step09_Math1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N08_Q1011_2 {
	static int x;
	static int y;
	static int time;
	static Queue<Node> q;
	
	static class Node{
		int loc;
		int befDist;
		int cnt;
		Node(int loc, int befDist, int cnt){
			this.befDist = befDist;
			this.cnt = cnt;
			this.loc = loc;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		
		for(int tc=1 ; tc<=testCase ; tc++) {
			x = sc.nextInt();
			y = sc.nextInt();
			sc.nextLine();
			q = new LinkedList();
			time = Integer.MAX_VALUE;
			int cnt = 0;
			int rootDist = (int)Math.pow(y-x,0.5);
			if(rootDist==Math.pow(y-x, 0.5)) {
				System.out.println(2*rootDist-1);
			}else {
				if(Math.round(Math.pow(y-x, 0.5))>rootDist) {
					System.out.println(2*rootDist+1);
				}else {
					System.out.println(2*rootDist);
			}
		}
	}

	}

}

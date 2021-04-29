package Step13_BruteForce;

import java.util.Scanner;

public class N05_Q1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		String temp = "665";
		int num = 665;
		while(cnt<N) {
			num++;
			temp = num+"";
			if(temp.contains("666")) {
				cnt++;
			}
		}
		System.out.println(temp);
	}

}

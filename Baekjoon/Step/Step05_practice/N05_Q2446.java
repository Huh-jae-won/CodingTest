package Step05_practice;

import java.util.Scanner;

public class N05_Q2446 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=N ; i>0 ; i--) {
			for(int j=N ; j>i ; j--) {
				System.out.print(" ");
			}
			for(int j=2*i-1 ; j>0 ; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=2 ; i<=N ; i++) {
			for(int j=i ; j<N ; j++) {
				System.out.print(" ");
			}
			for(int j=1 ; j<=2*i-1 ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

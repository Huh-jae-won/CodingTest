package Step05_practice;

import java.util.Scanner;

public class N06_Q10996 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N==1) {
			System.out.println("*");
		}else {
			for(int i=0 ; i<2*N ; i++) {
				for(int j=1 ; j<=N ; j++) {
					if((i+j)%2==1) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}

	}

}

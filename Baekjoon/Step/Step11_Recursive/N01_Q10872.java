package Step11_Recursive;

import java.util.Scanner;

public class N01_Q10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double factorial = 1;
		for(int i=1 ; i<=N ; i++) {
			factorial *= i;
		}
		System.out.printf("%.0f\n",factorial);
	}

}

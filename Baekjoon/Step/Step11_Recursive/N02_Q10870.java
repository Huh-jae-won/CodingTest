package Step11_Recursive;

import java.util.Scanner;

public class N02_Q10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a1 = 0;
		int a2 = 1;
		int Fibonacci = 1;
		if(N==0) {
			System.out.println(0);
			return;
		}
		
		for(int i=2 ; i<=N ; i++) {
			Fibonacci = a1+a2;
			a1 = a2;
			a2 = Fibonacci;
		}
		System.out.println(Fibonacci);
	}

}

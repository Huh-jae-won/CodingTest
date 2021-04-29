package Step05_practice;
import java.util.Scanner;
public class N04_Q2523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=1 ; i<=2*N-1 ; i++) {
			if(i<=N) {
				for(int j=0 ; j<i ; j++) {
					System.out.print("*");
				}
			}else {
				for(int j=2*N-1 ; j>=i ; j--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}

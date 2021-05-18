package A_String;

import java.util.Scanner;

public class Q04_ReverseString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0 ; i<=N ; i++) {
			String a = sc.nextLine();
			int len = a.length();
			for(int j=len-1 ; j>=0 ; j--) {
				System.out.print(a.substring(j,j+1));
			}
			System.out.println();
		}
	}
}

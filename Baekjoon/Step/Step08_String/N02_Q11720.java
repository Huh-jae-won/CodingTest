package Step08_String;

import java.util.Scanner;

public class N02_Q11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int sum = 0;
		
		String str = sc.nextLine().trim();
		int length = str.length();
		for(int i=0 ; i<length ; i++) {
			sum += Integer.parseInt(str.charAt(i)+"");
		}
		System.out.println(sum);
	}

}

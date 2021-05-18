package A_String;

import java.util.Scanner;

public class Q03_WordInString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arr = str.split(" ");
		int len = Integer.MIN_VALUE;
		String ret = null;
		for(int i=0 ; i<arr.length ; i++) {
			if(len<arr[i].length()) {
				len = arr[i].length();
				ret = arr[i];
			}
		}
		System.out.println(ret);
	}
}

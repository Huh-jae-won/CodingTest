package E_Stack_Queue;

import java.util.Scanner;

public class Q02_ReplaceString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String regex = "\\([A-Za-z]*\\)";
		while(true) {
			String temp = str.replaceAll(regex, "");
			System.out.println(temp);
			if(str.equals(temp))
				break;
			str = temp;
		}
		System.out.println(str);
	}
}

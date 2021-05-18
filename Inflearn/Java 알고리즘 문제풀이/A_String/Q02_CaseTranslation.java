package A_String;

import java.util.Scanner;

public class Q02_CaseTranslation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<str.length() ; i++) {
			char ch = str.charAt(i);
			if(ch>=97 && ch<=122) {
				sb.append((char)(ch-32));
			}else {
				sb.append((char)(ch+32));
			}
		}
		System.out.println(sb);
	}
}

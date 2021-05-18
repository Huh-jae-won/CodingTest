package A_String;

import java.util.Scanner;

public class Q01_FindCharacter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String ch = sc.next();
		int ret = 0;
		for(int i=0 ; i<str.length() ; i++) {
			if(ch.compareToIgnoreCase(str.substring(i,i+1))==0)
				ret++;
		}
		System.out.println(ret);
	}
	
}

package Step08_String;

import java.util.Scanner;

public class N03_Q10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine().trim();
		for(int i=97 ; i<=122 ; i++) {
			char temp = (char) i;
			int j;
			for(j=0; j<s.length() ; j++) {
				if(temp == s.charAt(j)) {
					System.out.print(j+" ");
					break;
				}
			}
			if(j==s.length())
				System.out.print("-1 ");
		}
//		System.out.println((int)'a');	//97
//		System.out.println((int)'z');	//122
	}

}

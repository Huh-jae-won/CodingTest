package Step08_String;

import java.util.Scanner;

public class N09_Q2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();
		String[] letter = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		int cnt = 0;
		boolean flag;
		
		for(int i=0 ; i<str.length() ; i++) {
			flag = false;
			for(int j=0 ; j<8 ; j++) {
				String temp = letter[j];
				int length = temp.length();
				if(i+length<=str.length() && temp.equals(str.substring(i, i+length))) {
					cnt++;
					i+=length-1;
					flag = true;
					break;
				}
			}
			if(!flag) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}

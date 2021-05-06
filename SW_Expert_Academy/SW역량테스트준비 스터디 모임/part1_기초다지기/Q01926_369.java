package part1_기초다지기;

import java.io.IOException;
import java.util.Scanner;

public class Q01926_369 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01926_369 a = new Q01926_369();
		a.solution();
	}
	public void solution() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		for(int i=1 ; i<=N ; i++) {
			sb.append(find369(i));
			sb.append(" ");
		}
		System.out.println(sb);
	}
	private String find369(int num) {
		int ret = 0;
		String str = String.valueOf(num);
		for(int i=0 ; i<str.length() ; i++) {
			if(str.charAt(i)=='3' || str.charAt(i)=='6' || str.charAt(i)=='9') {
				ret++;
			}
		}
		if(ret==0)
			return str;
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<ret ; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

}

package E_Stack_Queue;

import java.util.Scanner;

public class Q07_EduCurriculum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] must = sc.nextLine().toCharArray();
		boolean[] visited = new boolean[must.length];
		String course = sc.nextLine();
		int idx = 0;
		for(int i=0 ; i<course.length() ; i++) {
			char ch = course.charAt(i);
			if(idx==must.length)
				break;
			if(must[idx]==ch) {
				idx++;
			}
		}
		if(idx==must.length) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}

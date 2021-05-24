package F_Sorting_Searching;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q05_CheckDuplicate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Set<Integer> set = new HashSet<>();
		for(int i=0 ; i<N ; i++) {
			set.add(sc.nextInt());
		}
		if(set.size()==N) {
			System.out.println("U");
		}else {
			System.out.println("D");
		}
	}

}

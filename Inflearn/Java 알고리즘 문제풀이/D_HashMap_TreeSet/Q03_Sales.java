package D_HashMap_TreeSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q03_Sales {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] day = new int[N];
		int[] ret = new int[N-K+1];
		for(int i=0 ; i<N ; i++) {
			day[i] = sc.nextInt();
			if(i>=K-1) {
				Set<Integer> set = new HashSet<>();
				for(int j=i-K+1 ; j<=i ; j++) {
					set.add(day[j]);
				}
				sb.append(set.size()+" ");
			}
		}
		System.out.println(sb);
	}
}

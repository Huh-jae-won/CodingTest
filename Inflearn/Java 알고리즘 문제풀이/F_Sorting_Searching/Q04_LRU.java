package F_Sorting_Searching;
// Least Recently Used

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q04_LRU {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int N = sc.nextInt();
		List<Integer> cache = new ArrayList<>();
		
		for(int i=0 ; i<N ; i++) {
//			System.out.println("time = "+(i+1));
			int job = sc.nextInt();
			if(cache.contains(job)) {
//				System.out.println("hit");
//				캐시 히트
				for(int j=0 ; j<cache.size() ; j++) {
					if(cache.get(j)==job) {
//						System.out.println(j);
						cache.remove(j);
						break;
					}
				}
				cache.add(job);
			}else {
//				캐시 미스 -> 추가
				if(cache.size()<S) {
					cache.add(job);
				}else {
					cache.remove(0);
					cache.add(job);
				}
			}
//			System.out.println(cache);
//			System.out.println();
		}
		for(int i=S-1 ; i>=0 ; i--) {
			System.out.print(cache.get(i)+" ");
		}
		System.out.println();
	}
	
}

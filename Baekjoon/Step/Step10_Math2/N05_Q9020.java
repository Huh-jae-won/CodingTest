package Step10_Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N05_Q9020 {
	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1 ; tc<=testCase ; tc++) {
			list = new ArrayList();
			int N= Integer.parseInt(br.readLine().trim());
			for(int i=2 ; i<N ; i++) {
				if(findPrimeNum(i)) {
					list.add(i);
				}
			}
//			System.out.println();
//			System.out.println(N+" : "+list);
			findSum(N);
		}
	}
	static void findSum(int num) {
		int first = 0;
		int second = Integer.MAX_VALUE;
		
		for(int i=0 ; i<list.size(); i++) {
			int a = list.get(i);
			int b = num-a;
			if(list.contains(b)) {
				if(Math.abs(b-a)<Math.abs(second-first)) {
					first = a;
					second = b;
				}else {
					System.out.println(first+" "+second);
					return;
				}
			}
		}
		System.out.println(first+" "+second);
	}
	
	static boolean findPrimeNum(int num) {
		boolean flag = true;
		if(num==1)
			return false;
		if(num==2)
			return true;
		for(int i=2 ; i<=(int)Math.pow(num, 0.5) ;i++) {
			if(num%i==0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}

package Step10_Math2;

import java.util.Scanner;

public class N02_Q2581 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = Integer.parseInt(sc.nextLine());
		int N = Integer.parseInt(sc.nextLine());
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i=M ; i<=N ; i++) {
			if(findNum(i) && i!=1) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		if(sum!=0) {
			System.out.println(sum);
			System.out.println(min);
		}else {
			System.out.println(-1);
		}

	}
	static boolean findNum(int num) {
		boolean flag = true;
		for(int i=2 ; i<=num/2 ;i++) {
			if(num%i==0) {
				flag = false;
				break;
			}
		}
		return flag; 
	}

}

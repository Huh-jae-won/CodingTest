package Step13_BruteForce;

import java.util.Scanner;

public class N02_Q2231 {
	static int[] num;
	static int[] indx;
	static int min;
	static String str;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine().trim();
		int length = str.length();
		num = new int[length];
		indx = new int[length];
		for(int i=0 ; i<length ; i++) {
			indx[i] = (int)Math.pow(10, length-1-i);
		}
		flag = false;
		min = 0;
		findNum(0,length,0);
		System.out.println(min);
	}
	static int sum(int length) {
		int sum = 0;
		for(int i=0 ; i<length ; i++) {
			sum += (int)Math.pow(10, length-1-i)*num[i]+num[i];
		}
		return sum;
	}
	static void findNum(int dep,int length,int midSum) {
		if(dep==length && !flag) {
//			printArr(length);
			int sum = sum(length);
			if(sum==Integer.parseInt(str)) {
				int temp = 0;
				for(int i=0 ; i<length ; i++) {
					temp += (int)Math.pow(10, length-1-i)*num[i];
					flag = true;
				}
				min = temp;
			}
		}else {
			for(int i=0 ; i<=9 ; i++) {
				num[dep] = i;
				if(midSum<=Integer.parseInt(str))
					findNum(dep+1,length,midSum+num[dep]*(indx[dep]+1));
				if(flag)
					break;
			}
		}
	}
	static void printArr(int length) {
		for(int i=0 ; i<length ; i++){
			System.out.print(num[i]+" ");
		}
		System.out.println();
	}

}

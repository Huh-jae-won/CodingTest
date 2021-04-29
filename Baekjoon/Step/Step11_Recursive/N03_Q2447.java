package Step11_Recursive;

import java.io.IOException;
import java.util.Scanner;

public class N03_Q2447 {
	static int N;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuffer str;
		for(int i=1 ; i<=N ; i++) {
			str = new StringBuffer();
			for(int j=1 ; j<=N ; j++) {
				func(i,j,str);
			}
			System.out.println(str);
		}
	}
	static void func(int i, int j,StringBuffer str) {
		boolean flag = false;
		int indx = 3;
		int last = i;
		int cnt = 0;
		while(true) {
			last /= 3;
			cnt++;
			if(last==0)
				break;
		}
		while(indx<=Math.pow(3, cnt)) {
			int start = indx/3+1;
			int end = indx*2/3;
			if(range(indx,start,end,i) && range(indx,start,end,j)) {
				str.append(" ");
				flag = true;
				break;
			}else
				indx *= 3;
		}
		if(!flag) {
			str.append("*");
		}
	}
	static boolean range(int indx, int start, int end, int x) {
		if(x%indx>=start && x%indx<=end)
			return true;
		return false;
	}

}

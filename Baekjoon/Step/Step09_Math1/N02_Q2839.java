package Step09_Math1;

import java.util.Scanner;

public class N02_Q2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int remainKG = N;
		int temp = N/5;
		int cnt = 0;
		
		for(int i=temp ; i>-1 ; i--) {
			remainKG = N;
			cnt=0;
			
			cnt += i;
			remainKG -= 5*i;
			while(remainKG>0) {
				remainKG -= 3;
				cnt++;
			}
			if(remainKG==0) {
				System.out.println(cnt);
				break;
			}
		}
		if(remainKG!=0)
			System.out.println(-1);
	}

}

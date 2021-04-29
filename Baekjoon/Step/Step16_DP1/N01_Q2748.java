package Step16_DP1;

import java.util.Scanner;

public class N01_Q2748 {
	public static void main(String[] args) {
		long F0 = 0;
		long F1 = 1;
		long F2 = 1;
		long result = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==0) {
			System.out.print(F0);
		}else if(n<=2) {
			System.out.println(F1);
		}else {
			long cnt = 2;
			long temp1 = F1;
			long temp2 = F2;
			while(cnt<n) {
				result = temp1+temp2;
				temp1 = temp2;
				temp2 = result;
				cnt++;
			}
			System.out.println(result);
		}
	}

}

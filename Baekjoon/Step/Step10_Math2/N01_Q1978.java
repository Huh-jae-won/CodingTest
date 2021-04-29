package Step10_Math2;
import java.util.Scanner;

public class N01_Q1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for(int tc=1 ; tc<=N ; tc++) {
			int x = sc.nextInt();
			if(x==1) {
				continue;
			}
			boolean flag = true;
			for(int i=2 ; i<=x/2 ; i++) {
				if(x%i==0) {
					flag = false;
					break;
				}
			}
			if(flag)
				cnt++;
		}
		System.out.println(cnt);
	}

}

package Step16_DP1;
import java.util.Scanner;
public class N04_Q9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		long[] arr;
		for(int tc=1 ; tc<=testCase ; tc++) {
			int n = Integer.parseInt(sc.nextLine());
			arr = new long[n+1];
			if(n>=6) {
				arr[0] = 0;
				arr[1] = 1;
				arr[2] = 1;
				arr[3] = 1;
				arr[4] = 2;
				arr[5] = 2;
				for(int i=6 ; i<=n ; i++) {
					arr[i] = arr[i-1]+arr[i-5];
				}
			}else {
				int[] temp = {0,1,1,1,2,2};
				arr[n] = temp[n];
			}
			System.out.println(arr[n]);
		}
	}
}

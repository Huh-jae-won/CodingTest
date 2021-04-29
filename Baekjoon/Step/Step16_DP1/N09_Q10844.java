package Step16_DP1;

import java.util.Scanner;

public class N09_Q10844 {
	static int N;
	static long result;
	static long[][] arr;
	static int mod=1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new long[N+1][10];
		result = 0;
		if(N==1) {
			System.out.println(9);
		}else if(N==2) {
			System.out.println(17);
		}else {
			for(int i=1 ; i<10 ; i++) {
				arr[1][i] = 1;
				arr[2][i] = 2;
			}
			arr[2][9] -= 1;
			for(int i=3 ; i<N+1 ; i++) {
				for(int j=1 ; j<10 ; j++) {
					if(j==1) {
						// 길이i,j로시작 = 길이i-2,1시작 + 길이i-1,2시작
						arr[i][j] = (arr[i-2][1]+arr[i-1][2])%mod;
					}else if(j==9) {
						arr[i][j] = arr[i-1][8]%mod;
					}else {
						arr[i][j] = (arr[i-1][j-1]+arr[i-1][j+1])%mod;
					}
				}
			}
			for(int i=1 ; i<10 ; i++) {
				result += arr[N][i];
			}
			System.out.println(result%1000000000);
		}
	}
}

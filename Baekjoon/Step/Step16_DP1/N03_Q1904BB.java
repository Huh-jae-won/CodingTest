package Step16_DP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class N03_Q1904BB {
	static int N;
	static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N/2+2];
		int max00 = N/2;
		long result = count2nd(max00);
		System.out.println(result%15746);
//		System.out.println(combination(2,3));
	}
	static long count2nd(int max00) {
		long result = 0;
		long temp = 0;
		for(int i=0 ; i<=max00 ; i++) {
			int blankSpace = N-2*i+1;
			temp = combination(blankSpace+i-1,i);
			temp %= 15746;
			result += temp;
//			System.out.println(i+" : "+combination(blankSpace+i-1,i));
		}
		return result;
	}
	
	static long permutation(int n, int r) {
		long result = 1;
		if(r!=0) {
			for(int i=n ; i>n-r ; i--) {
				result *= i;
			}
		}
		return result;
	}
	static long combination(int n, int r) {
		long result = permutation(n,r);
		result /= permutation(r,r);
		return result;
	}
}

package part1_기초다지기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q01859_Millionaire{
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01859_Millionaire a = new Q01859_Millionaire();
		System.out.println("Solution참고함");
		System.out.println("배열 뒤에서 부터 계산");
		a.solution();
	}
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
//		testCase = 3;
		for(int tc=1 ; tc<=testCase ; tc++) {
			long profit = 0;
			int N = Integer.parseInt(br.readLine());
			long[] price = new long[N];
			StringTokenizer st  = new StringTokenizer(br.readLine());
			for(int i=0 ; i<N ; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			long max = price[N-1];
			int maxIndex = N-1;
			for(int i=N-2 ; i>=0 ; i--) {
				if(price[i]>max) {
					profit += getProfit(price, maxIndex, i);
					max = price[i];
					maxIndex = i;
				}
			}
			profit += getProfit(price, maxIndex, -1);
//			System.out.printf("[%d,%d]",maxIndex,max);
			bw.write("#"+tc+" "+profit+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	private long getProfit(long[] price, int maxIndex,int newMaxIndex) {
		long sum = 0;
		long max = price[maxIndex];
		for(int i=maxIndex-1 ; i>newMaxIndex ; i--) {
			sum += (max-price[i]);
		}
		return sum;
	}
}

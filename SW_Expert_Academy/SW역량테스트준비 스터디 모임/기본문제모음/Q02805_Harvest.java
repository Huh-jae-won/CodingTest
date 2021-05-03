package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q02805_Harvest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q02805_Harvest a = new Q02805_Harvest();
		a.solution();
	}
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ret = 0;
			int halfN = N/2;
			for(int i=0 ; i<N/2 ; i++) {
				String str = br.readLine();
				for(int j=halfN-i ; j<=halfN+i ; j++) {
					ret += Integer.parseInt(str.charAt(j)+"");
				}
			}
			String s = br.readLine();
			for(int i=0 ; i<N ; i++) {
				ret += Integer.parseInt(s.charAt(i)+"");
			}
			for(int i=halfN-1 ; i>=0 ; i--) {
				String str = br.readLine();
				for(int j=halfN-i ; j<=halfN+i ; j++) {
					ret += Integer.parseInt(str.charAt(j)+"");
				}
			}
			
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
}

package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q01289_Recover {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01289_Recover a = new Q01289_Recover();
		a.solution();
	}
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			String str = br.readLine();
			int ret = 0;
			int len = str.length();
			int[] mem = new int[len];
			for(int i=0 ; i<len ; i++) {
				mem[i] = Integer.parseInt(str.charAt(i)+"");
			}
			int memI = 0;
			for(int i=0 ; i<len ; i++) {
				if(mem[i]!=memI) {
					memI = mem[i];
					ret++;
				}
			}
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
}

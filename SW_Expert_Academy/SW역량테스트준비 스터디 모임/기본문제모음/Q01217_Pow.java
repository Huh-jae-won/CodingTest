package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;



public class Q01217_Pow {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01217_Pow a = new Q01217_Pow();
		a.solution();
	}
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tc=1 ; tc<=10 ; tc++) {
			int q = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int ret = powerRecur(n, m, 0);
			bw.write("#"+tc+" "+ret+"\n");
		}
		br.close();
		bw.close();
	}
	private int powerRecur(int n, int m,int cnt) {
		if(m==cnt)
			return 1;
		return n*powerRecur(n, m, cnt+1);
	}
}

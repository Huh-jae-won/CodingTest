package Step16_DP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class N02_Q9184 {
	static int a=0;
	static int b=0;
	static int c=0;
	static int[][][] w;
	public static void main(String[] args) throws IOException {
		System.out.println("Æ²¸²");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		w = new int[21][21][21];

		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(a==-1 && b==-1 && c==-1) {
				break;
			}
			String text = "w("+a+", "+b+", "+c+") = ";
			
			chkNum();
			
			int result = findNum(a,b,c);
			bw.write(text+result+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	static void chkNum() {
		if(a<0) {
			a = 0;
		}else if(a>20) {
			a = 20;
		}
		if(b<0) {
			b = 0;
		}else if (b>20) {
			b = 20;
		}
		if(c<0) {
			c = 0;
		}else if (c>20) {
			c = 20;
		}
	}
	
	static int findNum(int a, int b, int c) {
		if(w[a][b][c]==0) {
			if(a<=0 || b<=0 || c<=0) {
				w[a][b][c] = 1;
			}else if(a<b && b<c) {
				w[a][b][c] = findNum(a,b,c-1) + findNum(a,b-1,c-1) - findNum(a,b-1,c);
			}else {
				w[a][b][c] = findNum(a-1,b,c) + findNum(a-1,b-1,c) + findNum(a-1,b,c-1) - findNum(a-1,b-1,c-1);
			}
		}
		return w[a][b][c];
	}

}

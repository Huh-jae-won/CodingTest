package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q01225_pwCreation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01225_pwCreation a = new Q01225_pwCreation();
		a.solution();
	}
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc=1 ; tc<=10 ; tc++) {
			Queue<Integer> q = new LinkedList<>();
			int testCase = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0 ; i<8 ; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int reduce = 1;
			int cnt = 1;
			while(true) {
				int num = q.poll();
				if(num>reduce) {
					num -= reduce;
					q.offer(num);
					reduce %= 5;
					reduce++;
				}else {
					q.offer(0);
					break;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0 ; i<8 ; i++) {
				sb.append(q.poll()+" ");
			}
			bw.write("#"+tc+" "+sb+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}

}

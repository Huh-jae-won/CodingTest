package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q01230_PW3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01230_PW3 a = new Q01230_PW3();
		a.solution();
	}
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc=1 ; tc<=10 ; tc++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 리스트에 암호문 담음
			for(int i=0 ; i<N ; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			// 명령어를 command리스트에 담음
			int com = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			while(st.hasMoreTokens()) {
				String token = st.nextToken();
				cnt++;
				if(token.equals("I")) {
					int index = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int i=0 ; i<y ; i++) {
						list.add(index+i, Integer.parseInt(st.nextToken()));
					}
				}else if(token.equals("D")) {
					int index = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int i=0 ; i<y ; i++) {
						list.remove(index);
					}
				}else if(token.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					for(int i=0 ; i<y ; i++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
				}else {
					System.out.println("else");
				}
			}
			bw.write("#"+tc);
			for(int i=0 ; i<10 ; i++) {
				bw.write(" "+list.get(i));
			}
			bw.write("\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}

}

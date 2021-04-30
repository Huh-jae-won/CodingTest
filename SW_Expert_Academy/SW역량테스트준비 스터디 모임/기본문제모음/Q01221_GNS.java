package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Q01221_GNS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01221_GNS a = new Q01221_GNS();
		a.solution();
	}
	Map<String,Integer> num;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		num = new HashMap<>();
		num.put("ZRO", 0);
		num.put("ONE", 1);
		num.put("TWO", 2);
		num.put("THR", 3);
		num.put("FOR", 4);
		num.put("FIV", 5);
		num.put("SIX", 6);
		num.put("SVN", 7);
		num.put("EGT", 8);
		num.put("NIN", 9);
		
		for(int tc=1 ; tc<=testCase ; tc++) {
			List<String> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			String an = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0 ; i<N ; i++) {
				String temp = st.nextToken();
				list.add(temp);
			}
			list.sort(comp);
			StringBuilder ret = new StringBuilder();
			for(int i=0 ; i<N ; i++) {
				if(i<N-1) {
					ret.append(String.valueOf(list.get(i))+" ");
				}else {
					ret.append(String.valueOf(list.get(i)));
				}
			}
			bw.write(an+"\n"+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	Comparator comp = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return num.get(o1)-num.get(o2);
		}
		
	};

}

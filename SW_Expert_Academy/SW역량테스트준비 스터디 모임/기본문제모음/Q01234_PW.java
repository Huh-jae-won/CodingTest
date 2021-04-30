package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q01234_PW {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01234_PW a = new Q01234_PW();
		a.solution();
	}
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc=1 ; tc<=10 ; tc++) {
			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			String num = st.nextToken();
			for(int i=0 ; i<len ; i++) {
				list.add(Integer.parseInt(String.valueOf(num.charAt(i))));
			}
			int indx = 0;
			while(indx<list.size()-1) {
				if(chkForward(list, indx)) {
					list.remove(indx);
					list.remove(indx);
					indx--;
				}else {
					indx++;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0 ; i<list.size() ; i++) {
				sb.append(list.get(i));
			}
			bw.write("#"+tc+" "+sb+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
	
	private boolean chkForward(List<Integer> list, int indx) {
		if(indx>=list.size()-1)
			return false;
		if(indx<0)
			return false;
		if(list.get(indx+1)==list.get(indx))
			return true;
		return false;
	}
	private boolean chkBackward(List<Integer> list, int indx) {
		if(indx<1)
			return false;
		if(list.get(indx-1)==list.get(indx))
			return true;
		
		return false;
	}
}

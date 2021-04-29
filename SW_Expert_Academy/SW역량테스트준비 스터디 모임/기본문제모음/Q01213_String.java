package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Q01213_String {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01213_String a = new Q01213_String();
		a.solution();
	}
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc=1 ; tc<=10 ; tc++) {
			List<Integer> list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			int ret = 0;
			String find = br.readLine();
			String str = br.readLine();
			
			int len = find.length();
			char s = find.charAt(0);
			int index = 0;
			while(index<str.length()-len+1) {
				if(str.charAt(index)==s) {
					int compare = compare(str.substring(index,index+len),find);
					if(compare==0) {
						ret++;
						index++;
						list.add(index);
					}else {
						index += compare;
					}
				}else {
					index++;
				}
			}
			bw.write("#"+tc+" "+ret+"\n");
		}
		bw.close();
		br.close();
	}
	private int compare(String subStr, String find) {
		int ret = 0;
		for(int i=0 ; i<find.length() ; i++) {
			if(subStr.charAt(i)!=find.charAt(i)) {
				ret = i;
				break;
			}
		}
		return ret;
	}
}

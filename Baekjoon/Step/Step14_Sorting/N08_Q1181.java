package Step14_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N08_Q1181 {
	static class Word implements Comparable<Word>{
		String str;
		int length;
		Word(String str){
			this.str = str;
			this.length = str.length();
		}
		
		public int compareTo(Word word) {
			if(this.length<word.length) {
				return -1;
			}else if (this.length==word.length) {
				return this.str.compareTo(word.str);
			}else {
				return 1;
			}
		}
	}
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Word[] arr = new Word[N];
		for(int i=0 ; i<N ; i++) {
			String temp = null;
			temp = br.readLine();
			arr[i] = new Word(temp);
		}
		Arrays.sort(arr);
		for(int i=0 ; i<N ; i++) {
			if(i>0 && arr[i].str.equals(arr[i-1].str)) {
				continue;
			}
			System.out.println(arr[i].str);
		}
	}

}

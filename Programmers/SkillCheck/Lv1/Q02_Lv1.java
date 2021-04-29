package Lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q02_Lv1 {
	public static void main(String[] args) {
		Q02_Lv1 a = new Q02_Lv1();
		String s = "Zbcdefg";
		System.out.println(a.solution(s));
	}
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		List<Character> list = new ArrayList<>();
		for(int i=0 ; i<s.length() ; i++) {
			list.add(s.charAt(i));
//			System.out.print((char)arr[i]+" ");
		}
//		a-A = 32;
//		System.out.println((int) 'A'+", "+(int) 'a');
//		System.out.println((int) 'Z'+", "+(int) 'z');
//		
		Collections.sort(list, comp);
//		System.out.println(list);
		for(char ch : list) {
			sb.append(ch);
		}
		return sb.toString();
	}
	Comparator comp = new Comparator<Character>() {
		@Override
		public int compare(Character o1, Character o2) {
			return o2-o1;
		}
	};

}

package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q02_BiggestNum {
	public static void main(String[] args) {
		Q02_BiggestNum a = new Q02_BiggestNum();
		
//		int[] numbers = {6, 10, 2};
//		int[] numbers = {3, 30, 34, 5, 9};
		int[] numbers = {3, 30, 34, 5, 9,123,65,46,98,53,331};
//		int[] numbers = {121,12};
		
		System.out.println(a.big(numbers));
	}
	public String big(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		int len = numbers.length;
		List<String> list = new ArrayList<>();
		for(int i=0 ; i<len ; i++) {
			list.add(String.valueOf(numbers[i]));
		}
		Collections.sort(list, comp);
		System.out.println(list);
		for(int i=0 ; i<len ; i++) {
			sb.append(String.valueOf(list.get(i)));
		}
		return sb.toString();
	}
	Comparator comp = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
//			System.out.println("String : "+o1+", "+o2);
			int num = (int)o2.charAt(0)-(int)o1.charAt(0);
			if(num==0) {
				int lenO1 = o1.length();
				int lenO2 = o2.length();
//				System.out.println("size : "+lenO1+", "+lenO2);
				int start = 0;
//				동일 자리끼리 비교
				for(int i=1 ; i<Math.min(lenO1, lenO2) ; i++) {
					num = (int)o2.charAt(i)-(int)o1.charAt(i);
					if(num!=0)
						return num;
					start = i;
				}
//				System.out.println("start : "+start);
//				동일 수 이후 비교 ex) 34가 3보단 큰수로 만들어야함
				if(lenO1>lenO2) {
//					System.out.println("if");
					for(int i=start ; i<lenO1 ; i++) {
						char chO2 = o2.charAt(start);
						num = (int)chO2-o1.charAt(i);
						if(num!=0)
							return num;
					}
				}else {
//					System.out.println("else");
					for(int i=start ; i<lenO2 ; i++) {
						char chO1 = o1.charAt(start);
						num = (int)o2.charAt(i)-chO1;
						if(num!=0)
							return num;
					}
				}
			}
			return num;
		}
	};
}

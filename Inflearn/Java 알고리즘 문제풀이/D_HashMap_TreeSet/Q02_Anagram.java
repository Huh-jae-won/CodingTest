package D_HashMap_TreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q02_Anagram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		Map<Character,Integer> map1 = new HashMap<>();
		Map<Character,Integer> map2 = new HashMap<>();
		if(str1.length()!=str2.length()) {
			System.out.println("NO");
			return;
		}
		
		for(int i=0 ; i<str1.length() ; i++) {
			char ch1 = str1.charAt(i);
			char ch2 = str2.charAt(i);
			map1.put(ch1,map1.getOrDefault(ch1, 0)+1);
			map2.put(ch2,map2.getOrDefault(ch2, 0)+1);
		}
		if(!map1.keySet().equals(map2.keySet())) {
			System.out.println("NO");
		}else {
			for(char ch : map1.keySet()) {
				int num1 = map1.get(ch);
				int num2 = map2.get(ch);
				if(num1!=num2) {
					System.out.println("NO");
					return;
				}
			}
			System.out.println("YES");
			return;
		}
	}
}

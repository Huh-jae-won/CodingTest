package D_HashMap_TreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q01_ClassPresident {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0 ; i<str.length() ; i++) {
			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		int max = Integer.MIN_VALUE;
		char ret = 0;
		for(char key : map.keySet()) {
			if(map.get(key)>max) {
				max = map.get(key);
				ret = key;
			}
		}
		System.out.println(ret);
	}
}

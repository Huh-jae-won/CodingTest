package D_HashMap_TreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q04_findAllAnagram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
		int lenS = s.length();
		int lenT = t.length();
		int ret = 0;
		Map<Character, Integer> mapT = new HashMap<>();
		for(int i=0 ; i<lenT ; i++) {
			char ch = t.charAt(i);
			mapT.put(ch, mapT.getOrDefault(ch,0)+1);
		}
		for(int i=0 ; i<lenS-lenT+1 ; i++) {
			Map<Character,Integer> mapS = new HashMap<>();
			for(int j=i ; j<i+lenT ; j++) {
				char ch = s.charAt(j);
				mapS.put(ch, mapS.getOrDefault(ch,0)+1);
			}
			if(mapT.keySet().equals(mapS.keySet())) {
				for(char ch : mapT.keySet()) {
					if(mapT.get(ch)!=mapS.get(ch)) {
						ret--;
						break;
					}
				}
				ret++;
			}
		}
		System.out.println(ret);
	}
}

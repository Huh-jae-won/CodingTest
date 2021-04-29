package A_String_Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q12_LongestSubstring {

	public static void main(String[] args) {
		Q12_LongestSubstring q12 = new Q12_LongestSubstring();
		String str = "eaebc";
		int ret = 0;
//		ret = q12.lengthOfLongestSubstringTwoDistinct(str);
		ret = q12.solution(str);
		System.out.println("===result===");
		System.out.println(ret);
	}
	public int solution(String s) {
		// 1. ds
		int start = 0;
		int end = 0;
		int length = 0;
		int counter = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		// 2.
		while(end<s.length()) {
			char endChar = s.charAt(end);
			// map에 저장 ex) c=2,a=2,b=3개
			map.put(endChar,map.getOrDefault(endChar, 0)+1);
			if(map.get(endChar)==1)
				counter++;
			end++;
			
			// 3. 삭제
			while(counter>2) {
				char startChar = s.charAt(start);
				map.put(startChar, map.get(startChar)-1);
				if(map.get(startChar)==0) {
					counter--;
				}
				start++;
			}
			length = Math.max(length, end-start);
		}
		
		return length;
	}
	
	
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		List<Character> list = new LinkedList<>();
		Set<Character> charSet = new HashSet<>();
		int max = 0;
		char charBefore = s.charAt(0);
		charSet.add(s.charAt(0));
		list.add(s.charAt(0));
		for(int i=1 ; i<s.length() ; i++) {
			char charCurrent = s.charAt(i);
			if(!charSet.contains(s.charAt(i))) {
				if(charSet.size()>=2) {
					max = Math.max(max, list.size());
					print(list);
					remove(list, charSet, charBefore);
				}
				charSet.add(charCurrent);
			}
			charBefore = charCurrent;
			list.add(s.charAt(i));
		}
		max = Math.max(max, list.size());
		System.out.println(max);
		return max;
	}
	private void print(List<Character> list) {
		for(int i=0 ; i<list.size() ; i++) {
			System.out.print(list.get(i));
		}
		System.out.println();
	}
	private void remove(List<Character> list,Set<Character> set,char bef) {
		int index = 0;
		for(int i=list.size()-1 ; i>=0 ; i--) {
			if(bef!=list.get(i)) {
				index = i;
				set.remove(list.get(i));
				break;				
			}
		}
		int i=0;
		while(i<=index) {
			list.remove(0);
			i++;
		}
	}

}

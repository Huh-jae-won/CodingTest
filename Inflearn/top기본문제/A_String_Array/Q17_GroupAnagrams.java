package A_String_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q17_GroupAnagrams {
	public static void main(String[] args) {
		String[] list = {"eat", "tea", "ttan", "ate", "nat", "bat"};
//		Arrays.sort(list);
		System.out.println(solution(list));
//		System.out.println(groupAnagrams(list));
	}
	public static List<List<String>> solution(String[] strs){
		List<List<String>> result = new ArrayList<>();
		if(strs==null || strs.length==0)
			return result;
		Map<String, List<String>> map = new HashMap<>();
		for(String str : strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
//			System.out.println(arr);
			String key = String.valueOf(arr);
			if(map.containsKey(key)) {
				map.get(key).add(str);
			}else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(key,list);
			}
		}
		result.addAll(map.values());
		return result;
	}
	
	
	public static List<List<String>> groupAnagrams(String[] strs){
		// ttan과 tan이 같은 anagram으로 묶임 -> 수정필요
		List<List<String>> ret = new ArrayList<>();
		
		// 사용한 index를 제외시키기 위하여
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<strs.length ; i++) {
			if(sb.toString().contains(String.valueOf(i))) {
				// 사용한 index는 skip 
				continue;
			}
			
			// anagram끼리 담을 list
			List<String> list = new ArrayList<>();
			
			// 비교할 단어의 set
			Set<Character> mainSet = new HashSet<>();
			for(int j=0 ; j<strs[i].length() ; j++) {
				mainSet.add(strs[i].charAt(j));
			}
			list.add(strs[i]);
			sb.append(i);
			
			for(int j=i+1 ; j<strs.length ; j++) {
				// 비교될 단어의 set
				Set<Character> set = new HashSet<>();
				for(int k=0 ; k<strs[j].length() ; k++) {
					set.add(strs[j].charAt(k));
				}
				
				// 두set이 동일하면 list,sb에 추가
				if(mainSet.equals(set)) {
					list.add(strs[j]);
					sb.append(j);
				}
			}
			// ret에 추가
			ret.add(list);
//			System.out.println(list);
		}
//		System.out.println(ret);
		return ret;
	}

}

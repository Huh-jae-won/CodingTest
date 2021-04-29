package Lv2;

import java.util.HashMap;
import java.util.Map;

public class Q01_Lv2 {
	public static void main(String[] args) {
		Q01_Lv2 a = new Q01_Lv2();
//		System.out.println((int)'a');
//		System.out.println((int)'z');
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		System.out.println(a.solution(str1, str2));
	}
	public int solution(String str1, String str2) {
		int ret = 0;
		Map<String,Integer> map1 = new HashMap<>();
		Map<String,Integer> map2 = new HashMap<>(); 
		String newStr1 = changeStr(str1);
		String newStr2 = changeStr(str2);
		System.out.println("new1  : "+newStr1);
		System.out.println("new2  : "+newStr2);
		makeMap(map1,newStr1);
		makeMap(map2,newStr2);
		System.out.println("map1  : " + map1);
		System.out.println("map2  : " + map2);
		
		Map<String,Integer> union = unionMap(map1,map2);
		Map<String,Integer> inter = interMap(map1,map2);
//		System.out.println("union : "+ union);
//		System.out.println("inter : "+ inter);
		double x = 0;
		double y = 0;
		for(String key : union.keySet()) {
			x += union.get(key);
		}
		for(String key : inter.keySet()) {
			y += inter.get(key);
		}
//		System.out.println("uni : "+x);
//		System.out.println("int : "+y);
		if(x==0)
			return 65536;
		return (int) (y/x*65536);
	}
	
	private Map<String,Integer> interMap(Map<String,Integer> map1, Map<String,Integer>map2){
		Map<String,Integer> inter = new HashMap<>();
		for(String key : map1.keySet()) {
			if(map2.containsKey(key)) {
				int min = Math.min(map1.get(key), map2.get(key));
				inter.put(key, min);
			}
		}
		return inter;
	}
	
	private Map<String,Integer> unionMap(Map<String,Integer> map1, Map<String,Integer> map2){
		Map<String,Integer> union = new HashMap<>();
		for(String key : map1.keySet()) {
			union.put(key,map1.get(key));
		}
		for(String key : map2.keySet()) {
			int count = map2.get(key);
			union.put(key,map2.getOrDefault(key,1));
		}
		return union;
	}
	private void makeMap(Map<String,Integer> map, String str) {
		for(int i=0 ; i<str.length()-1 ; i++) {
			String temp;
			temp = str.substring(i,i+2);
			if(temp.charAt(0)>=97 && temp.charAt(0)<=122 && temp.charAt(1)>=97&&temp.charAt(1)<=122)
				map.put(temp, map.getOrDefault(temp,0)+1);
		}
	}
	
	private String changeStr(String str) {
		System.out.println("make str : "+str);
		return str.toLowerCase();
	}
}

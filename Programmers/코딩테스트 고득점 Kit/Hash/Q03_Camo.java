package Hash;

import java.util.Arrays;
import java.util.HashMap;

public class Q03_Camo {

	public static void main(String[] args) {
		Q03_Camo a = new Q03_Camo();
		String[][] clothes= {
				{"yellowhat", "headgear"}, 
				{"bluesunglasses", "eyewear"}, 
				{"green_turban", "headgear"}, 
				{"smoky_makeup", "face"}};
//		String[][] clothes = {
//			{"crowmask", "face"}, 
//			{"bluesunglasses", "face"}, 
//			{"smoky_makeup", "face"} };
//	System.out.println(a.cloth(clothes));	
		System.out.println(a.solution(clothes));
	}
	public int solution(String[][] clothes) {
		int ret = 1;
		HashMap<String,Integer> map = new HashMap<>();
		for(int i=0 ; i<clothes.length ; i++) {
			map.put(clothes[i][1],map.getOrDefault(clothes[i][1], 0)+1);
		}
		for(int num : map.values()) {
//			System.out.println(num);
			ret *= (num+1);
		}
		return ret-1;
	}
	public int cloth (String[][] clothes) {
		int ret = 0;
		HashMap<String,Integer> hm = new HashMap<>();
		for(int i=0 ; i<clothes.length ; i++) {
			// key : 의상종류, value : 해당 종류 수
			hm.put(clothes[i][1],hm.getOrDefault(clothes[i][1],0)+1);
		}
		int lengthOfKey = hm.keySet().size();
//		for(Entry<String, Integer> map : hm.entrySet()) {
//			System.out.println(map.getKey()+",     "+map.getValue());
//		}
		printHM(hm);
		String[] type = new String[lengthOfKey];
		int[] val = new int[lengthOfKey];
		boolean[] visited = new boolean[lengthOfKey];
		int indx = 0;
		for(String key : hm.keySet()) {
			type[indx] = key;
			val[indx] = hm.get(key);
			indx++;
		}
//		for(int i=0 ; i<type.length ; i++) {
//			System.out.println(type[i]+", "+val[i]);
//		}
//		System.out.println();
//		
		for(int i=1 ; i<=lengthOfKey ; i++) {
			System.out.println("length : "+i);
			int aa = recursive(val,i,0,-1,1,0);
			System.out.println("===="+aa+"====");
			ret += aa;
		}
		return ret;
	}
	private int recursive(int[] val, int length,int dep,int indx,int num,int ret) {
		if(length==dep) {
			System.out.println(num);
			ret += num;
			return ret;
		}
		for(int i=indx+1 ; i<val.length ; i++) {
			 ret = recursive(val,length,dep+1,i,num*val[i],ret);
		}
		return ret;
	}
	static void printHM(HashMap<String,Integer> hm) {
		System.out.println("======= printHM =======");
		for(String key : hm.keySet()){
			System.out.println(key+" : "+hm.get(key));
		}
		System.out.println("=======================");
	}
}

package Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Q04_bestAlbum {

	public static void main(String[] args) {
		Q04_bestAlbum a = new Q04_bestAlbum();
		String[] genres = {"zz","classic", "pop", "classic", "classic", "pop"};
		int[] plays = {5000,500,600,150,800,2500};
		a.album(genres, plays);
	}
	public int[] album(String[] genres, int[] plays) {
		int length = plays.length;
		HashMap<String,List<List>> gMap = new HashMap<>();
		HashMap<Integer,Integer> iMap = new HashMap<>();
		for(int i=0 ; i<length ; i++) {
			String g = genres[i];
			List<List> bigList = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			list.add(i);
			list.add(plays[i]);
			if(gMap.get(g)==null) {
				bigList.add(list);
				gMap.put(g,bigList);
			}else {
				System.out.println(gMap.get(g).add(list));
			}
		}
		System.out.println(gMap);
		for(String g : gMap.keySet()) {
			int sum = countPlay(gMap, g);
			System.out.println(g+" : "+sum);
			List list = new ArrayList();
			list.add(sum);
			gMap.get(g).add(list);
		}
		Collections.sort((List) gMap.values());
		return null;
	}
	private int countPlay(HashMap<String,List<List>> gMap, String g) {
		int ret = 0;
		List<List> bigList = new ArrayList<>(gMap.get(g));
		for(List<Integer> list : bigList) {
			ret += list.get(1);
		}
		return ret;
	}
}

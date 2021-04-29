package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q03_H_Index {
	public static void main(String[] args) {
		Q03_H_Index a = new Q03_H_Index();
		
		int[] citations = {3, 0, 6, 1, 5};
		
		System.out.println(a.HIndex(citations));
	}
	public int HIndex(int[] citations) {
		List<Integer> list = new ArrayList<>();
		for(int i=0 ; i<citations.length ; i++) {
			list.add(citations[i]);
		}
		Collections.sort(list,comp);
//		System.out.println(list);
		int start = citations.length;
		for(int i=start ; i>=0 ; i--) {
			if(chk(list,i))
				return i;
		}
		return -1;
	}
	private boolean chk(List<Integer> list, int start) {
		int count = 0;
		for(int i=0 ; i<list.size() ; i++) {
			if(list.get(i)<start) {
				break;
			}
			count++;
		}
		if(count>=start)
			return true;
		return false;
	}
	Comparator comp = new Comparator<Integer>() {

		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	};

}

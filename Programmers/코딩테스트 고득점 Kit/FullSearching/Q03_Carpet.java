package FullSearching;

import java.util.ArrayList;
import java.util.List;

public class Q03_Carpet {

	public static void main(String[] args) {
		Q03_Carpet a = new Q03_Carpet();
		
//		int brown = 10;
//		int yellow = 2;
		
//		int brown = 8;
//		int yellow = 1;
		
		int brown = 24;
		int yellow = 24;
		
		int[] ret = a.carpet(brown, yellow);
		System.out.printf("result : (%d,%d)\n",ret[0],ret[1]);
	}
	public int[] carpet(int brown, int yellow) {
//		2x + 2y-4 = brown;
		List<int[]> list = countByBrown(brown);
//		printList(list);
		if(list.size()==1) {
			return new int[] {list.get(0)[0],list.get(0)[1]};
		}
		for(int i=0 ; i<list.size() ; i++) {
			int[] arr = list.get(i);
			if(countByYellow(arr, yellow))
				return arr;
		}
		return null;
	}
	private boolean countByYellow(int[] arr,int yellow){
		int x = arr[0]-2;
		int y = arr[1]-2;
//		System.out.printf("[%d,%d]\n",x,y);
		if(yellow == x*y) {
//			System.out.println("true");
			return true;
		}
		return false;
	}
	private List<int[]> countByBrown(int brown) {
		List<int[]> list = new ArrayList<>();
		for(int x=0 ; x<brown/2 ; x++) {
			int y2 = brown+4-2*x;
			if(y2%2==0 && x>=y2/2) {
				list.add(new int[] {x,y2/2});
			}
		}
		return list;
	}
	static void printList(List<int[]> list) {
		for(int[] arr : list) {
			System.out.printf("(%d,%d) ",arr[0],arr[1]);
		}
		System.out.println();
	}

}

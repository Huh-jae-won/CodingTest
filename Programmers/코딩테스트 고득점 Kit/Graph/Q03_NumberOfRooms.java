package Graph;

import java.util.ArrayList;
import java.util.List;

public class Q03_NumberOfRooms {
	public static void main(String[] args) {
		System.out.println("½ÇÆÐ");
		Q03_NumberOfRooms a = new Q03_NumberOfRooms();
		
		int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 
						0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
		
		System.out.println(a.room(arrows));
	}
	public int room(int[] arrows) {
		int ret = 0;
		List<int[]> list = new ArrayList<>();
		list.add(new int[] {0,0});
		int len = arrows.length;
		int[] cur = {0,0};
		for(int i=0 ; i<len ; i++) {
//			printList(list);
			int[] nPoint = move(cur,arrows[i]);
//			System.out.printf("n : (%d,%d)\n",nPoint[0],nPoint[1]);
			cur[0] = nPoint[0];
			cur[1] = nPoint[1];
//			System.out.printf("c : (%d,%d)\n",cur[0],cur[1]);
			if(findDir(list,arrows,nPoint,arrows[i])) {
//				System.out.println("if");
				ret++;
			}
			list.add(new int[] {nPoint[0],nPoint[1]});
		}
		return ret;
	}
	private boolean findDir(List<int[]> list,int[] arrows,int[] point,int dir) {
		for(int i=0 ; i<list.size() ; i++) {
			if(list.get(i)[0]==point[0] && list.get(i)[1]==point[1]) {
				if(arrows[i]!=dir && (int)(Math.abs(arrows[i]-dir))%4==0) {
					return false;
				}else {
					return true;
				}
			}
		}
		return false;
	}
	private boolean chkPoint(List<int[]> list, int[] point) {
		for(int[] arr : list) {
			if(arr[0]==point[0] && arr[1]==point[1])
				return true;
		}
		return false;
	}
	
	private int[] move(int[] cur,int arrow) {
		int[] nextPoint = new int[2];
//					  0,1,2, 3, 4, 5, 6, 7
		int[] dRow = {-1,-1,0,1,1, 1, 0,-1};
		int[] dCol = { 0, 1,1,1,0,-1,-1,-1};
		nextPoint[0] = cur[0] + dRow[arrow];
		nextPoint[1] = cur[1] + dCol[arrow];
		return nextPoint;
	}
	
	static void printList(List<int[]> list) {
		System.out.print("[ ");
		for(int[] arr : list) {
			System.out.printf("(%2d,%2d) ",arr[0],arr[1]);
		}
		System.out.println("]");
	}
}

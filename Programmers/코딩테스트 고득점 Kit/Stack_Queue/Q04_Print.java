package Stack_Queue;

import java.util.ArrayList;
import java.util.List;

public class Q04_Print {
	public static void main(String[] args) {
		Q04_Print a = new Q04_Print();
		
//		int[] priorities = {2,1,3,2};
//		int location = 2;
		
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;		
		
		System.out.println(a.priorityPrint(priorities, location));
	}
	public int priorityPrint(int[] priorities, int location) {
		List<Integer> priQ = new ArrayList<>();
		List<Integer> idxQ = new ArrayList<>();
		int len = priorities.length;
		int ret = 0;
		// 큐에 input값 offer
		for(int i=0 ; i<len ; i++) {
			priQ.add(priorities[i]);
			idxQ.add(i);
		}
		while(!priQ.isEmpty() || ret>=len) {
			int num = priQ.get(0);
			int idx = idxQ.get(0);
			if(!chkPriority(priQ)) {
				// 중요도 높은게 존재
				priQ.remove(0);
				idxQ.remove(0);
				priQ.add(num);
				idxQ.add(idx);
			}else {
				// 인쇄해야함
				ret++;
				priQ.remove(0);
				idxQ.remove(0);
				if(idx==location) {
					return ret;
				}
			}
		}
		return ret;
	}
	private boolean chkPriority(List<Integer> priQ) {
		int size = priQ.size();
		int num = priQ.get(0);
		for(int i=1 ; i<size ; i++) {
			if(num<priQ.get(i))
				return false;
		}
		return true;
	}

}

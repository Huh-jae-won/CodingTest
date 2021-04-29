package B_LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q02_MergeKsortedLists {
	public static void main(String[] args) {
		Q02_MergeKsortedLists q02 = new Q02_MergeKsortedLists();
		ListNode[] arr = new ListNode[3];
		arr[0] = new ListNode(1);
		arr[0].next = new ListNode(4);
		arr[0].next.next = new ListNode(5);
		
		arr[1] = new ListNode(2);
		arr[1].next = new ListNode(6);
		
		arr[2] = new ListNode(1);
		arr[2].next = new ListNode(3);
		arr[2].next.next = new ListNode(4);
//		print(merge(arr));
		print(q02.solution(arr));
	}
	public ListNode solution(ListNode[] listArr) {
		Queue<ListNode> pq = new PriorityQueue<>(comp);
		ListNode newHead = new ListNode(0);
		ListNode p = newHead;	// p : Á¶ÀÛ¿ë
		for(ListNode node : listArr) {
			if(node!=null) {
				pq.offer(node);
			}
		}
		while(!pq.isEmpty()) {
			ListNode node = pq.poll();
			p.next = node;
			p = p.next;
			if(node.next!=null) {
				pq.offer(node.next);
			}
			
		}
		return newHead.next;
	}
	Comparator<ListNode> comp = new Comparator<>() {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val-o2.val;
		}
		
	};
	
	///////////////////////////////////////////
	static ListNode merge(ListNode[] listArr) {
		ListNode ret = new ListNode(-1);
		ListNode tail = ret;
		while(chkArr(listArr)) {
			int min = Integer.MAX_VALUE;
			int indx = -1;
			for(int i=0 ; i<listArr.length ; i++) {
				if(listArr[i]!=null) {
//					print(listArr[i]); 
					if(listArr[i].val<min) {
						min = listArr[i].val;
						indx = i;
					}
				}
			}
			tail.next = listArr[indx];
			tail = tail.next;
			listArr[indx] = listArr[indx].next;
		}
		return ret.next;
	}
	static boolean chkArr(ListNode[] listArr) {
		for(int i=0 ; i<listArr.length ; i++) {
			if(listArr[i]!=null) {
				return true;
			}
		}
		return false;
	}
	static void print(ListNode node) {
		while(node!=null) {
			System.out.print(node.val+"->");
			if(node.next==null) {
				System.out.println(node.val);
			}
			node = node.next;
		}
	}

}

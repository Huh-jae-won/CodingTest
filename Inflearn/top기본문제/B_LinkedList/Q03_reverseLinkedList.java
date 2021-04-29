package B_LinkedList;

public class Q03_reverseLinkedList {
	public static void main(String[] args) {
		ListNode in = makeNode(5);
		System.out.println("===input===");
		print(in);
		System.out.println("===result===");
//		print(reverseList1(in));
		print(solution(in));
	}
	public static ListNode solution(ListNode cur) {
		ListNode prev = null;
		ListNode next = null;
		while(cur!=null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	/////////////////////////////////////////////////
	// iteratively
	static ListNode reverseList1(ListNode node) {
		ListNode list = node;
		ListNode head = list;
		list = list.next;
		head.next = null;
		
		while(list!=null) {
			ListNode temp = list;
			list = list.next;
			temp.next = head;
			head = temp;
		}
		return head;
	}
	
	static ListNode makeNode(int size) {
		ListNode ret = new ListNode(-1);
		ListNode tail = ret;
		for(int i=0 ; i<size ; i++) {
			if(i==0) {
				ret.next = new ListNode((int)(Math.random()*50+1));
				tail = ret.next;
			}else {
				tail.next = new ListNode((int)(Math.random()*50+1));
				tail = tail.next;
			}
		}
		return ret.next;
	}
	static void print(ListNode node) {
		while(node!=null) {
			if(node.next==null) {
				System.out.println(node.val);
			}else {
				System.out.print(node.val+" -> ");
			}
			node = node.next;
		}
	}

}

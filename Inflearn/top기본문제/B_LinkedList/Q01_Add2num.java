package B_LinkedList;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}

public class Q01_Add2num {
	public static void main(String[] args) {
		Q01_Add2num q01 = new Q01_Add2num();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
		System.out.println("===input===");
		q01.print(l1);
		q01.print(l2);
		System.out.println("===result===");
		q01.print(q01.add2Num(l1, l2));
		q01.print(solution(l1, l2));
	}
	public static ListNode solution(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(0);
		ListNode p1 = l1;	// l1 listnode의 head
		ListNode p2 = l2;	// l2 listnode의 head
		ListNode p3 = newHead;	// 결과 listnode의 현재위치 표현
		int carry = 0;
		while(p1!=null || p2!=null) {
			if(p1!=null) {
				carry += p1.val;
				p1 = p1.next; 
			}
			if(p2!=null) {
				carry += p2.val;
				p2 = p2.next;
			}
			
			p3.next = new ListNode(carry%10);
			p3 = p3.next;
			carry /= 10;
		}
		if(carry==1)
			p3.next = new ListNode(1);
		
		return newHead.next;
	}
	
	public ListNode add2Num(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode head = null;
		ListNode tail = null;
		while(p1!=null && p2!=null) {
			int val1 = p1.val;
			int val2 = p2.val;
			int num = (val1 + val2 + carry)%10;
			carry = (val1 + val2 + carry)/10;
			if(head==null) {
				head = new ListNode(num);
				tail = head;
			}else {
				tail.next = new ListNode(num);
				tail = tail.next;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		if(p2==null) {
			while(p1!=null || carry!=0) {
				int valP1 = (carry + p1.val)%10;
				carry = (carry + p1.val)/10;
				tail.next = new ListNode(valP1);
				tail = tail.next;
				p1 = p1.next;
			}
		}else {
			while(p2!=null || carry!=0) {
				int valP2 = (carry + p2.val)%10;
				carry = (carry + p1.val)/10;
				tail.next = new ListNode(valP2);
				tail = tail.next;
				p2 = p2.next;
			}
		}
		return head;
	}
	public void print(ListNode l1) {
		ListNode node = l1;
		while(node != null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
		System.out.println();
	}

}

package A_String_Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q19_KthLargestElement {
	public static void main(String[] args) {
		Q19_KthLargestElement q19 = new Q19_KthLargestElement();
//		int[] nums = {3,2,1,5,6,4};
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k=4;
		System.out.println(q19.KthLargest(nums, k));
		System.out.println(q19.solution_array(nums, k));
		System.out.println(q19.solution_pq(nums, k));
	}
	public int solution_pq(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<Integer>(comp);
		for(int num : nums) {
			pq.offer(num);
			if(pq.size()>k) {
				// pq사이즈를 k개로 유지, 최소값 poll됨
				pq.poll();
			}
		}
		return pq.poll();
		
	}
	Comparator<Integer> comp = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1-o2;
		}
		
	};
	
	public int solution_array(int[] nums, int k) {
		int length = nums.length;
		Arrays.sort(nums);
		return nums[length-k];
	}
	public int KthLargest(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
		for(int num : nums) {
			pq.add(num);
		}
		for(int i=1 ; i<k ; i++) {
			pq.poll();
		}
		return pq.poll();
	}
}

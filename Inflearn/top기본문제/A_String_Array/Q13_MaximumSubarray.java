package A_String_Array;
// DP ´À³¦???
public class Q13_MaximumSubarray {
	public static void main(String[] args) {
		int ret = 0;
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		Q13_MaximumSubarray q13 = new Q13_MaximumSubarray();
		ret = q13.maxSubArray(nums);
		System.out.println("===result===");
		System.out.println(ret);
	}
	public int maxSubArray(int[] nums) {
		int currentSum = nums[0];
		int max = nums[0];
		
		for(int i=1 ; i<nums.length ; i++) {
			currentSum = Math.max(nums[i], nums[i]+currentSum);
			max = Math.max(max, currentSum);
			System.out.printf("%2d : cur=%3d, max=%3d \n",i,currentSum,max);
		}
		return max;
	}

}

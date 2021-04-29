package A_String_Array;
import java.util.HashMap;
import java.util.Map;
// 응용이 많이 됨
public class Q03_TwoSum {

	public static void main(String[] args) {
		Q03_TwoSum Q03 = new Q03_TwoSum();
		int[] nums = {2,8,11,14,15,1};
		int target = 14;
		int[] ret = Q03.twoSum(nums, target);
		System.out.println(ret[0]+", "+ret[1]);

	}
	
	public int[] twoSum(int[] nums, int target) {
//		1. 자료구조
		int[] result = new int[2];
		Map<Integer,Integer> map = new HashMap<>();
//		2. for
		for(int i=0 ; i<nums.length ; i++) {
			if(map.containsKey(nums[i])) {
				result[0] = map.get(nums[i])+1;
				result[1] = i+1;
			}else {
				map.put(target-nums[i], i);
			}
		}
		return result;
	}
//	public int[] twoSum(int[] nums, int target) {
//		int[] ret = new int[2];
//		for(int i=0 ; i<nums.length-1 ; i++) {
//			for(int j=i+1 ; j<nums.length ; j++) {
//				if(nums[i]+nums[j]==target) {
//					ret[0] = i+1;
//					ret[1] = j+1;
//					return ret;
//				}
//			}
//		}
//		return null;
//	}

}

package A_String_Array;

import java.util.ArrayList;
import java.util.List;

public class Q20_MissingRanges {
	public static void main(String[] args) {
		int[] nums = {2,3,5,50,75};
//		int[] nums = {0,1,3,50,75};
		int lower = 0;
		int upper = 99;
		System.out.println(missingRange(nums,lower,upper));
	}	
	
	/////////////////////////////////////////////////
	public static List<String> missingRange(int[] nums, int lower, int upper){
		List<String> result = new ArrayList<String>();

		// null check
		if(nums==null||nums.length==0)
			return result;
		
		int start = lower;
		int end = nums[0];
		
		if(start<nums[0]) {
			if(start+2==nums[0]) {
				result.add(String.valueOf(start+1));
			}else if(start+2<upper){
				result.add(String.valueOf(start+1)+"->"+String.valueOf(upper));
			}
		}
		
		for(int i=1 ; i<nums.length ; i++) {
			end = nums[i];
			if(end-start>2) {
				result.add(String.valueOf(start+1)+"->"+String.valueOf(end-1));
			}else if (end-start==2) {
				result.add(String.valueOf(start+1));
			}
			start = end;
		}
		if(start<upper) {
			if(start+2==upper) {
				result.add(String.valueOf(start+1));
			}else if(start+2<upper){
				result.add(String.valueOf(start+1)+"->"+String.valueOf(upper));
			}
		}
		return result;
	}
}

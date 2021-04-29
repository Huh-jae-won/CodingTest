package A_String_Array;
import java.util.Arrays;

public class Q02_MoveZeros {
	public static void main(String[] args) {
		Q02_MoveZeros zero = new Q02_MoveZeros();
		int[] nums = {0,1,2,3,0,5,6,7};
		zero.moveZeros(nums);
	}
	public void moveZeros(int[] nums) {
		int length = nums.length;
		int cnt0 = 0;
		for(int i=0 ; i<length ; i++) {
			if(nums[i]!=0) {
				nums[i-cnt0] = nums[i];
				nums[i] = 0;
			}else {
				cnt0+=1;
			}
		}
		
		for(int i=0 ; i<length ; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}

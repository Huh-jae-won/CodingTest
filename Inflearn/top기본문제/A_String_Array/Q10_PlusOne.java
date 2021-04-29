package A_String_Array;

public class Q10_PlusOne {
	public static void main(String[] args) {
		Q10_PlusOne q10 = new Q10_PlusOne();
		String N = "21999";
		int[] num = new int[N.length()+1];
		int[] ret;
		for(int i=N.length()-1 ; i>=0 ; i--) {
			num[i+1] = Integer.parseInt(N.charAt(i)+"");
		}
		
		System.out.println("===in===");
		q10.print(num);
		
		ret = q10.plusOne(num);
		System.out.println("===my===");
		q10.print(ret);
		
		ret = q10.solution(num);
		System.out.println("===sol===");
		q10.print(ret);
	}
	public int[] solution(int[] digits) {
		// 1. ds
		int index = digits.length-1;
		int carry = 1;
		
		// 2. for, while
		while(index>=0 && carry>0) {
			digits[index] = (digits[index]+carry)%10;
			if(digits[index]==0) {
				carry = 1;
			}else {
				carry = 0;
			}
			index--;
		}
		return digits;
	}
	
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		int[] ret = new int[length];
		int carry = 0;
		// 1의 자리
		if(digits[length-1]==9) {
			ret[length-1]=0;
			carry = 1;
		}else {
			ret[length-1] = digits[length-1]+1;
		}
		// 10의 자리 부터~
		for(int i=length-2 ; i>=0 ; i--) {
			if(carry==0) {
				ret[i] = digits[i];
				continue;
			}
			if(digits[i]==9) {
				ret[i] = 0;
				carry = 1;
			}else {
				ret[i] = digits[i]+1;
				carry = 0;
			}
		}
		return ret;
	}
	public void print(int[] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			if(i==0 && arr[i]==0)
				continue;
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}

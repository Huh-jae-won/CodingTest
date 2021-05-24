import java.util.Arrays;

public class main {
	public static void main(String[] args) {
		int[] arr = {1,3,4,5,6};
		Arrays.sort(arr);
		int endIdx = arr.length-1;
		int startIdx = 0;
		int ret = 0;
		while(!aa(arr) && endIdx>startIdx) {
			if(arr[endIdx]>arr[endIdx-1]) {
				arr[endIdx] --;
				arr[startIdx]++;
				ret += 2;
			}else {
				endIdx--;
			}
		}
	}
	static boolean aa(int[] arr) {
		for(int i=1 ; i<arr.length ; i++) {
			if(arr[0]!=arr[i])
				return false;
		}
		return true;
	}
}




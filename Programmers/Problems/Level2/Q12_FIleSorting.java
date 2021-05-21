package Level2;

import java.util.Arrays;
import java.util.Comparator;

public class Q12_FIleSorting {
	public static void main(String[] args) {
		String[] strs = {"001","01","00100","100","0100","00001"};
		Arrays.sort(strs,comp);
		System.out.println(Arrays.toString(strs));
	}
	static Comparator<String> comp = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return Integer.parseInt(o1)-Integer.parseInt(o2);
		}
	};
}

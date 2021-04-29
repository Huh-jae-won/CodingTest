package Step05_practice;

import java.util.ArrayList;
import java.util.Scanner;

public class N03_Q10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList list = new ArrayList<Integer>();
		for(int i=0 ; i<3 ; i++)
			list.add(sc.nextInt());
		list.sort(null);
		System.out.println(list.get(1));
	}
}

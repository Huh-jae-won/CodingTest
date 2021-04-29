package Step14_Sorting;

import java.util.Scanner;

public class N05_Q1427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine().trim();
		int length = num.length();
		char[] arr = new char[length];
		for(int i=0 ; i<length ; i++) {
			arr[i] = num.charAt(i);
		}
		for(int x=0 ; x<length ; x++) {
			for(int i=0 ; i<length-1 ; i++) {
				if(arr[i]<arr[i+1]) {
					char temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
		for(int i=0 ; i<length ; i++){
			System.out.print(arr[i]);
		}
	}

}

package Step14_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class N01_Q2750 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N];
		for(int i=0 ; i<N ; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}
		Arrays.sort(arr);
		for(int i=0 ; i<N ; i++) {
			System.out.println(arr[i]);
		}
	}
}

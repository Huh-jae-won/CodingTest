package Step14_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class N04_Q2108 {
	static int N;
	static int[] arr;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N];
		list = new ArrayList();
		int sum = 0;
		for(int i=0 ; i<N ; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
			sum += arr[i];
		}
		Arrays.sort(arr);
		for(int i=0 ; i<N ; i++) {
			isNum(arr[i]);
		}
		int median = arr[N/2];
		int mean = 0;
		if(sum>=0) {
			mean = (int)((sum+0.0)/N+0.5);
		}else {
			mean = (int)((sum+0.0)/N-0.5);
		}
		int range = Math.abs(arr[N-1]-arr[0]);
		System.out.println(mean);
		System.out.println(median);
		findMost();
		System.out.println(range);
	}
	static void findMost() {
		int length = list.size();
		int mostCnt = 0;
		int[] arr = new int[N];
		int indx = 0;
		for(int i=0 ; i<length ; i++) {
			int[] temp = null;
			temp = list.get(i);
			if(temp[1] > mostCnt) {
				mostCnt = temp[1];
				arr[0] = temp[0];
				indx = 0;
			}else if(temp[1]==mostCnt) {
				arr[++indx] = temp[0];
			}
		}
		if(indx>0) {
			System.out.println(arr[1]);
		}else {
			System.out.println(arr[0]);
		}
	}
	
	static void isNum(int num) {
		boolean flag = false;
		int length = list.size();
		for(int i=0 ; i<length ; i++) {
			if(list.get(i)[0]==num) {
				list.get(i)[1]++;
				flag = true;
				break;
			}
		}
		if(!flag) {
			int[] temp = {num,1};
			list.add(temp);
		}
	}
}

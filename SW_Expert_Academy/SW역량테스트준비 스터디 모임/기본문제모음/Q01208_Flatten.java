package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q01208_Flatten {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01208_Flatten a = new Q01208_Flatten();
		a.solution();
	}
	int move = 0;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc=1 ; tc<=10 ; tc++) {
			int len = 100;
			int[] arr = new int[len];
			move = Integer.parseInt(br.readLine());
//			System.out.println("move : "+move);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0 ; i<len ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int[] index = {0,99};
			Arrays.sort(arr);
//			printArr(arr);
//			move����
			int ret = 0;
			for(int i=1 ; i<=move ; i++) {
				int maxIndex = index[1];
				int minIndex = index[0];
				arr[maxIndex]--;
				arr[minIndex]++;
				if(arr[maxIndex]-arr[minIndex]<=1) {
//					System.out.println("break");
//					System.out.printf("%d : min[%d] : %d, max[%d] : %d\n",i,minIndex,arr[minIndex],maxIndex,arr[maxIndex]);
					break;
				}
//				System.out.printf("%d : min[%d] : %d, max[%d] : %d\n",i,minIndex,arr[minIndex],maxIndex,arr[maxIndex]);
				index = changeIndex(arr,index);
			}
			ret = arr[index[1]]-arr[index[0]];
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	private int[] changeIndex(int[] arr, int[] index) {
		int maxIndex = index[1];
		int minIndex = index[0];
		for(int i=99 ; i>=0 ; i--) {
			if(arr[i]>arr[maxIndex]) {
				maxIndex = i;
				break;
			}
		}
		for(int i=0 ; i<99 ; i++) {
			if(arr[i]<arr[minIndex]) {
				minIndex = i;
				break;
			}
		}
		return new int[] {minIndex,maxIndex};
	}
	
	static void printArr(int[] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			if(i!=0 && i%10==0)
				System.out.println();
			System.out.printf("%3d ",arr[i]);
		}
		System.out.println();
	}
}

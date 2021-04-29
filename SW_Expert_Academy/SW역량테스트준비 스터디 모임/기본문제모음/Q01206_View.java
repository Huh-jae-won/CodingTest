package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q01206_View {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01206_View a = new Q01206_View();
		a.solution();
	}
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc=1 ; tc<=10 ; tc++) {
			int len = Integer.parseInt(br.readLine());
			int[] arr = new int[len];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0 ; i<len ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int sum = 0;
			for(int i=2 ; i<len-2 ; i++) {
				sum += chk(arr, i);
			}
			bw.write("#"+tc+" "+sum+"\n");
			bw.flush();
//			System.out.printf("#%d %d\n",tc,sum);
		}
		br.close();
		bw.close();
	}
	private int chk(int[] arr, int index) {
		int start = arr[index];
		int max = 0;
		for(int i=start ; i>=0 ; i--) {
			for(int x=index-2 ; x<index+3 ; x++) {
				if(x==index)
					continue;
				if(arr[x]>max) {
					max = arr[x];
				}
			}
		}
		if(start-max<0)
			return 0;
		return start-max;
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

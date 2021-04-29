package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9466_2 {
	static int N;
	static int[][] arr;
	static boolean[] flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1 ; tc<=T ; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[2][N+1];
			flag = new boolean[N+1];
			
			for(int j=1 ; j<N+1 ; j++) {
				arr[0][j] = j;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1 ; j<N+1 ; j++) {
				arr[1][j] = Integer.parseInt(st.nextToken());
			}
			for(int i=0 ; i<2 ; i++) {
				for(int j=1 ; j<N+1 ; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
			// 1. 위 아래 같은 수 -> 바로 ok
			// 2. 둘째 줄에 없는수 -> 정답 제외
//			chkSame();
//			for(int i=1 ; i<N+1 ; i++) {
//				chkCycle(i);
//			}
//			int result = cntFlag();
//			System.out.println(result);
//			printFlag();
		}
	}
	
	static void chkCycle(int num) {
		int indx = 0;
		int[] temp = new int[N+1];
		temp[indx++] = num;
		int next = arr[1][num];
		while(true) {
			try {
				temp[indx] = next;
				if(next==temp[0]) {
					changeFlag(temp,indx-1);
				}
				indx++;
				next = arr[1][next];
			}catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
		}
	}
	
	static void chkSame() {
		for(int j=1 ; j<N+1 ; j++) {
			if(arr[0][j]==arr[1][j]) {
				flag[j] = true;
			}
		}
	}
	static void changeFlag(int[] temp,int length) {
		for(int i=0 ; i<length ; i++) {
			flag[temp[i]] = true;
		}
	}
	static int cntFlag() {
		int cnt=0;
		for(int i=1 ; i<N+1 ; i++) {
			if(flag[i])
				cnt++;
		}
		return cnt;
	}
	
	static void printFlag() {
		for(int i=1 ; i<N+1 ; i++) {
			if(flag[i])
				System.out.println(i);
		}
	}

}

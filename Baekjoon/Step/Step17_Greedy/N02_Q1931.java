package Step17_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N02_Q1931 {
	static int N;
	static long[][] meeting;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = 0;
		meeting = new long[N][2]; 
		long[][] temp = new long[N][2]; 
		visited = new boolean[N];
		StringTokenizer st;
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<2 ; j++) {
				meeting[i][j] = Long.parseLong(st.nextToken());
			}
		}
		sorting(meeting);
//		print(meeting);
		Long nextStart = canStart(0);
		while(nextStart!=-1) {
			nextStart = canStart(nextStart);
		}
		System.out.println(result);
		
	}
	static long canStart(long startTime) {
		int indx = -1;
		long finishTime = Long.MAX_VALUE;
		for(int i=0 ; i<N ; i++) {
			if(!visited[i] && meeting[i][0]>=startTime) {
				if(finishTime>meeting[i][1]) {
					indx = i;
					finishTime = meeting[i][1];
				}else if(finishTime==meeting[i][1]) {
					if(meeting[indx][0]>meeting[i][0]) {
						indx = i;
						finishTime = meeting[i][1];
					}
				}
			}			
		}
		if(indx!=-1) {
			visited[indx] = true;
			result++;
			return finishTime;
		}
		return -1;
	}
	static void print(long[][] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			System.out.println(arr[i][0]+", "+arr[i][1]);
		}
	}
	static void sorting(long[][] arr) {
		long[] temp = new long[2];
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr.length-i-1 ; j++) {
				if(arr[j][1]>arr[j+1][1]) {
					temp[0] = arr[j][0];
					temp[1] = arr[j][1];
					arr[j][0] = arr[j+1][0];
					arr[j][1] = arr[j+1][1];
					arr[j+1][0] = temp[0];
					arr[j+1][1] = temp[1];
				}else if(arr[j][1]==arr[j+1][1]) {
					if(arr[j][0]>arr[j+1][0]) {
						temp[0] = arr[j][0];
						temp[1] = arr[j][1];
						arr[j][0] = arr[j+1][0];
						arr[j][1] = arr[j+1][1];
						arr[j+1][0] = temp[0];
						arr[j+1][1] = temp[1];
					}
				}
			}
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] meeting = new long[N][2];
		StringTokenizer st;
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<2 ; j++) {
				meeting[i][j] = Long.parseLong(st.nextToken());
			}
		}
		sorting(meeting);
		print(meeting);
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


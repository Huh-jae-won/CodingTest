package 기본문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q01215_Palindrome {
	// Palindrome : 회문 ex)토마토, 기러기, ...
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01215_Palindrome a = new Q01215_Palindrome();
		a.solution();
		
	}
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int tc=1 ; tc<=10 ; tc++) {
			char[][] map = new char[8][8];
			int ret = 0;
			int n = Integer.parseInt(br.readLine());
			for(int i=0 ; i<8 ; i++) {
				String str = br.readLine();
				for(int j=0 ; j<8 ; j++) {
					map[i][j] = str.charAt(j);
				}
			}
//			printArr(map);
			
			for(int i=0 ; i<8 ; i++) {
				for(int j=0 ; j<8 ; j++) {
					int temp = isPalindrome(map, n, i, j);
//					if(temp>0) {
//						System.out.println("("+i+", "+j+") : "+temp);
//					}
						ret += temp;
				}
			}
			bw.write("#"+tc+" "+ret+"\n");
		}
		br.close();
		bw.close();
	}
	private int isPalindrome(char[][] map, int n, int row, int col) {
		int fail = 0;
		if(row<8-n+1) {
			int half = n/2;
			for(int i=0 ; i<half ; i++) {
				if(map[row+i][col]!=map[row+n-1-i][col]) {
					fail++;
					break;
				}
			}
		}else {
			fail++;
		}
		if(col<8-n+1) {
			int half = n/2;
			for(int i=0 ; i<half ; i++) {
				if(map[row][col+i]!=map[row][col+n-1-i]) {
					fail++;
					break;
				}
			}
		}else {
			fail++;
		}
		return 2-fail;
	}
	
	
	static void printArr(char[][] arr) {
		for(int i=0 ; i<8 ; i++) {
			for(int j=0 ; j<8 ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}

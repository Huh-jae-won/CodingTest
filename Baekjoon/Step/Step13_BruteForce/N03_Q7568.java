package Step13_BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N03_Q7568 {
	static int N;
	static int[][] people;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		people = new int[N][3];
		
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			people[i][0] = Integer.parseInt(st.nextToken());
			people[i][1] = Integer.parseInt(st.nextToken());
			people[i][2] = 1;
		}
		chkRank();
		printRank();
		
	}
	static void printRank() {
		for(int i=0 ; i<N ; i++) {
			System.out.print(people[i][2]+" ");
		}
		System.out.println();
	}
	
	static void whoIsBigger(int i, int j) {
		if(people[i][0]>people[j][0] && people[i][1]>people[j][1]) {
			people[j][2]++;
		}
	}
	
	static void chkRank() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(i==j)
					continue;
				whoIsBigger(i, j);
			}
		}
	}

}

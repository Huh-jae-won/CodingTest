package D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q02819_Patchwork {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q02819_Patchwork z = new Q02819_Patchwork();
		z.solution();
	}	
	Set<String> set;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			String[][] map = new String[4][4];
			set = new HashSet<>();
			for(int i=0 ; i<4 ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<4 ; j++) {
					map[i][j] = st.nextToken();
				}
			}
			for(int i=0 ; i<4 ; i++) {
				for(int j=0 ; j<4 ; j++) {
					makeNum(map,0,i,j,"");
				}
			}
//			System.out.println(set);
//			System.out.println(set.size());
			
//			printMap(map);
			bw.write("#"+tc+" "+set.size()+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	private void makeNum(String[][] map, int dep, int row, int col, String str) {
		if(dep==7) {
			set.add(str);
			return;
		}
		if(!inRange(row,col)) {
			return;
		}
		for(int[] dir : dirs) {
			int nRow = row + dir[0];
			int nCol = col + dir[1];
			makeNum(map,dep+1,nRow,nCol,str+map[row][col]);
		}
	}
	private boolean inRange(int row, int col) {
		if(row>=0 && row<4 && col>=0 && col<4)
			return true;
		return false;
	}
	
	private void printMap(String[][] map) {
		for(String[] arr : map) {
			System.out.println(Arrays.toString(arr));
		}
	}
}

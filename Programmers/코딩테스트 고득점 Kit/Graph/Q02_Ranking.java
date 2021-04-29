package Graph;

public class Q02_Ranking {
	public static void main(String[] args) {
		System.out.println("½ÇÆÐ");
		Q02_Ranking a = new Q02_Ranking();
		int n = 5;
		int[][] results = {
				{4,3}, {4,2},
				{3,2}, {1,2}, {2,5}
		};
		System.out.println(a.rank(n, results));
	}
	public int rank(int n, int[][] results) {
//		1µî : n-1½Â
//		2µî : n-2½Â, 1ÆÐ
//		...
//		5µî : 0½Â, n-1ÆÐ 
		int[][] map = new int[n+1][n+1];
		for(int i=0 ; i<results.length ; i++) {
			int winner = results[i][0];
			int loser  = results[i][1];
			map[winner][loser] = 1;
			map[loser][winner] = -1;
		}
		printArr(map);
		return 1;
	}
	static void printArr(int[][] map) {
		for(int i=1 ; i<map.length ; i++) {
			for(int j=1 ; j<map[i].length ; j++) {
				System.out.printf("%2d ",map[i][j]);
			}
			System.out.println();
		}
	}
}

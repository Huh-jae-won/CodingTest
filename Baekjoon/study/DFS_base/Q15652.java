package DFS_base;
import java.util.Scanner;

public class Q15652 {
	static int N = 0;
	static int M = 0;
	static int temp = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		dfs(0,"");
	}
	static void dfs(int dep, String ans) {
		if(dep == M) {
			System.out.println(ans);
		}else {
			for(int i=1 ; i<=N ; i++) {
				if(temp<=i ) {
					temp = i;
					dfs(dep+1,ans+i+" ");
				}
			}
			temp = 0;
		}
	}
}

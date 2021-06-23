package Level3;

public class Q35_GoToSchool {
	public static void main(String[] args) {
		Q35_GoToSchool z = new Q35_GoToSchool();
		int m = 4;
		int n = 3;
		int[][] puddles = {{2,2}};
		int ret = z.solution(m, n, puddles);
		System.out.println(ret);
	}
    int div = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m+1][n+1];
        for(int[] arr : puddles){
            if(arr.length!=0)
                map[arr[0]][arr[1]] = -1;
        }
        map[1][1] = 1;
        // printArr(map);
        return move(map);
    }
    private int move(int[][] map){
        int rowLen = map.length;
        int colLen = map[0].length;
        for(int i=1 ; i<rowLen ; i++){
            for(int j=1 ; j<colLen ; j++){
                if(i==1&&j==1 || map[i][j]==-1)
                    continue;
                map[i][j] = cntPath(map,i,j);
            }
        }
        // printArr(map);
        return map[rowLen-1][colLen-1];
    }
    private int cntPath(int[][] map, int i, int j){
        long up = map[i-1][j];
        long left = map[i][j-1];
        long sum = up+left;
        if(map[i-1][j]==-1 || map[i][j-1]==-1)
            return (int)(Math.max(map[i-1][j],map[i][j-1]));
        return (int)(sum%div);
    }
    
    private void printArr(int[][] map){
        for(int i=1 ; i<map.length ; i++){
            for(int j=1 ; j<map[i].length ; j++){
                System.out.printf("%2d ",map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

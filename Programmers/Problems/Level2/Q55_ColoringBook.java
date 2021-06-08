package Level2;

public class Q55_ColoringBook {

	public static void main(String[] args) {
		Q55_ColoringBook a = new Q55_ColoringBook();
		int m = 6;
		int n = 4;
		int[][] picture = {
				{1, 1, 1, 0}, 
				{1, 2, 2, 0},
				{1, 0, 0, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 3}, 
				{0, 0, 0, 3}	
		};
		int[] ret = a.coloring(m, n, picture);
		System.out.println("ret : "+ret[0]+", "+ret[1]);
	}
	int maxRow;
    int maxCol;
    public int[] coloring(int m, int n, int[][] picture) {
        maxRow = m;
        maxCol = n;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;      
        // printArr(picture);
        boolean[][] visited = new boolean[m][n];
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                int area = 0;
                if(picture[i][j]!=0 && !visited[i][j]){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(picture,visited,i,j,picture[i][j],0));
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    int[] dRow = {-1,1,0,0};
    int[] dCol = {0,0,-1,1};
    private int dfs(int[][] pic, boolean[][] visited, int row, int col, int color,int area){
        if(row<0 || row>=maxRow || col<0 || col>=maxCol || pic[row][col]!=color || visited[row][col]){
            return area;
        }
        area++;
        visited[row][col] = true;
        for(int i=0 ; i<4 ; i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            area = dfs(pic,visited,nRow,nCol,color,area);
        }
        return area;
    }
    
    
    static void printArr(int[][] arr){
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[i].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}

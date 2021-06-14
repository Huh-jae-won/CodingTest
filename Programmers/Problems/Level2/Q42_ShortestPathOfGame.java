package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q42_ShortestPathOfGame {
	public static void main(String[] args) {
		Q42_ShortestPathOfGame z = new Q42_ShortestPathOfGame();
		int[][] maps = {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}  };
		
		int ret = z.solution(maps);
		System.out.println(ret);
	}
    public int solution(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;
        boolean[][] visitTeam = new boolean[m][n];
        boolean[][] visitEnem = new boolean[m][n];
        Queue<int[]> qTeam = new LinkedList<>();
        Queue<int[]> qEnem = new LinkedList<>();
        qTeam.offer(new int[]{0,0});
        qEnem.offer(new int[]{m-1,n-1});
        visitTeam[0][0] = true;
        visitEnem[m-1][n-1] = true;
        
        int time = 0;
        int cntTeam = 1;
        int cntEnem = 1;
        int ret = 0;
        while(true){
            time++;
            if(cntTeam!=0)
                cntTeam = moveTeam(maps,qTeam,visitTeam);
            if(chkVisited(visitTeam,visitEnem)){
                // System.out.println("team");
                ret = time*2;
                break;
            }
            
            if(cntEnem!=0)
                cntEnem = moveEnem(maps,qEnem,visitEnem);
            if(chkVisited(visitTeam,visitEnem)){
                // System.out.println("enem");
                ret = time*2+1;
                break;
            }
            if(cntTeam==0 && cntEnem==0){
                // System.out.println("0000");
                ret = -1;
                break;
            }
        }
//        System.out.println(time);
        return ret;
    }
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // 상하좌우
    private int moveTeam(int[][] maps, Queue<int[]> q, boolean[][] visitTeam){
        int cnt = 0;
        int size = q.size();
        for(int i=0 ; i<size ; i++){
            int[] pos = q.poll();
            for(int[] dir : dirs){
                int nRow = pos[0] + dir[0];
                int nCol = pos[1] + dir[1];
                if(inRange(maps,nRow,nCol,visitTeam)){
                    visitTeam[nRow][nCol] = true;
                    cnt++;
                    q.offer(new int[]{nRow,nCol});
                }
            }
        }
        return cnt;
    }
    private int moveEnem(int[][] maps, Queue<int[]> q, boolean[][] visitEnem){
        int cnt = 0;
        int size = q.size();
        for(int i=0 ; i<size ; i++){
            int[] pos = q.poll();
            for(int[] dir : dirs){
                int nRow = pos[0] + dir[0];
                int nCol = pos[1] + dir[1];
                if(inRange(maps,nRow,nCol,visitEnem)){
                    visitEnem[nRow][nCol] = true;
                    cnt++;
                    q.offer(new int[]{nRow,nCol});
                }
            }
        }
        return cnt;
    }
    
    private boolean chkVisited(boolean[][] vTeam, boolean[][] vEnem){
        int m = vTeam.length;
        int n = vTeam[0].length;
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(vTeam[i][j] && vEnem[i][j])
                    return true;
            }
        }
        return false;
    }
    private boolean inRange(int[][] maps, int row, int col, boolean[][] visited){
        int m = maps.length;
        int n = maps[0].length;
        if(row>=0 && row<m && col>=0 && col<n){
            if(maps[row][col]==1 && !visited[row][col])
                return true;
        }
        return false;
    }
}

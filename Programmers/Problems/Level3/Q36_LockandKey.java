package Level3;

import java.util.Arrays;

public class Q36_LockandKey {
	public static void main(String[] args) {
		Q36_LockandKey z = new Q36_LockandKey();
		int[][] key = {
				{0,0,0},
				{1,0,0},
				{0,1,1}};
		int[][] lock = {
				{1,1,1},
				{1,1,0},
				{1,0,1}};
		boolean ret = z.solution(key, lock);
		System.out.println(ret);
	}
    class Key{
        int[][] k;
        int row;
        int col;
        public Key(int[][] key){
            this.k = key;
        }
        public String toString(){
            String ret = "";
            for(int[]arr : k){
                ret += Arrays.toString(arr)+"\n";
            }
            return ret;
        }
        private void rotate(){
            int len = k.length;
            int[][] rot = new int[len][len];
            for(int i=0 ; i<len ; i++){
                for(int j=0 ; j<len ; j++){
                    rot[len-1-j][i] = k[i][j];
                }
            }
            k = rot;
            // printMap(rot);
            // System.out.println("===========");
        }
    }
    public boolean solution(int[][] key, int[][] lock) {
        int keyLen = key.length;
        int lockLen = lock.length;
        int[][] map = new int[lockLen+(keyLen-1)*2][lockLen+(keyLen-1)*2];
        // map 만드는 과정
        for(int[] arr : map){
            Arrays.fill(arr,9);
        }
        for(int i=keyLen-1 ; i<map.length-(keyLen-1) ; i++){
            for(int j=keyLen-1 ; j<map.length-(keyLen-1) ; j++){
                map[i][j] = lock[i-keyLen+1][j-keyLen+1];
            }
        }
        // printMap(map);
        
        Key KY = new Key(key);
        for(int r=0 ; r<4 ; r++){
            for(int i=0 ; i<map.length-(keyLen-1) ; i++){
                for(int j=0 ; j<map.length-(keyLen-1) ; j++){
                    // i,j : key의 시작 위치
                    KY.row = i;
                    KY.col = j;
                    boolean flag = check(map,KY);
                    // System.out.printf("[r %d, (%d,%d)]:%b ",r,i,j,flag);
                    if(flag)
                        return true;
                }
            }
            KY.rotate();
        }
        return false;
    }
    private boolean check(int[][] map, Key key){
        int row = key.row;
        int col = key.col;
        int len = map.length;
        int keyLen = key.k.length;
        int[][] kkk = new int[len][len];
        // row,col : key의 시작위치
        
        // map크기와 똑같은 arr에 key를 위치에 맞게 넣음
        for(int i=row ; i<row+keyLen ; i++){
            for(int j=col ; j<col+keyLen ; j++){
                kkk[i][j] = key.k[i-row][j-col];
            }
        }

        for(int i=keyLen-1 ; i<len-(keyLen-1) ; i++){
            for(int j=keyLen-1 ; j<len-(keyLen-1) ; j++){
                if(map[i][j]+kkk[i][j]==1){
                    // 둘 중 하나만 1인경우
                    continue;
                }
                if((map[i][j]*kkk[i][j]==1) || (map[i][j]+kkk[i][j]==0)){
                    // 둘다 0 or 1인 경우
                    return false;
                }
            }
        }
        return true;
    }
    private boolean inKeyRange(Key key,int row, int col,int i, int j){
        // i,j : 현재 위치
        int keyLen = key.k.length;
        if(i>=row && i<row+keyLen && j>=col && j<col+keyLen)  // i,j가 key범위 안에 존재하면 true
            return true;
        return false;
        
    }
    
    private void printMap(int[][] map){
        for(int[] arr : map){
            System.out.println(Arrays.toString(arr));
        }
    }

}

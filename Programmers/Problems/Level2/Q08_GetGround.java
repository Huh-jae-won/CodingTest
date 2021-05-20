package Level2;

public class Q08_GetGround {
	public static void main(String[] args) {
		Q08_GetGround a = new Q08_GetGround();
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		int ret = a.solution(land);
		System.out.println(ret);
	}
    int solution(int[][] land) {
        int len = land.length;
        int[][] arr = new int[len][4];
        // 첫행
        for(int i=0 ; i<4 ; i++){
            arr[0][i] = land[0][i];
        }
        for(int i=1 ; i<len ; i++){
            for(int j=0 ; j<4 ; j++){
                arr[i][j] = land[i][j] + arr[i-1][findMaxIdx(arr[i-1],j)];
            }
        }
        // System.out.println(Arrays.toString(arr[len-1]));
        int answer = arr[len-1][findMaxIdx(arr[len-1],-1)];
        return answer;
    }
    private int findMaxIdx(int[] arrI, int idx){
        int max = Integer.MIN_VALUE;
        int ret = -1;
        
        for(int i=0 ; i<arrI.length ; i++){
            if(i!=idx && arrI[i]>max){
                max = arrI[i];
                ret = i;
            }
        }
        return ret;
    }
}

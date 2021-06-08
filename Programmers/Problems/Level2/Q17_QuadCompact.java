package Level2;

import java.util.Arrays;

public class Q17_QuadCompact {
	public static void main(String[] args) {
		Q17_QuadCompact a = new Q17_QuadCompact();
		int[][] arr = {
				{1,1,0,0},
				{1,0,0,0},
				{1,0,0,1},
				{1,1,1,1}
		};
		System.out.println(Arrays.toString(a.solution(arr)));
	}
    int zero = 0;
    int one = 0;
    public int[] solution(int[][] arr) {
        int len = arr.length;
        int[] start = {0,0};
        int[] end = {len-1,len-1};
        // System.out.println(Arrays.toString(end));
        QuadCompact(arr,start,end);
        return new int[]{zero,one};
    }
    private void QuadCompact(int[][] arr,int[] start, int[] end){
        int len = end[0]-start[0]+1;
        int half = len/2;
        // System.out.println("in"+Arrays.toString(start)+" "+Arrays.toString(end)+" half "+half);
        if(check(arr,start,end)){
            // 쿼드트리 만족
            int num = arr[start[0]][start[1]];
            // System.out.println("Qu"+Arrays.toString(start)+" "+Arrays.toString(end)+" : "+num);
            if(num==0){
                zero ++;
            }else{
                one ++;
            }
            // System.out.println("z : "+zero+" o : "+one);
            return;
        }
        if(end[0]==start[0] && end[1]==start[1]){
            // System.out.println(Arrays.toString(start)+" "+Arrays.toString(end) +"aaa");
            // len==1
            if(arr[start[0]][start[1]]==1){
                one++;
            }else{
                zero++;
            }
            return;
        }
        // 좌상
        int[] startLU = {start[0],start[1]};
        int[] endLU = {end[0]-half,end[1]-half};
        
        // 우상
        int[] startRU = {start[0],start[1]+half};
        int[] endRU = {end[0]-half,end[1]};

        
        // 좌하
        int[] startLD = {start[0]+half,start[1]};
        int[] endLD = {end[0],end[1]-half};
        
        // 우하
        int[] startRD = {start[0]+half, start[1]+half};
        int[] endRD = {end[0],end[1]};
        
        // System.out.println("LU : "+Arrays.toString(startLU)+Arrays.toString(endLU)+" ");
        QuadCompact(arr,startLU,endLU);
        // System.out.println("RU : "+Arrays.toString(startRU)+Arrays.toString(endRU));
        QuadCompact(arr,startRU,endRU);
        // System.out.println("LD : "+Arrays.toString(startLD)+Arrays.toString(endLD)+" ");
        QuadCompact(arr,startLD,endLD);
        // System.out.println("RD : "+Arrays.toString(startRD)+Arrays.toString(endRD));
        QuadCompact(arr,startRD,endRD);
        // System.out.println("---------------------------------");
        
        
        return;
    }
    
    private boolean check(int[][] arr,int[] start, int[] end){
        // 해당 사각형이 쿼드트리에 만족하는지 체크
        int num = arr[start[0]][start[1]];
        for(int i=start[0] ; i<=end[0] ; i++){
            for(int j=start[1] ; j<=end[1] ; j++){
                if(num!=arr[i][j])
                    return false;
            }
        }
        return true;
    }
    private int sizeOfpart(int[] start, int[] end){
        int len = Math.abs(start[0]-end[0]);
        return len;
    }
}

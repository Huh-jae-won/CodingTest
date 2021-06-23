package Level3;

public class Q46_Triangle {
	public static void main(String[] args) {
		Q46_Triangle z = new Q46_Triangle();
		int[][] triangle= {
				{7},
				{3,8},
				{8,1,0},
				{2,7,4,4},
				{4,5,2,6,5}};
		int ret = z.solution(triangle);
		System.out.println(ret);
	}
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] ret = new int[len][len];
        // for(int i=0 ; i<len ; i++){
        //     System.out.println(Arrays.toString(triangle[i]));
        // }
        ret[0][0] = triangle[0][0];
        for(int i=1 ; i<len ; i++){
            ret[i][0] = ret[i-1][0] + triangle[i][0];
            for(int j=1 ; j<=i ; j++){
                ret[i][j] = Math.max(ret[i-1][j-1],ret[i-1][j])+triangle[i][j];
            }
        }
        // for(int i=0 ; i<len ; i++){
        //     System.out.println(Arrays.toString(ret[i]));
        // }
        int answer = Integer.MIN_VALUE;
        for(int j=0 ; j<len ; j++){
            if(answer<ret[len-1][j])
                answer = ret[len-1][j];
        }
        return answer;
    }
}

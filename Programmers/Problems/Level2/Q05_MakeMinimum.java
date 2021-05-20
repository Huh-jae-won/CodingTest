package Level2;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Q05_MakeMinimum {
	public static void main(String[] args) {
		Q05_MakeMinimum a = new Q05_MakeMinimum();
		int[] A = {1,4,2};
		int[] B = {5,4,4};
		a.solution(A, B);
	}
    public int solution(int []A, int []B)
    {
        int answer1 = 0;
        int answer2 = 0;
        int len = A.length;
        boolean[] AA = new boolean[len];
        boolean[] BB = new boolean[len];
        
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0 ; i<len ; i++){
            answer1 += A[i]*B[len-i-1];
            answer2 += A[len-i-1]*B[i];
        }

        return Math.min(answer1,answer2);
    }
}

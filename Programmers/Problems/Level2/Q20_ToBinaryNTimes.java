package Level2;

import java.util.Arrays;

public class Q20_ToBinaryNTimes {
	public static void main(String[] args) {
		Q20_ToBinaryNTimes a = new Q20_ToBinaryNTimes();
		String s = "110010101001";
		System.out.println(Arrays.toString(a.solution(s)));
	}
    public int[] solution(String s) {
        int cntZero = 0;
        int cnt = 0;
        while(!s.equals("1")){
            int newLen = newLen(s);
            cntZero += (s.length()-newLen);
            cnt++;
            s = Integer.toBinaryString(newLen);
        }
        int[] ret = {cnt,cntZero};
        return ret;
    }
    private int newLen(String s){
        int sum = 0;
        int len = s.length();
        for(int i=0 ; i<len ; i++){
            if(s.charAt(i)=='1')
                sum++;
        }
        return sum;
    }
}

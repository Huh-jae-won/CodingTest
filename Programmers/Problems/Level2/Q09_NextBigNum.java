package Level2;

public class Q09_NextBigNum {
	public static void main(String[] args) {
		Q09_NextBigNum a = new Q09_NextBigNum();
		int n = 78;
		int ret = a.solution(n);
		System.out.println(ret);
	}
	  public int solution(int n) {
	        int cnt = Integer.bitCount(n);
	        int num = n+1;
	        while(true){
	            if(cnt==Integer.bitCount(num))
	                return num;
	            num++;
	        }
	  }
	
}

package Level2;

public class Q07_ExpressionOfNum {
	public static void main(String[] args) {
		Q07_ExpressionOfNum a = new Q07_ExpressionOfNum();
		int n = 15;
		int ret = a.solution(n);
		System.out.println(ret);
	}
    public int solution(int n) {
        int answer = 0;
        for(int i=1 ; i<=n/2 ; i++){
            int sum=0;
            for(int j=i ; j<n ; j++){
                sum += j;
                if(sum==n){
                    // System.out.println(j);
                    answer++;
                    break;
                }
                if(sum>n){
                    break;
                }
            }
        }
        return answer+1;
    }
}

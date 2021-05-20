package Level2;

public class Q04_Fibonacci {
	public static void main(String[] args) {
		Q04_Fibonacci a = new Q04_Fibonacci();
		int n = 10;
		int ret = a.solution(n);
		System.out.println(ret);
	}
    int[] arr;
    public int solution(int n) {
        arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        int answer = fibo(n);
        return answer;
    }
    private int fibo(int n){
        if(n==0){
            return arr[0];
        }
        if(n==1 && n==2){
            return arr[n];
        }
        for(int i=3 ; i<=n ; i++){
            arr[i] = (arr[i-1] + arr[i-2])%1234567;
        }
        return arr[n];
    }
}

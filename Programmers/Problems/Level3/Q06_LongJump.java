package Level3;

public class Q06_LongJump {
	public static void main(String[] args) {
		Q06_LongJump z = new Q06_LongJump();
		int n = 5;
		long ret = z.solution(n);
		System.out.println(ret);
	}
    long div = 1234567L;
    public long solution(int n) {
        long[] arr = new long[n+1];
        if(n<3)
            return n;
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3 ; i<=n ; i++){
            arr[i] = arr[i-2] + arr[i-1];
            arr[i] %= div;
        }
        return arr[n];
    }
}

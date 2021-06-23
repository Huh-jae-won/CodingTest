package Level3;

public class Q31_2nTiling {
	public static void main(String[] args) {
		Q31_2nTiling z = new Q31_2nTiling();
		int n = 4;
		int ret = z.solution(n);
		System.out.println(ret);
	}
    int div = 1000000007;
    int[] arr;
    public int solution(int n) {
        arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2 ; i<=n ; i++){
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] %= div;
        }
        return arr[n];
    }
}

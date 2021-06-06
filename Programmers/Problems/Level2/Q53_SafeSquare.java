package Level2;

public class Q53_SafeSquare {
	public static void main(String[] args) {
		Q53_SafeSquare a = new Q53_SafeSquare();
		int w = 12;
		int h = 8;
		System.out.println(a.solution(w, h));
	}
    public long solution(int w, int h) {
        int GCD = gcd(w,h);
        long ret = ((long)w*h)-(w+h-GCD);
        
        return ret;
    }
    private int gcd(int w, int h){
        while(h!=0){
            int temp = w%h;
            w = h;
            h = temp;
        }
        // System.out.println("gcd : "+w);
        return w;
    }
}

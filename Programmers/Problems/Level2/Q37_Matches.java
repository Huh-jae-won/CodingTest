package Level2;

public class Q37_Matches {
	public static void main(String[] args) {
		Q37_Matches z = new Q37_Matches();
		int n = 4;
		int a = 4;
		int b = 7;
		System.out.println(z.solution(n, a, b));
	}
    public int solution(int n, int a, int b){
        int round = 1;
        // if(Math.abs(a-b)==1 && (a/2!=b/2))
        //     return round;
        while(true){
            if(Math.abs(a-b)==1 && (a/2!=b/2))
                break;
            a = (a+1)/2;
            b = (b+1)/2;
            round++;
            if(a==0)
                a=1;
            if(b==0)
                b=1;
            // System.out.println("R"+round+" : a"+a+", b"+b);
        }
        return round;
    }
}

package Level3;

public class Q12_Palindrome {
	public static void main(String[] args) {
		Q12_Palindrome z = new Q12_Palindrome();
		String s = "abcdcba";
		int ret = z.solution(s);
		System.out.println(ret);
	}
    public int solution(String s){
        int len = s.length();
        int ret = 0;
        for(int x=len ; x>=0 ; x--){
            for(int i=0 ; i<=len-x ; i++){
                if(findPalin(s,i,x)){
                    // System.out.println(s.substring(i,i+x));
                    return x;
                }
            }
        }
        return 0;
    }
    private boolean findPalin(String s, int idx, int len){
        int start = idx;
        int end = idx+len-1;
        // System.out.println(start+"~"+end);
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                // System.out.printf("(%d,%c)(%d,%c)",start,s.charAt(start),end,s.charAt(end));
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

package Level1;

public class Q08_MiddleOfStr {
	public static void main(String[] args) {
		Q08_MiddleOfStr a = new Q08_MiddleOfStr();
		String s = "qwer";
		System.out.println("ret : "+a.solution(s));
	}
    public String solution(String s) {
        int len = s.length();
        if(len%2==1){
            // È¦¼ö
            return s.substring(len/2,len/2+1);
        }else{
            return s.substring(len/2-1,len/2+1);
        }
    }

}

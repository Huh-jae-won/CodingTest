package Level2;

import java.util.Arrays;

public class Q10_NDecimalNum {
	public static void main(String[] args) {
		Q10_NDecimalNum a = new Q10_NDecimalNum();
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 1;
		String ret = a.solution(n, t, m, p);
		System.out.println(ret);
	}
    public String solution(int n, int t, int m, int p) {
        int length = m*t-(m-p);
        // System.out.println("<"+length+">");
        String list = makeNum(n,length);
        StringBuilder ret = new StringBuilder();
        // System.out.println("list : "+list);
        for(int i=0 ; i<length ; i++){
            if(i%m==p-1){
                ret.append(list.charAt(i));
            }
        }
        return ret.toString();
    }
    private String makeNum(int n,int length){
        int num = 1;
        StringBuilder ret = new StringBuilder("0");
        while(ret.length()<=length){
            StringBuilder temp = new StringBuilder();
            int a = num;
            while(a>=n){
                int remainder = a%n;
                if(remainder>=10){
                    temp.insert(0,transform(remainder)+"");
                }else{
                    temp.insert(0,remainder);
                }
                a /= n;
            }
            if(a!=0){
                if(a>=10){
                    temp.insert(0,transform(a)+"");
                }else{
                    temp.insert(0,a);
                }
                
            }
            ret.append(temp);
            num++;
            // System.out.print(temp+" ");
        }
        // System.out.println();
        return ret.toString();
    }
    
    private char transform(int num){
        char ret = 'A';
        return (char)(ret+(num-10));
    }
}

package Level2;

public class Q02_JadenCase {
	public static void main(String[] args) {
		Q02_JadenCase a = new Q02_JadenCase();
		String s = "3people unFollowed me";
		String ret = a.solution(s);
		System.out.println(ret);
	}
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        if(inRange(s.charAt(0))){
            answer.append(s.substring(0,1).toUpperCase());
        }else{
            answer.append(s.charAt(0));
        }
        for(int i=1 ; i<s.length() ; i++){
            if(s.charAt(i-1)==' ' ){
//              앞이 빈칸인 경우
                if(inRange(s.charAt(i))){
//                  알파벳인경우
                    answer.append(s.substring(i,i+1).toUpperCase());
                }else{
                    answer.append(s.charAt(i));
                }
            }else{
                if(inRange(s.charAt(i))){
//                  알파벳인경우
                    answer.append(s.substring(i,i+1).toLowerCase());
                }else{
                    answer.append(s.charAt(i));
                }
            }
        }
        return answer.toString();
    }
    private boolean inRange(char ch){
        if((ch>=65 && ch<=90)||(ch>=97 && ch<=122))
            return true;
        return false;
    }
}

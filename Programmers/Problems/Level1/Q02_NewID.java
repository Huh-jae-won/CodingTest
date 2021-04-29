package Level1;

public class Q02_NewID {
	public static void main(String[] args) {
		Q02_NewID a = new Q02_NewID();
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		System.out.println("ret : "+a.id(new_id));
	}
	public String id(String new_id) {
		String step1 = step1(new_id);
        String step2 = step2(step1);
        String step345 = step345(step2);
        String step6 = step6(step345);
        String step7 = step7(step6);
        return step7;
    }
    private String step1(String new_id){
        return new_id.toLowerCase();
    }
    private String step2(String step1){
        StringBuilder sb = new StringBuilder();
        for(char ch : step1.toCharArray()){
            // a~z : 97~122, 0~9 : 48~57
            if(ch>=48&&ch<=57 || ch>=97&&ch<=122 || ch=='-' || ch=='_' || ch=='.'){
                sb.append(ch);   
                // System.out.print(ch+" ");
            }
        }
                // System.out.println("Step2 : "+sb.toString());
        return sb.toString();
    }
    private String step345(String step2){
        StringBuilder sb = new StringBuilder();
        sb.append(step2.charAt(0));
        int len = step2.length();
        for(int i=1 ; i<len ; i++){
            if(step2.charAt(i)!='.'){
                sb.append(step2.charAt(i));   
            }else{
                if(step2.charAt(i-1)!='.')
                    sb.append(step2.charAt(i));
            }
        }
        if(sb.charAt(0)=='.'){
            sb.delete(0,1);
        }
        if(sb.length()>0){
            if(sb.charAt(sb.length()-1)=='.'){
                int length = sb.length();
                sb.delete(length-1,length);
            }
        }
        // System.out.println("Step345 : "+sb.toString());
        if(sb.length()==0){
            sb.append('a');
        }
        return sb.toString();
    }
    private String step6(String step5){
        StringBuilder sb;
        if(step5.length()>15){
            sb = new StringBuilder(step5.substring(0,15));
            
            if(sb.charAt(0)=='.'){
                sb.delete(0,1);
            }
            if(sb.length()>0){
                if(sb.charAt(sb.length()-1)=='.'){
                    int length = sb.length();
                    sb.delete(length-1,length);
                }
            }
            // System.out.println("step6 : "+sb);
            return sb.toString();
        }else{
            return step5;
        }
    }
    private String step7(String step6){
        StringBuilder sb = new StringBuilder(step6);
        int len = sb.length();
        if(len<3){
            char ch = sb.charAt(len-1);
            while(sb.length()<3){
                sb.append(ch);
            }
        }
        // System.out.println("Step7 : "+sb);
        return sb.toString();
    }
}

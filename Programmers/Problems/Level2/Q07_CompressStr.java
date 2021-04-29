package Level2;

public class Q07_CompressStr {

	public static void main(String[] args) {
		Q07_CompressStr a = new Q07_CompressStr();
		String str = "ababcdcdababcdcd";
//		String str = "abcabcdede";
//		String str = "abcabcabcabcdededededede";
//		String str = "xababcdcdababcdcd";
		System.out.println(a.compress(str));
	}
    public int compress(String s) {
        int len = s.length();
        int ret = len;
        for(int i=1 ; i<=len/2 ; i++){
            // int temp = cuttingStr(s,i);
            String temp = cuttingStr(s,i);
            // System.out.printf("cut: %d, word: %s\n",i,temp);
            ret = Math.min(ret,temp.length());
        }
        return ret;
    }
    private String cuttingStr(String str,int cut){
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        int indx=0;
        while(indx<len-cut+1){
            String unit = str.substring(indx,indx+cut);
            int count = findStr(str,unit,indx+cut);
            // System.out.println(unit+", count: "+count);
            if(count==0){
                sb.append(unit);
                indx+=cut;
            }else{
                sb.append(count+1);
                sb.append(unit);
                indx += (count+1)*cut;
            }
        }
        for(int i=indx ; i<str.length() ; i++){
            sb.append(str.charAt(i));
        }
        // System.out.println("indx: "+indx);
        return sb.toString();
    }
    
    private int findStr(String str,String unit,int start){
        int len = str.length();
        int cut = unit.length();
        int indx = start;
        int ret = 0;
        while(indx<len-unit.length()+1){
            if(unit.equals(str.substring(indx,indx+cut))){
                ret++;
                indx += cut;
            }else{
                break;
            }
        }
        return ret;
    }

}

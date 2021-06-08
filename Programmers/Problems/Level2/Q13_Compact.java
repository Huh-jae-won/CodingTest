package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q13_Compact {
	public static void main(String[] args) {
		Q13_Compact a = new Q13_Compact();
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		a.solution(msg);
	}
	 List<String> idx;
    public int[] solution(String msg) {
        idx = new ArrayList<>();
        idx.add("");
        List<Integer> ret = new ArrayList<>();
        for(char ch='A' ; ch<='Z' ; ch++){
            idx.add(String.valueOf(ch));
        }
        // System.out.println(idx);
        // System.out.println(idx.size());
        int len = msg.length();
        int last = -1;
        for(int i=0 ; i<len ; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));
            int num = idx.indexOf(sb.toString());
            last = i;
//            System.out.println("msg, "+i+" : "+msg.substring(0,i)+"\""+msg.charAt(i)+"\""+msg.substring(i+1));
            
            for(int j=i+1 ; j<len ; j++){
                sb.append(msg.charAt(j));
                if(idx.contains(sb.toString())){
                    // idx에 단어가 있음
                    num = idx.indexOf(sb.toString());
                    if(j==msg.length()-1) {
                    	// 마지막 일 경우
                    	i=j+1;
                    	ret.add(num);
                    }
                    continue;
                }else{
                    // idx에 단어가 없음
                    idx.add(sb.toString());
                    i = j-1;
                    ret.add(num);
                    break;
                }
            }
        if(i==msg.length()-1){
            String str = msg.substring(i);
            ret.add(idx.indexOf(str));
        }
//            printIdx();
//            System.out.println(ret);
//            System.out.println();
        }
//        System.out.println("ret : "+ret);
        int[] arr = toArr(ret);
//        System.out.println(Arrays.toString(arr));
        return arr;
    }
    private int[] toArr(List<Integer> ret) {
    	int[] result = new int[ret.size()];
    	for(int i=0 ; i<ret.size() ; i++) {
    		result[i] = ret.get(i);
    	}
    	return result;
    }
    private void printIdx(){
        System.out.print("[");
        for(int i=27 ; i<idx.size() ; i++){
            System.out.print(idx.get(i)+" ");
        }
        System.out.println("]");
    }
}

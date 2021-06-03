package Level2;

import java.util.Arrays;
import java.util.Comparator;

public class Q12_FIleSorting {
	public static void main(String[] args) {
		Q12_FIleSorting a = new Q12_FIleSorting();
		String[] files = {"foo9.txt","foo010bar020.zip","F-15"};
		a.solution(files);
		System.out.println(Arrays.toString(files));
	}
	public String[] solution(String[] files) {
        int len = files.length;
        String[] ret;
        String[][] file_HNT = new String[files.length][3];
        for(int i=0 ; i<files.length ; i++){
            file_HNT[i] = HNT(files[i]);
        }
        // printFile(file_HNT);
        // System.out.println("--------------------------------------------");
        Arrays.sort(file_HNT,comp);
//        printFile(file_HNT);
        ret = makeRet(file_HNT);
        System.out.println(Arrays.toString(ret));
        return ret;
    }
    Comparator<String[]> comp = new Comparator<String[]>(){
      public int compare(String[] s1, String[] s2){
          int com0 = s1[0].compareToIgnoreCase(s2[0]);
          int com1 = Integer.parseInt(s1[1])-Integer.parseInt(s2[1]);
          if(com0!=0){
              // head가 다른경우
              return com0;
          }
          if(com1!=0){
              // nums가 다른경우
              return com1;
          }
          // 원래순서대로 출력
          return 1;
      }  
    };
    private String[] HNT(String s){
        StringBuilder head = new StringBuilder();
        StringBuilder nums = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        int[] start = new int[3];
        start[0] = 0;
        for(int i=0 ; i<s.length() ; i++){
            if(inRange(s.charAt(i))){
                // 숫자인 경우
                start[1] = i;
                break;
            }
            head.append(s.charAt(i));
        }
        
        for(int i=start[1] ; i<s.length() ; i++){
            if(!inRange(s.charAt(i))){
                // 숫자가 아닌경우
                start[2] = i;
                break;
            }
            nums.append(s.charAt(i));
        }
        if(start[2]!=0)
        	tail.append(s.substring(start[2]));
        // System.out.print(head+", ");
        // System.out.print(nums+", ");
        // System.out.println(tail);
        return new String[] {head.toString(),nums.toString(),tail.toString()};
    }
    private boolean inRange(char ch){
        if(ch>='0' && ch<='9')
            return true;
        return false;
    }
    
    private String[] makeRet(String[][] file_HNT){
        int len = file_HNT.length;
        String[] ret = new String[len];
        for(int i=0 ; i<len ; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(file_HNT[i][0]);
            sb.append(file_HNT[i][1]);
            sb.append(file_HNT[i][2]);
            ret[i] = sb.toString();
        }
        return ret;
    }
    
    private void printFile(String[][] file_HNT){
        for(int i=0 ; i<file_HNT.length ; i++){
            System.out.printf("%s, %s, %s\n",file_HNT[i][0],file_HNT[i][1],file_HNT[i][2]);
        }
    }
}

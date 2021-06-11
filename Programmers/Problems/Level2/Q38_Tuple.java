package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q38_Tuple {
	public static void main(String[] args) {
		Q38_Tuple a = new Q38_Tuple();
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(Arrays.toString(a.solution(s)));
	}
    public int[] solution(String s) {
        List<int[]> list = makeIntArr(s);
        list.sort(comp);
        for(int i=0 ; i<list.size() ; i++){
            Arrays.sort(list.get(i));
        }
        // printList(list);
        
        return makeTuple(list);
    }
    private int[] makeTuple(List<int[]> list){
        int len = list.size();
        int[] ret = new int[len];
        ret[0] = list.get(0)[0];
        for(int i=1 ; i<len ; i++){
            int[] arrBef = list.get(i-1);
            int[] arrCur = list.get(i);
            for(int j=0 ; j<arrCur.length ; j++){
                boolean same = false;
                int num = arrCur[j];
                for(int k=0 ; k<arrBef.length ; k++){
                    if(num==arrBef[k]){
                        same = true;
                        break;
                    }
                }
                if(!same){
                    ret[i] = num;
                    break;
                }
            }
        }
        // System.out.println("ret"+Arrays.toString(ret));
        return ret;
    }
    private int findNum(int[] a, int[] b){
        
        return 0;
    }
    
    private List<int[]> makeIntArr(String s){
        List<int[]> list = new ArrayList<>();
        s = s.substring(1,s.length()-1);
        // System.out.println(s);
        int start = 0;
        int end = 0;
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i)=='{'){
                start = i;
                continue;
            }
            if(s.charAt(i)=='}'){
                end = i;
                String temp[] = s.substring(start+1,end).split(",");
                int[] arr = new int[temp.length];
                for(int j=0 ; j<temp.length ; j++){
                    arr[j] = Integer.parseInt(temp[j]);
                }
                list.add(arr);
            }
        }
        return list;
    }
    
    Comparator<int[]> comp = new Comparator<int[]>(){
        public int compare(int[] a, int[] b){
            return a.length-b.length;
        }
    };
    
    private void printList(List<int[]> list){
        for(int[] arr : list)
            System.out.println(Arrays.toString(arr));
    }
}

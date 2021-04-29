package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q09_NotSameNum {
	public static void main(String[] args) {
		Q09_NotSameNum a = new Q09_NotSameNum();
		int[] arr = {1,1,3,3,0,1,1};
		a.notSame(arr);
	}
	public int[] notSame(int[] arr) { 
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int n : arr){
            if(list.get(list.size()-1)!=n)
                list.add(n);
        }
        int[] ret = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

}

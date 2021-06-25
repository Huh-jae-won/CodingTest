package Level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q40_JewelShopping {
	public static void main(String[] args) {
		Q40_JewelShopping z = new Q40_JewelShopping();
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] ret = z.solution(gems);
		System.out.println(Arrays.toString(ret));
	}
    public int[] solution(String[] gems) {
        Set<String> keySet = new HashSet<>();
        for(String gem : gems)
            keySet.add(gem);
        int gemCnt = keySet.size();
        
        int start = 0;
        int end = 0;
        int[] ret = new int[2];
        int len = Integer.MAX_VALUE;
        Map<String,Integer> map = new HashMap<>();
        map.put(gems[0],1);
        while(end<gems.length && start<gems.length){
            if(map.size()==gemCnt){
                if(end-start<len){
                    len = end-start;
                    ret[0] = start+1;
                    ret[1] = end+1;
                }
                if(map.get(gems[start])==1){
                    map.remove(gems[start]);
                }else{
                    map.put(gems[start],map.get(gems[start])-1);
                }
                start++;
            }else{
                end++;
                if(end==gems.length)
                	continue;
                map.put(gems[end],map.getOrDefault(gems[end],0)+1);
            }
        }
        return ret;
    }
}

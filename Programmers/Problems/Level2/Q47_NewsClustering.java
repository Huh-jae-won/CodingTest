package Level2;

import java.util.HashMap;
import java.util.Map;

public class Q47_NewsClustering {
	public static void main(String[] args) {
		Q47_NewsClustering z = new Q47_NewsClustering();
		String str1 = "FRANCE";
		String str2 = "french";
		int ret = z.solution(str1, str2);
		System.out.println(ret);
	}
    public int solution(String str1, String str2) {
        Map<String,Integer> map1 = makeMap(str1);
        Map<String,Integer> map2 = makeMap(str2);
        Map<String,Integer> Union;
        int ret = makeUnion(map1,map2);
        return ret;
    }
    private int makeUnion(Map<String,Integer>map1, Map<String,Integer>map2){
        Map<String,Integer> union = new HashMap<>();
        
        int len1 = map1.size();
        int len2 = map2.size();
        
        int uni = 0;
        int inter = 0;
        for(String str : map1.keySet()){
            union.put(str,map1.get(str));
        }
        for(String str : map2.keySet()){
            // union에 있으면 map2와 union 중 큰거, 없으면 그냥 추가
            if(union.containsKey(str)){
                union.put(str,Math.max(union.get(str),map2.get(str)));
            }else{
                union.put(str,map2.get(str));
            }
            if(map1.containsKey(str)){
                inter += Math.min(map1.get(str),map2.get(str));
            }
        }
        for(int num : union.values()){
            uni += num;
        }
        System.out.println(uni+", "+inter);
        double ret = 0.0;
        if(uni==0 && inter==0){
            ret = 1*65536;
        }else{
            ret = (inter+0.0)/uni *65536;
        }
        // System.out.println(ret);
        return (int) ret;
    }
    
    private Map<String,Integer> makeMap(String str){
        Map<String,Integer> map  = new HashMap<>();
        int len = str.length();
        for(int i=0 ; i<len-1 ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i ; j<i+2 ; j++){
                char ch = str.charAt(j);
                if( !inRange(ch) ){
                    break;
                }
                sb.append(ch);
            }
            if(sb.length()==2){
                String s = sb.toString().toLowerCase();
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        // System.out.println(map);
        return map;
    }
    private boolean inRange(char ch){
        if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
            return true;
        return false;
    }
}

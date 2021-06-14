package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q41_MenuRenewal {
	public static void main(String[] args) {
		Q41_MenuRenewal z = new Q41_MenuRenewal();
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		String[] ret = z.solution(orders, course);
		System.out.println(Arrays.toString(ret));
	}
    public String[] solution(String[] orders, int[] course) {
        // List<char[]> orderList = makeOrderList(orders);
        Map<char[],Integer> map = new HashMap<>();
        int[] maxCnt = new int[11];
        for(int i=0 ; i<orders.length ; i++){
            for(int j=0 ; j<course.length ; j++){
                if(orders[i].length()>=course[j]){
                    dfs(map,orders[i],maxCnt,course[j],0,-1,"");
                }
            }
        }
        // printMap(map);
        // System.out.println(Arrays.toString(maxCnt));
        String[] ret = makeReturn(map,maxCnt);
        // System.out.println(Arrays.toString(ret));
        return ret;
    }
    private String[] makeReturn(Map<char[],Integer> map, int[] maxCnt){
        List<String> list = new ArrayList<>();
        for(char[] key : map.keySet()){
            int len = key.length;
            if(maxCnt[len] == map.get(key)){
                StringBuilder sb = new StringBuilder();
                for(int i=0 ; i<len ; i++){
                    sb.append(key[i]);
                }
                list.add(sb.toString());
            }
        }
        String[] ret = new String[list.size()];
        for(int i=0 ; i<list.size() ; i++){
            ret[i] = list.get(i);
        }
        Arrays.sort(ret);
        return ret;
    }
    
    private void dfs(Map<char[],Integer> map,String order, int[] maxCnt ,int len, int dep, int befo,String str){
        if(len==dep){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            // System.out.println(str+" -> "+Arrays.toString(arr));
            putIntoMap(map,arr,maxCnt);
            return;
        }
        for(int i=befo+1 ; i<order.length() ; i++){
            dfs(map,order,maxCnt,len,dep+1,i,str+order.charAt(i));
        }
    }
    private void putIntoMap(Map<char[],Integer> map,char[] arr,int[] maxCnt){
        int len = arr.length;
        boolean flag = false;
        for(char[] key : map.keySet()){
            if(Arrays.equals(key,arr)){
                map.put(key,map.get(key)+1);
                maxCnt[len] = Math.max(maxCnt[len], map.get(key));
                flag = true;
                return;
            }
        }
        if(!flag){
            // 없을경우
            map.put(arr,1);
        }
        return;
    }

    private void printMap(Map<char[],Integer> map){
        for(char[] arr : map.keySet()){
            if(map.get(arr)>1)
                System.out.println(Arrays.toString(arr)+" : "+map.get(arr));
        }
    }
}

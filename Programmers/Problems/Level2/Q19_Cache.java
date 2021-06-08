package Level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q19_Cache {
	public static void main(String[] args) {
		Q19_Cache a = new Q19_Cache();
		int cacheSize = 3;
		String[] cities = {
				"Jeju", "Pangyo", "Seoul", "NewYork", "LA", 
				"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		a.solution(cacheSize, cities);
	}
    class Node{
        String city;
        int time;
        public Node(String city, int time){
            this.city = city;
            this.time = time;
        }
        public String toString(){
            return "["+city+","+time+"]";
        }
    }
    public int solution(int cacheSize, String[] cities) {
        List<Node> cache = new ArrayList<>();
        int len = cities.length;
        int ret = 0;
        for(int i=0 ; i<len ; i++){
            if(checkCache(cache,cities[i],cacheSize,i)){
                // hit
                ret++;
            }else{
                ret += 5;
            }
            // System.out.println(cache);
        }
        
        return ret;
    }
    private boolean checkCache(List<Node> cache, String city, int cacheSize, int curTime){
        for(int i=0 ; i<cache.size() ; i++){
            Node node = cache.get(i);
            if(node.city.equalsIgnoreCase(city)){
                // cache hit
                node.time = curTime;
                cache.sort(comp);
                // System.out.print("HIT");
                return true;
            }
        }
        // cache miss
        // System.out.print("MIS");
        if(cacheSize!=0){
            if(cache.size()>=cacheSize){
                cache.remove(0);
            }
        cache.add(new Node(city,curTime));
        }
        return false;

    }
    Comparator<Node> comp = new Comparator<Node>(){
        public int compare(Node a, Node b){
            return a.time-b.time;
        }
    };
}

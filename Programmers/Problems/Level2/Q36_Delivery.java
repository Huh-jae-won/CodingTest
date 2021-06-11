package Level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q36_Delivery {
	public static void main(String[] args) {
	Q36_Delivery z = new Q36_Delivery();
	int N = 6;
	int K = 4;
	int[][] road = {
			{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}
	};
	z.solution(N, road, K);
	}
    class Node{
        int cur;
        int length;
        public Node(int cur, int length){
            this.cur = cur;
            this.length = length;
        }
        public String toString(){
            return "["+cur+", "+length+"]";
        }
    }
    List<Node> ret;
    public int solution(int N, int[][] road, int K) {
        ret = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1,0));
        bfs(q,road,K);
        System.out.println(ret);
        return ret.size();
    }
    private void bfs(Queue<Node> q, int[][]road, int K){
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                Node node = q.poll();
                if(node.length<=K){
                    // 거리가 K 이하면 ret에 추가
                    if(chkRet(node)){
                        // System.out.println(node);
                        for(int j=0 ; j<road.length ; j++){
                            int nPos = chkRoad(road[j],node);
                            if(nPos!=-1){
                                q.offer(new Node(nPos,node.length+road[j][2]));
                            }
                        }
                    }
                }
            }
        }
        
    }
    private boolean chkRet(Node node){
        boolean flag = false;
        for(int i=0 ; i<ret.size() ; i++){
            Node temp = ret.get(i);
            if(temp.cur==node.cur){
                // 같은 지점이 있는지 확인
                if(ret.get(i).length<=node.length){
                    return false;
                }
                ret.get(i).length = node.length;
                return true;
            }
        }
        // 없으면 추가
        ret.add(node);
        return true;
    }

    private int chkRoad(int[] r, Node node){
        int cur = node.cur;
        if(r[0]==cur)
            return r[1];
        if(r[1]==cur)
            return r[0];
        return -1;
    }
}

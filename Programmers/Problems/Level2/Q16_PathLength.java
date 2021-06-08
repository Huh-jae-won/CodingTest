package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q16_PathLength {
	public static void main(String[] args) {
		Q16_PathLength a = new Q16_PathLength();
		String input = "ULURRDLLU";
		System.out.println(a.solution(input));
	}
    class Path{
        int[] pos1;
        int[] pos2;
        public Path(int[] pos1, int[] pos2){
            this.pos1 = pos1;
            this.pos2 = pos2;
        }
        
        public boolean equals(Object o ) {
        	if(o!=null && o instanceof Path) {
        		int n1 = Arrays.compare(this.pos1,((Path)o).pos1);
        		int n2 = Arrays.compare(this.pos2,((Path)o).pos2);
        		if(n1==0 && n2==0)
        			return true;
        		n1 = Arrays.compare(this.pos2,((Path)o).pos1);
        		n2 = Arrays.compare(this.pos1,((Path)o).pos2);
        		if(n1==0 && n2==0)
        			return true;
        	}
			return false;
        }
        
        public String toString(){
            return "["+Arrays.toString(pos1)+"->"+Arrays.toString(pos2)+"]";
        }
    }
    int[][] dirs = {
//         상,   하,      좌,   우
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    public int solution(String input) {
        Map<Character,Integer> map = new HashMap<>();
        List<Path> list = new ArrayList<>();
        map.put('U',0);
        map.put('D',1);
        map.put('L',2);
        map.put('R',3);
        int[] curPos = new int[2];
        curPos[0] = 0;
        curPos[1] = 0;
        int cnt = 0;
        for(int i=0 ; i<input.length() ; i++){
            int dirIdx = map.get(input.charAt(i));
            int[] nPos = new int[2];    // 다음 칸
            nPos[0] = curPos[0] + dirs[dirIdx][0];
            nPos[1] = curPos[1] + dirs[dirIdx][1];
            if(!inRange(nPos)){
                continue;
            }
            Path p = new Path(curPos,nPos);
            // 있는지 조회
            if(!alreadyPath(list,p)){
                // System.out.println(i+", ");
                cnt++;
            }
            
            list.add(p);
            curPos = null;
            curPos = new int[]{nPos[0],nPos[1]};
        }
        // System.out.println(list);
        // System.out.println(cnt);
        
        return cnt;
    }
    private boolean alreadyPath(List<Path> list, Path p){
        for(int i=0 ; i<list.size() ; i++){
            Path past = list.get(i);
            if(past.equals(p))
                return true;    // 이미 지나온 길
        }
        return false;   // 처음 온 길
    }
    private boolean inRange(int[] pos){
        if(pos[0]>=-5 && pos[0]<=5 && pos[1]>=-5 && pos[1]<=5)
            return true;
        return false;
    }
}

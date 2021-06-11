package Level2;

import java.util.Arrays;

public class Q39_Joystick {
	public static void main(String[] args) {
		Q39_Joystick a = new Q39_Joystick();
		String name = "JAN";
		a.solution(name);
	}
    public int solution(String name) {
        int len = name.length();
        int ret = 0;
        int[] cnt = new int[len];
        boolean[] visited = new boolean[len];
        
        for(int i=0 ; i<len ; i++){
            int num1 = Math.abs(name.charAt(i)-'A');
            int num2 = Math.abs(name.charAt(i)-'Z');
            cnt[i] = Math.min(num1,num2+1);
            if(cnt[i]==0)
                visited[i] = true;
        }
        System.out.println(Arrays.toString(cnt));
        int curIdx = 0;
        int dist = 0;
        int nIdx = 0;
        while(true){
            visited[curIdx] = true;
            ret += dist;
            ret += cnt[curIdx];
            int[] arr = shortestPath(curIdx,visited);
            
            if(arr==null)
                break;
            dist = arr[1];
            curIdx = arr[0];
        }
        return ret;
    }
    private int[] shortestPath(int curPos, boolean[] visited){
        int len = visited.length;
        int rPos = curPos;
        int rTime = 0;
        // right move
        while(true){
            rTime++;
            rPos++;
            if(rPos>=len)
                rPos = 0;
            if(!visited[rPos]){
                break;
            }
            if(allTrue(visited))
                return null;
        }
        
        int lPos = curPos;
        int lTime = 0;
        // left move
        while(true){
            lTime++;
            lPos--;
            if(lPos<0)
                lPos = len-1;
            if(!visited[lPos]){
                break;
            }
            if(allTrue(visited))
                return null;
        }
        if(lTime<rTime){
            // System.out.println("L : "+curPos+"->"+lPos+" : "+lTime);
            return new int[]{lPos,lTime};
        }
        // System.out.println("R : "+curPos+"->"+rPos+" :"+rTime);
        return new int[]{rPos,rTime};
        
    }
    
    private boolean allTrue(boolean[] visited){
        for(int i=0 ; i<visited.length ; i++){
            if(!visited[i])
                return false;
        }
        return true;
    }
}

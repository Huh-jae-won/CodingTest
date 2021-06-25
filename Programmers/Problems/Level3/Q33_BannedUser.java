package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q33_BannedUser {
	public static void main(String[] args) {
		Q33_BannedUser z = new Q33_BannedUser();
		
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		System.out.println(Arrays.toString(banned_id));
		int ret = z.solution(user_id, banned_id );
		System.out.println(ret);
	}
    int ret = 0;
    public int solution(String[] user_id, String[] banned_id) {
        ret = 0;
        boolean[] userVisited = new boolean[user_id.length];
        List<List<String>> list = new ArrayList<>();
        dfs(list,user_id,banned_id,userVisited,0,"");
        return ret;
    }
    private void dfs(List<List<String>> list,String[] user_id, String[] banned_id, boolean[] visited, int dep,String log){
        if(dep==banned_id.length){
            List<String> smallList = Arrays.asList(log.split("->"));
            if(!isContain(list,smallList)){
                 System.out.println(log);
                list.add(smallList);
                ret++;
            }else{
                // System.out.println("else : "+smallList);
            }
            return;
        }
        String regex = banned_id[dep].replace("*",".");
        // System.out.println("reg"+dep+" : "+regex);
        for(int i=0 ; i<user_id.length ; i++){
            if(!visited[i] && user_id[i].matches(regex)){                    
                visited[i] = true;
                dfs(list,user_id,banned_id,visited,dep+1,log+user_id[i]+"->");
                visited[i] = false;
            }
        }
    }
    private boolean isContain(List<List<String>> list, List<String> smallList){
        for(List<String>comp : list){
            if(comp.containsAll(smallList) && smallList.containsAll(comp)){
                // 둘다 true : 같은 리스트
                return true;
            }
        }
        return false;
    }
}

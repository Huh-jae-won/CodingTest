package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Q57_OpenChat {
	public static void main(String[] args) {
		Q57_OpenChat z = new Q57_OpenChat();
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] ret = z.solution(record);
		for(String str : ret) {
			System.out.println(str);
		}
	}
    public String[] solution(String[] record) {
        Map<String,String> userMap = new HashMap<>();
        
        List<String> log = doMethod(userMap,record);
        String[] ret = new String[log.size()];
        for(int i=0 ; i<ret.length ; i++){
            StringTokenizer st = new StringTokenizer(log.get(i));
            if(st.nextToken().equals("Enter")){
                String id = st.nextToken();
                ret[i] = userMap.get(id)+"님이 들어왔습니다.";
            }else{
                String id = st.nextToken();
                ret[i] = userMap.get(id)+"님이 나갔습니다.";
            }
        }
        
        return ret;
    }
    private List<String> doMethod(Map<String,String> userMap, String[] record){
        List<String> log = new ArrayList<>();
        for(String str : record){
            StringTokenizer st = new StringTokenizer(str);
            String method = st.nextToken();
            String id = st.nextToken();
            switch(method){
                case "Change" :
                    String nickname = st.nextToken();
                    userMap.put("!"+id+"!",nickname);
                    break;
                case "Enter" :
                    nickname = st.nextToken();
                    userMap.put("!"+id+"!",nickname);
                    log.add(method+" !"+id+"!");
                    break;
                case "Leave" :
                    log.add(method+" !"+id+"!");
                    break;
                default :
                    break;
            }
        }
        return log;
    }
}


package Level2;

import java.util.HashMap;
import java.util.Map;

public class Q18_SkillTree {
	public static void main(String[] args) {
		Q18_SkillTree a = new Q18_SkillTree();
		String skill = "CBD";
		String[] skill_trees = {"BACDE","CBADF","AECB","BDA"};
		System.out.println(a.solution(skill, skill_trees));
	}
    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        boolean[] leadingSkill;
        for(int i=0 ; i<skill.length() ; i++){
            map.put(skill.charAt(i),i);
        }
        System.out.println(map);
        for(String str : skill_trees){
            boolean success = true;
            leadingSkill = new boolean[skill.length()];
            for(int i=0 ; i<str.length() ; i++){
                char ch = str.charAt(i);
                if(map.get(ch)==null){
                    // 스킬 순서 상관없는 스킬인 경우
                    continue;
                }else{
                    // 스킬 순서 상관있는 스킬인 경우
                    int idx = map.get(ch);
                    if(checkLeadingSkill(leadingSkill,idx)){
                        leadingSkill[idx] = true;
                    }else{
                        success = false;
                        break;
                    }
                }
            }
            if(success){
                answer++;
            }
        }
        return answer;
    }
    private boolean checkLeadingSkill(boolean[] leadingSkill, int idx){
        if(idx==0)
            return true;
        for(int i=idx-1 ; i>=0 ; i--){
            if(!leadingSkill[i])
                return false;
        }
        return true;
    }
}

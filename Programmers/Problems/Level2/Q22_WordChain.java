package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q22_WordChain {
	public static void main(String[] args) {
		Q22_WordChain a = new Q22_WordChain();
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", 
				"land", "dream", "mother", "robot", "tank"};
		int[] ret = a.solution(n, words);
		System.out.println(Arrays.toString(ret));
	}
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        int turn = 0;
        int cnt = 0;
        for(int i=0 ; i<words.length ; i++){
            if(list.contains(words[i])){
                // 같은 단어
                cnt =(i/n)+1;
                break;
            }
            if(!chk(list,words[i])){
                cnt = (i/n)+1;
                break;
            }
            list.add(words[i]);
            turn = (turn+1)%n;
        }
        if(cnt==0)
            turn = -1;
        int[] ret = {turn+1,cnt};
        return ret;
    }
    private boolean chk(List<String> list,String word){
        if(list.size()==0)
            return true;
        String lastWord = list.get(list.size()-1);
        return lastWord.charAt(lastWord.length()-1)==word.charAt(0);
    }
}

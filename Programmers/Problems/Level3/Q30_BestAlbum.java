package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30_BestAlbum {
	public static void main(String[] args) {
		Q30_BestAlbum z = new Q30_BestAlbum();
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int[] ret = z.solution(genres, plays);
		System.out.println(Arrays.toString(ret));
	}
    class Music implements Comparable<Music>{
        String genre;
        int play;
        int idx;
        public Music(String genre, int play, int idx){
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
        public int compareTo(Music m){
            if(this.play!=m.play)
                return this.play-m.play;
            return this.idx-m.idx;
        }
        public String toString(){
            return "["+genre+","+play+","+idx+"]";
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> map = new HashMap<>();
        
        // musicList 생성
        List<Music> musicList = new ArrayList<>();
        for(int i=0 ; i<genres.length ; i++){
            musicList.add(new Music(genres[i],plays[i],i));
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }
        
        Collections.sort(musicList,new Comparator<Music>(){
            public int compare(Music m1, Music m2){
                if(map.get(m1.genre)==map.get(m2.genre)){
                    // 이름이 같다면
                    if(m1.play==m2.play){
                        // play수가 같으면 index가 작은순으로(오름차순) return
                        return m1.idx-m2.idx;
                    }else{
                        // play에 따라서 내림차순으로 return
                        return m2.play-m1.play;
                    }
                }else{
                    // 이름이 다르면 각 장르의 play수를 내림차순으로 return
                    return map.get(m2.genre)-map.get(m1.genre);
                }
            }
        });
        
        List<Integer> retList = new ArrayList<>();
        Map<String,Integer> retMap = new HashMap<>();
        
        for(int i=0 ; i<musicList.size() ; i++){
            String genre = musicList.get(i).genre;
            if(retMap.get(genre)==null || retMap.get(genre)<2){
                retList.add(musicList.get(i).idx);
                retMap.put(genre,retMap.getOrDefault(genre,0)+1);
            }else{
                continue;
            }
        }
        int[] ret = new int[retList.size()];
        for(int i=0 ; i<ret.length ; i++){
            ret[i] = retList.get(i);
        }
        return ret;
    }
}

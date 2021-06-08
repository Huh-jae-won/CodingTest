package Level2;

import java.util.ArrayList;
import java.util.List;

public class Q15_SongName {
	public static void main(String[] args) {
		Q15_SongName a = new Q15_SongName();
		String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		String m = "CC#BCC#BCC#BCC#B"	;
		System.out.println(a.solution(m, musicinfos));
	}
    public String solution(String m, String[] musicinfos) {
        int len = musicinfos.length;
        String[][] music = new String[len][4];
        for(int i=0 ; i<musicinfos.length ; i++){
            music[i] = musicinfos[i].split(",");
        }
        // music : 시작,종료,제목,음계
        // printArr(music);
        // System.out.println();
        
        String[] playingMusic = new String[music.length];
        for(int i=0 ; i<music.length ; i++){
            playingMusic[i] = makeMusic(music[i]);
        }
        // System.out.println(Arrays.toString(playingMusic));
        int ret = findMusic(playingMusic,m);
        if(ret==-1)
            return "(None)";
        return music[ret][2];
    }
    private int findMusic(String[] playingMusic,String m){
        List<Integer> list = new ArrayList<>();
        int ret = -1;
        int len = m.length();
        for(int i=0 ; i<playingMusic.length ; i++){
            if(m.length()>playingMusic[i].length())
                continue;
            for(int j=0 ; j<playingMusic[i].length()-len+1 ; j++)
            // System.out.println(playingMusic[j].charAt(j+len));
            if(playingMusic[i].substring(j,j+len).equals(m) ){
                if((j+len==playingMusic[i].length()) || playingMusic[i].charAt(j+len)!='#'){
                    if(ret==-1){
                        ret = i;
                    }else{
                        if(playingMusic[ret].length()<playingMusic[i].length()){
                            ret = i;
                        }
                    }
                }
            }
        }
        return ret;
    }
    
    private String makeMusic(String[] music){
        int playtime = playTime(music[0], music[1]);
        StringBuilder sb = new StringBuilder();
        
        // 음계를 list에
        List<String> list = new ArrayList<>();
        for(int i=0 ; i<music[3].length() ; i++){
            if(inRangeScale(music[3],i)){
                list.add(music[3].substring(i,i+2));
                i++;
            }else{
                list.add(String.valueOf(music[3].charAt(i)));
            }
        }
        // System.out.println(list);
        int idx = 0;
        for(int i=0 ; i<playtime ; i++){
            sb.append(list.get(idx));
            idx++;
            idx %= list.size();
        }
        return sb.toString();
    }
    
    private int playTime(String start, String end){
        String[] sTime = start.split(":");
        String[] eTime = end.split(":");
        int sHour = Integer.parseInt(sTime[0]);
        int sMin = Integer.parseInt(sTime[1]);
        int eHour = Integer.parseInt(eTime[0]);
        int eMin = Integer.parseInt(eTime[1]);
        
        int ret = (eHour*60+eMin)-(sHour*60+sMin);
        return ret;
    }
    private boolean inRangeScale(String scale,int curIdx){
        // true : 다음이 # , false : 다음x or 다음이 음계
        //다음 인덱스가 존재하는지
        int nextIdx = curIdx+1;
        if(nextIdx>=scale.length()){
            return false;
        }
        // 다음이 ABCDEFG(음계)인지 아닌지
        char ch = scale.charAt(nextIdx);
        if(ch>='A' && ch<='G')
            return false;
        return true;
    }
    
    private void printArr(String[][] arr){
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

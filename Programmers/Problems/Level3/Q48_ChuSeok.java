package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q48_ChuSeok {
	public static void main(String[] args) {
		Q48_ChuSeok z = new Q48_ChuSeok();
		String[] lines = {
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		int ret = z.solution(lines);
		System.out.println(ret);
	}
    class Job{
        int[] start;
        int[] end;
        int len;
        public Job(String end, String len){
            this.end = endTime(end);
            this.len = (int)(Double.parseDouble(len.substring(0,len.length()-1))*1000);
            this.start = startTime(this.end, this.len);
        }
        public String toString(){
            return "["+Arrays.toString(start)+"~"+Arrays.toString(end)+" "+len+"]";
        }
        private int[] endTime(String end){
            int[] ret = new int[3];
            String[] arr = end.split(":");
            for(int i=0 ; i<2 ; i++){
                ret[i] = Integer.parseInt(arr[i]);
            }
            ret[2] = (int)(Double.parseDouble(arr[2])*1000);
            return ret;
        }
        private int[] startTime(int[] end, int len){
            int[] ret = new int[3];
            int hour = end[0];
            int min = end[1];
            int sec = end[2];
            sec -= (len-1);
            if(sec<0){
                min -= 1;
                sec += 60000;
                if(min<0){
                    hour -= 1;
                    min += 60;
                }
            }
            ret[0] = hour;
            ret[1] = min;
            ret[2] = sec;
            return ret;
        }
    }
    int max = 0;
    public int solution(String[] lines) {
        max = 0;
        List<Job> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);
        for(String line : lines){
            String[] arr = line.split(" ");
            list.add(new Job(arr[1],arr[2]));
        }
        for(Job job : list){
            pq.offer(job.start);
            pq.offer(job.end);
        }
        // System.out.println(list);
        
        while(!pq.isEmpty()){
            int[] time = pq.poll();
            int cnt = 0;
            for(Job job : list){
                if(inRange(job,time)){
                    cnt++;
                }
            }
            max = Math.max(max,cnt);
        }
        return max;
    }
    private boolean inRange(Job job, int[] time){
        int[] start = job.start;
        int[] end = job.end;
        int timeST_HMS = time[0]*3600000 + time[1]*60000 + time[2];
        int timeEND_HMS = timeST_HMS+999;
        int startHMS = start[0]*3600000 + start[1]*60000 + start[2];
        int endHMS = end[0]*3600000 + end[1]*60000 + end[2];
        
        if(time[0]<start[0] || time[0]>end[0]){
            // hour가 범위 밖인 경우
            return false;
        }
        if(start[0]<time[0] && time[0]<end[0]){
            // hour가 범위 안인 경우
            return true;
        }
        if(endHMS<timeST_HMS || startHMS>timeEND_HMS)
            return false;
        
        return true;
    }
    
    private Comparator<int[]> comp = new Comparator<int[]>(){
        public int compare(int[] a, int[] b){
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else if(a[1]!=b[1]){
                    return a[1]-b[1];
            }else{
                if(a[2]>b[2]){
                    return 1;
                }else{
                    return -1;
                }
            }
        }
    };
}

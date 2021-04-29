package A_String_Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Interval06 {
	int start;
	int end;
	Interval06() {
		start = 0;
		end = 0;
	}
	Interval06(int s, int e) {
		start = s;
		end = e;
	}
}

public class Q06_MeetingRoom2 {
	public static void main(String[] args) {
		Q06_MeetingRoom2 q06 = new Q06_MeetingRoom2();
		Interval06[] arr = new Interval06[4];
		arr[0] = new Interval06(0,30);
		arr[1] = new Interval06(5,15);
		arr[2] = new Interval06(4,9);
		arr[3] = new Interval06(10,16);
//		int ret = q06.solve(arr);
//		System.out.println(ret);
		System.out.println(q06.solution(arr));

	}
	public int solution(Interval06[] intervals) {
		Arrays.sort(intervals, comp);
		// 우선순위 큐 오름차순 정렬?
		Queue<Interval06> pq = new PriorityQueue<>((Interval06 a,Interval06 b) -> a.end-b.end);
		pq.offer(intervals[0]);
		for(int i=1 ; i<intervals.length ; i++) {
			if(pq.peek().end <= intervals[i].start) {
				pq.poll();
			}
			pq.offer(intervals[i]);
		}		
//		while(!pq.isEmpty()) {
//			Interval06 temp = pq.poll();
//			System.out.println(temp.start+" ~ "+temp.end);
//		}
		return pq.size();
	}
	
	public int solve(Interval06[] intervals) {
		Interval06[] ret = new Interval06[intervals.length];
		int cnt = intervals.length;	// 회의실 최대 갯수
		Arrays.sort(intervals, comp);
		print(intervals);
		
		for(int i=0 ; i<intervals.length-1 ; i++) {
			if(intervals[i].start+intervals[i].end==0) {
				continue;
			}
			for(int j=i+1 ; j<intervals.length ; j++) {
				if(intervals[i].end<=intervals[j].start) {
					intervals[i].end = intervals[j].end;
					intervals[j].start = 0;
					intervals[j].end = 0;
					cnt--;	// merge될때마다 회의실 한개 감소
				}
			}
		}
		return cnt;
	}
	
	Comparator<Interval06> comp = new Comparator<>() {
		public int compare(Interval06 a, Interval06 b) {
			return a.start - b.start;	// 오름차순 정렬
		}
	};
	public void print(Interval06[] intervals) {
		for(int i=0 ; i<intervals.length ; i++) {
			System.out.println(intervals[i].start+" ~ "+intervals[i].end);
		}
	}
}

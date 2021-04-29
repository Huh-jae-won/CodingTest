package A_String_Array;
import java.util.Arrays;
import java.util.Comparator;

class Interval{
	int start;
	int end;
	Interval(){
		this.start = 0;
		this.end =0;
	}
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
}


public class Q01_MeetingRooms1 {
	public static void main(String[] args) {
		Q01_MeetingRooms1 meeting = new Q01_MeetingRooms1();
		Interval in1 = new Interval(15,20);
		Interval in2 = new Interval(0,30);
		Interval in3 = new Interval(5,10);
		Interval[] arr1 = {in1,in2,in3};
		
		Interval in11 = new Interval(7,10);
		Interval in22 = new Interval(2,4);
		Interval[] arr2 = {in11,in22};
		

		System.out.println(meeting.solution(arr2));
		
	}
	public boolean solution(Interval[] intervals) {
		Arrays.sort(intervals,c);
		print(intervals);
		for(int i=0 ; i<intervals.length-1 ; i++) {
			for(int j=i+1 ; j<intervals.length ; j++) {
				if(intervals[i].end>intervals[j].start) {
					return false;
				}
			}
		}
		return true;
	}
	public void print(Interval[] intervals) {
		for(int i=0 ; i<intervals.length ; i++) {
			System.out.println(intervals[i].start + " -> " + intervals[i].end);
		}
	}
	Comparator<Interval> c = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start-o2.start;	// 오름차순
		}
		
	};


}

public class Kakao_05 {
	static int[] time;
	static int ansSec;
	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = 
			{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		int advTime = makeSecTime(adv_time)[1];
		int[][] logSec = new int[logs.length][2];
		for(int i=0 ; i<logs.length ; i++) {
			logSec[i] = makeLogTime(logs[i]);
		}
		int maxTime = Integer.MIN_VALUE;
		int minTime = Integer.MAX_VALUE;
		ansSec = Integer.MIN_VALUE;
		for(int i=0 ; i<logSec.length ; i++) {
			maxTime = Math.max(maxTime, logSec[i][1]);
			minTime = Math.min(minTime, logSec[i][0]);
		}
		time = new int[maxTime+1];
//		System.out.println(time.length);
//		System.out.println(minTime+", "+maxTime);
		countTime(logSec);
		moveAdv(logSec,advTime);
//		System.out.println("ans "+ansSec);
		String answer = int2Str(ansSec);
		System.out.println(answer);
	}
	static String int2Str(int time) {
		String[] str = new String[3];
		int t = 3600;
		for(int i=0 ; i<3 ; i++) {
			int temp = time/t;
			if((temp+"").length()==1) {
				str[i] = "0"+temp;
			}else {
				str[i] = temp+"";
			}
			time -= temp*t;
			t /= 60;
		}
		String ss = String.join(":", str);
		return ss;
	}
	
	static int sumTime(int start, int advTime) {
		int sum = 0;
		for(int i=start ; i<=start+advTime ; i++) {
			try {
				sum += time[i];
			}catch(ArrayIndexOutOfBoundsException e) {
				return -1;
			}
		}
		return sum;
	}
	
	static void moveAdv(int[][] logSec,int advTime) {
		int maxSec = Integer.MIN_VALUE;
		for(int i=0 ; i<logSec.length ; i++) {
			int start = logSec[i][0];
			int last  = logSec[i][1];
			for(int x=start ; ; x++) {
				int temp = sumTime(x,advTime);
				if(temp==-1) {
					break;
				}
				if(maxSec<temp) {
					maxSec = temp;
					ansSec = x;
				}else if(maxSec==temp){
					if(x<ansSec) {
						ansSec = x;
					}
				}
			}
		}
	}
	
	static void countTime(int[][] logSec) {
		for(int i=0 ; i<logSec.length ; i++) {
			int start = logSec[i][0];
			int last = logSec[i][1];
			int x = start;
			while(x<=last) {
				time[x]++;
				x++;
			}
		}
	}
	static int[] makeLogTime(String time) {
		int[] range;
		range = makeSecTime(time);
		return range;
	}
	static int[] makeSecTime(String time) {
		int sec = 0;
		int startSec = 0;
		String[] arr = time.split(":|-");
		int t = 3600;
		if(arr.length==3) {
			for(int i=0 ; i<arr.length ; i++) {
				sec += t*Integer.parseInt(arr[i]);
				t /= 60;
			}
		}else if(arr.length==6) {
			for(int i=0 ; i<3 ; i++) {
				startSec += t*Integer.parseInt(arr[i]);
				t /= 60;
			}
			t = 3600;
			for(int i=3 ; i<6 ; i++) {
				sec += t*Integer.parseInt(arr[i]);
				t /= 60;
			}
//			System.out.println(startSec+"~"+sec);
		}
		int[] range = {startSec,sec};
		return range;
	}
}

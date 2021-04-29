import java.util.ArrayList;
import java.util.Arrays;

public class Kakao_02 {
	static int people;
	static boolean[] visited;
	static ArrayList<String> list;
	static ArrayList<String> courseList;
	
	public static void main(String[] args) {
		String[] order = 
			{"XYZ", "XWY", "WXA","BCD","AB","ABCD","YABDE","XYBA"};
		people = 0;
		list = new ArrayList();
		courseList = new ArrayList();
		int max = countLength(order);
		char[] dish = countDish(order);
		System.out.println(max);
		System.out.println(dish);
		Arrays.sort(dish);
		visited = new boolean[dish.length];
		makeCourse(order,dish,max);
		list.sort(null);
		String[] answer = new String[list.size()];
		for(int i=0 ; i<answer.length ; i++) {
			answer[i] = list.get(i);
			System.out.print(answer[i]+" ");
		}
	}
	
	
	static int cntPeople(String[] order,String dish) {
		int length = dish.length();
		int cntPeople = 0;
		for(int i=0 ; i<order.length ; i++) {
			int cnt = 0;
			for(int j=0 ; j<length ; j++) {
				if(order[i].contains(dish.charAt(j)+"")) {
					cnt++;
				}
			}
			if(cnt==length) {
				cntPeople++;
			}
		}
		return cntPeople;
	}
	
	static void cntCourse(String[] order,char[] dish,int cnt,int dep,int indx,String ret) {
		if(dep==cnt) {
			int num = cntPeople(order,ret);
			if(num>1 && people<num) {
				people = num;
				courseList.removeAll(courseList);
				courseList.add(ret);
			}else if(num>1 && people==num) {
				courseList.add(ret);
			}
		}else {
			for(int i=indx ; i<dish.length ; i++) {
				if(!visited[i]) {
					visited[i] = true;
					cntCourse(order,dish,cnt,dep+1,i,ret+dish[i]);
					visited[i] = false;
				}
			}
		}
	}
	
	static void makeCourse(String[] order,char[] dish,int max) {
		ArrayList<Integer> course = new ArrayList();
		for(int cnt=2 ; cnt<=max ; cnt++) {
			people = 0;
			cntCourse(order,dish,cnt,0,0,"");
			for(int i=0 ; i<courseList.size() ; i++) {
				list.add(courseList.get(i));
			}
			courseList.removeAll(courseList);
		}
	}
	
	static char[] countDish(String[] order) {
		String str = "";
		for(int i=0 ; i<order.length ; i++) {
			for(int j=0 ; j<order[i].length() ; j++) {
				if(str.contains(order[i].charAt(j)+"")) {
					continue;
				}
				str += order[i].charAt(j);
			}
		}
		return str.toCharArray();
	}
	static int countLength(String[] order) {
		ArrayList<Integer> temp = new ArrayList();
		for(int i=0 ; i<order.length ; i++) {
			temp.add(order[i].length());
		}
		temp.sort(null);
		for(int i=temp.size()-1 ; i>-1 ;i--) {
			if(countNum(temp,temp.get(i))!=1) {
				return temp.get(i);
			}
		}
		return -1;
	}
	
	static int countNum(ArrayList<Integer> list,int num) {
		int cnt = 0;
		for(int i=0 ; i<list.size() ; i++) {
			if(num==list.get(i))
				cnt++;
		}
		return cnt;
	}

}

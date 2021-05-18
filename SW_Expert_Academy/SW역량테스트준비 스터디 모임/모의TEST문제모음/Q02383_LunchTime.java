package 모의TEST문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q02383_LunchTime {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q02383_LunchTime a = new Q02383_LunchTime();
		a.solution();
	}
	class Person{
		int name;
		int row;
		int col;
		boolean sorted;
		
		int stair;	// 사용할 계단 index
		int dist;
		
		public Person(int name,int row, int col) {
			this.name = name;
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "<"+name+": ("+row+","+col+"):"+"(s="+stair+",d="+dist+")>";
		}
	}
	class Stair{
		int row;
		int col;
		int length;
		List<Person> member = new ArrayList<>();
		public Stair(int row, int col, int length) {
			this.row = row;
			this.col = col;
			this.length = length;
		}

		@Override
		public String toString() {
			return "["+row+","+col+" : "+length+"]";
		}
	}
	
	int N = 0;
	int ret = 0;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			N = Integer.parseInt(br.readLine());
			ret = Integer.MAX_VALUE;
			StringTokenizer st;
	
			int[][] map = new int[N][N];
			List<Person> pList = new ArrayList<>();
			List<Stair> sList = new ArrayList<>();
			int pName = 0;
			for(int i=0 ; i<N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						pList.add(new Person(++pName, i, j));
					}else if(map[i][j]>1) {
						sList.add(new Stair(i,j,map[i][j]));
					}
				}
			}
			
//			System.out.println("Person List");
//			for(Person p : pList) {
//				System.out.println(p);
//			}
//			
//			System.out.println("Stair List");
//			for(Stair s : sList) {
//				System.out.println(s);
//			}
			
			dfs(sList,pList, 0, pName);
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	private int getDist(Person p, Stair s) {
		int dRow = Math.abs(p.row-s.row);
		int dCol = Math.abs(p.col-s.col);
		return dRow + dCol;
	}
	
	private void dfs(List<Stair> sList,List<Person> pList,int dep,int num) {
		if(dep==num) {
			ret = Math.min(move(sList, pList),ret);
			// 계단 수행
			return;
		}
		for(Person p : pList) {
			if(!p.sorted) {
				p.sorted = true;
				p.stair = 0;	// 0번 계단으로
				dfs(sList,pList, dep+1, num);
				p.sorted = false;
			}
			if(!p.sorted) {
				p.sorted = true;
				p.stair = 1;	// 1번 계단으로
				dfs(sList,pList, dep+1, num);
				p.sorted = false;
			}
		}
		return;
	}
	private int move(List<Stair> sList,List<Person> pList) {
		for(Person p : pList) {
			if(p.stair==0) {
				p.dist = getDist(p, sList.get(0)); 
				sList.get(0).member.add(p);
			}else {
				p.dist = getDist(p, sList.get(1)); 
				sList.get(1).member.add(p);
			}
		}
		sList.get(0).member.sort(comp);
		sList.get(1).member.sort(comp);
//		System.out.print("stair0 : ");
//		printList(sList.get(0).member);
//		
//		System.out.print("stair1 : ");
//		printList(sList.get(1).member);
//		System.out.println();
		
		// 시간이 얼마나 걸리는지 확인
		Stair s0 = sList.get(0);
		int len0 = s0.member.size();
		Stair s1 = sList.get(1);
		int len1 = s1.member.size();
		Queue<Person> q0 = new LinkedList<>();
		Queue<Integer> t0= new LinkedList<>();
		Queue<Person> q1 = new LinkedList<>();
		Queue<Integer> t1= new LinkedList<>();
		int time0 = 1;
		int success0 = 0;
		int time1 = 1;
		int success1 = 0;
		// 1번계단
		while(true) {
//			System.out.println(time0);
			// 계단 시간 지나면 빠져나옴
			while(q0.size()>0 && time0-t0.peek()>s0.length) {
				q0.poll();
				t0.poll();
				success0++;
			}
			for(int i=0 ; i<s0.member.size() ; i++ ) {
				Person p = s0.member.get(i);
				// 1칸 이동
				if(p.dist>=1) {
					p.dist--;
				}
				// 이동후 입구도착(계단이용가능상태) -> 계단으로 진입
				if(p.dist<=0 && q0.size()<3) {
					t0.offer(time0);
					s0.member.remove(p);
					q0.offer(p);
					i--;
				}
			}
//			System.out.print("s0 : ");
//			printList(s0.member);
//			System.out.print("q0 : ");
//			printQueue(q0);
//			System.out.print("t0 : ");
//			System.out.println(t0);
			
			if(success0>=len0)
				break;
			time0 ++;
		}
//		time0 += s0.length;
		// 2번 계단
		while(true) {
//			System.out.println(time1);
			// 계단 시간 지나면 빠져나옴
			while(q1.size()>0 && time1-t1.peek()>s1.length) {
				q1.poll();
				t1.poll();
				success1++;
			}
			for(int i=0 ; i<s1.member.size() ; i++ ) {
				Person p = s1.member.get(i);
				// 1칸 이동
				if(p.dist>=1) {
					p.dist--;
				}
				// 이동후 입구도착(계단이용가능상태) -> 계단으로 진입
				if(p.dist<=0 && q1.size()<3) {
					t1.offer(time1);
					s1.member.remove(p);
					q1.offer(p);
					i--;
				}
			}
//			System.out.print("s1 : ");
//			printList(s1.member);
//			System.out.print("q1 : ");
//			printQueue(q1);
//			System.out.print("t1 : ");
//			System.out.println(t1);
			if(success1>=len1)
				break;
			time1 ++;
		}
//		time1 += s1.length;
		
		
//		System.out.println("final time0:"+time0);
//		System.out.println("final time1:"+time1);
		
		sList.get(0).member.clear();
		sList.get(1).member.clear();
		q0.clear();
		q1.clear();
		int time = Math.max(time0, time1);
		int ret = time;
		return ret;
	}
	
	
	Comparator<Person> comp = new Comparator<Person>() {

		@Override
		public int compare(Person o1, Person o2) {
			return o1.dist-o2.dist;
		}
	};
	
	private void printList(List<Person> list) {
		for(Person p : list) {
			System.out.printf("(n=%d:d=%d) ",p.name,p.dist);
		}
		System.out.println();
	}
	private void printQueue(Queue<Person> q) {
		for(Person p : q) {
			System.out.printf("(n=%d:d=%d) ",p.name,p.dist);
		}
		System.out.println();
	}
}


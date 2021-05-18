package 모의TEST문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q02383_LunchTimeBBB {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q02383_LunchTimeBBB a = new Q02383_LunchTimeBBB();
		a.solution();
//		a.sol2();
	}
	private void sol2() {
		List<Integer> stair0 = new ArrayList<>();
		List<Integer> stair1 = new ArrayList<>();
		stair0.add(4); stair0.add(7); stair0.add(8);
		stair1.add(3); stair1.add(6); stair1.add(7); stair1.add(8);

		int time1 = Time(stair1, 7);
		int time0 = Time(stair0, 8);
		System.out.println("time : "+time0+", "+time1);
	}
	
	
	class Person{
		int row;
		int col;
		public Person(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Person [row=" + row + ", col=" + col + "]";
		}
		
	}
	class Stair{
		int row;
		int col;
		int length;
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
	List<Person> pList; 
	List<Stair> sList;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			N = Integer.parseInt(br.readLine());
			ret = Integer.MAX_VALUE;
			StringTokenizer st;
	
			pList = new ArrayList<>();
			sList = new ArrayList<>();
			int pCnt = 0;
			int sCnt = 0;
			
			int[] sizeOfStair = new int[2];
			
			for(int i=0 ; i<N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<N ; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp==1) {
						pList.add(new Person( i, j));
						pCnt++;
					}else if(temp>1) {
						sList.add(new Stair(i, j, temp));
						sizeOfStair[sCnt] = temp;
						sCnt++;
					}
				}
			}
			// 각 사람이 어디 계단 쓸지 
			int[] pStair = new int[pCnt];
			// 각 사람과 사용할 계단 사이 거리
			int[] pDist = new int[pCnt];
			
			dfs(pStair,pDist,sizeOfStair, 0, pCnt,-1);
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
	
	private void dfs(int[] pStair, int[] pDist,int[] sizeOfStair,int dep,int num,int befIdx) {
		if(dep==num) {
			ret = Math.min(move(pStair,pDist,sizeOfStair),ret);
			// 계단 수행
			return;
		}
		for(int i=befIdx+1 ; i<pDist.length ; i++) {
			pStair[i] = 0;	// 0번 계단으로
			pDist[i] = getDist(pList.get(i), sList.get(0));
			dfs(pStair,pDist,sizeOfStair, dep+1, num,i);
			
			pStair[i] = 1;	// 1번 계단으로
			pDist[i] = getDist(pList.get(i), sList.get(1));
			dfs(pStair,pDist,sizeOfStair, dep+1, num,i);
		}
		return;
	}
	private int move(int[] pStair, int[] pDist, int[] sizeOfStair) {
		List<Integer> stair0 = new ArrayList<>();
		List<Integer> stair1 = new ArrayList<>();
		for(int i=0 ; i<pStair.length ; i++) {
			if(pStair[i]==0) {
				stair0.add(pDist[i]);
			}else {
				stair1.add(pDist[i]);
			}
		}
		stair0.sort(comp);
		stair1.sort(comp);

		System.out.print(stair0+", "+stair1);
		int time0 = Time(stair0, sizeOfStair[0]);
		int time1 = Time(stair1, sizeOfStair[1]);
		System.out.printf(" -> final time (%d,%d)\n",time0,time1);
		
		int time = Math.max(time0, time1);
		int ret = time;
		return ret;
	}
	
	private int Time(List<Integer> stair, int sizeOfStair) {
		int time = 1;
		int success = 0;
		int len = stair.size();
		Queue<Integer> q = new LinkedList<>();
		while(true) {
//			System.out.println("<time : "+time+">");
			while(q.size()>0 && time-q.peek()>=sizeOfStair) {
				q.poll();
				success++;
			}
			for(int i=0 ; i<stair.size() ; i++ ) {
				int dist = stair.get(i);
				// 1칸 이동
				if(dist>=1) {
					stair.remove(i);
					stair.add(i,--dist);
				}
				// 이동후 입구도착(계단이용가능상태) -> 계단으로 진입
				if(dist<=0 && q.size()<3) {
					stair.remove(i);
					q.offer(time+1);	// 출발시간 입력
					i--;
				}
			}
//			System.out.println("s : "+stair);
//			System.out.println("q : "+q);
//			System.out.println("success : "+success);
			if(success>=len)
				break;
			time++;
		}
		return time;
	}
	Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1-o2;
		}
	};
}


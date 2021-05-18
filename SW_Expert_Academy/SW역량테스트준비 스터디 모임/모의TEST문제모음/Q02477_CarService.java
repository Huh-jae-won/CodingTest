package 모의TEST문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q02477_CarService {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q02477_CarService a = new Q02477_CarService();
		a.solution();
	}
	class Person{
		int name;
		int arrivalTime;	// 정비소 도착시간
		int[] counter = new int[2];	// 접수, 정비 창구 번호
//		int recept;			// 접수 창구 번호
//		int service;		// 정비 창구 번호
		int[] start = new int[2];	// 접수, 정비 시작 시간
		public Person(int name,int arrivalTime) {
			this.name = name;
			this.arrivalTime = arrivalTime;
			start[0] = -1;	// 접수 시작 시간
			start[1] = -1;	// 정비 시작 시간
			counter[0] = -1;
			counter[1] = -1;
		}
		@Override
		public String toString() {
			return "{"+name+": 도착="+arrivalTime+", 창구="+Arrays.toString(counter)+", 시작="+Arrays.toString(start)+"}";
		}
		
	}
	int N = 0;	// 접수 창구 갯수
	int M = 0;	// 정비 창구 갯수
	int K = 0;	// 방문 고객 
	int A = 0;	// 찾을사람이 사용한 접수 창구 번호
	int B = 0;	// 찾을사람이 사용한 정비 창구 번호
	int ret = 0;
	int[] reception;
	int[] service;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			ret = 0;
			
			reception = new int[N+1];	// 접수 창구 서비스시간
			Queue<Person> receptionQ = new LinkedList<>();	// 접수 대기열
			List<Person> receptionList = new ArrayList<>(); // 현재 접수중인 사람
			boolean[] rVisited = new boolean[N+1];
			
			service = new int[M+1];	// 정비 창구 서비스시간
			PriorityQueue<Person> serviceQ = new PriorityQueue<>(comp);	// 정비 대기열
//			Queue<Person> serviceQ = new LinkedList<>();	// 정비 대기열
			List<Person> serviceList = new ArrayList<>();	// 현재 정비중인 사람
			boolean[] sVisited = new boolean[M+1];
			
			List<Person> finish = new ArrayList<>();
			
			// 접수 창구 소요 시간
			st = new StringTokenizer(br.readLine());
			for(int i=1 ; i<N+1 ; i++) {
				reception[i] = Integer.parseInt(st.nextToken());
			}
			
			// 정비 창구  소요 시간
			st = new StringTokenizer(br.readLine());
			for(int i=1 ; i<M+1 ; i++) {
				service[i] = Integer.parseInt(st.nextToken());
			}
			
			// 정비소에 도착한 시간
			st = new StringTokenizer(br.readLine());
			for(int i=1 ; i<K+1 ; i++) {
				receptionQ.offer(new Person(i, Integer.parseInt(st.nextToken())));
			}
			int numOfPeople = receptionQ.size();
//			System.out.println("reception: "+Arrays.toString(reception));
//			System.out.println("serivce  : "+Arrays.toString(service));
//			System.out.println(receptionQ);
			
			// 접수대기열(queue) -> 접수 -> 정비대기열(queue) -> 정비
			int time = 0;
			// receptionQ -> receptionList -> serviceQ -> serviceList -> finish
			while(true) {
//				System.out.println("<time : "+time+">");
				// 정비창구에서 시간이 지났으면 빼는
				for(int i=0 ; i<serviceList.size() ; i++) {
					Person p = serviceList.get(i);
					if(time-p.start[1]>=service[p.counter[1]]) {
						sVisited[p.counter[1]] = false;	// 해당 창구 비었음
						ret += chkPerson(p);
						finish.add(p);
						serviceList.remove(i);
						i--;
					}
				}

				// 접수창구에서 시간이 지났으면 정비 대기열로 
				for(int i=0 ; i<receptionList.size() ; i++) {
					Person p = receptionList.get(i);
					if(time-p.start[0]>=reception[p.counter[0]]) {
						// 정비대기열로
						serviceQ.add(p);			// 현재 p 큐에 삽입
						rVisited[p.counter[0]] = false;	// 해당 창구 비었음
						receptionList.remove(i);	// 현재 p 리스트에서 삭제
						i--;
					}
				}
				// 정비창구가 비었으면 정비대기열에서 정비창구로
				int sIdx=-1;
				while(serviceQ.size()!=0 && (sIdx=canUse(sVisited))!=-1) {
					sVisited[sIdx] = true;
					Person p = serviceQ.poll();
					p.counter[1] = sIdx;
					p.start[1] = time;
					serviceList.add(p);
				}
				
				// 접수창구가 비었으면  접수대기열에서 접수창구로
				int rIdx=-1;
				while(receptionQ.size()!=0 && (rIdx=canUse(rVisited))!=-1 && receptionQ.peek().arrivalTime<=time) {
					rVisited[rIdx] = true;
					Person p = receptionQ.poll();
					p.counter[0] = rIdx;	// p의 접수창구 번호
					p.start[0] = time;	// 접수 시작 시간
					receptionList.add(p);	// 접수창구에 추가
				}
				
//				if(serviceList.size()==0 && serviceQ.size()==0 && receptionList.size()==0 && serviceQ.size()==0)
//					break;
				if(finish.size()==numOfPeople)
					break;
//				printLog(receptionList, receptionQ, serviceList, serviceQ);
				time++;
			}
//			System.out.println("finish : "+finish);
			if(ret==0)
				ret = -1;
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
	private int chkPerson(Person p) {
		if(p.counter[0]==A && p.counter[1]==B) {
			return p.name;
		}
		return 0;
	}
	private int canUse(boolean[] arr) {
		for(int i=1 ; i<arr.length ; i++) {
			if(!arr[i]) {
				return i;
			}
		}
		return -1;
	}
	
	Comparator<Person> comp = new Comparator<Person>() {
		@Override
		public int compare(Person p1, Person p2) {
			int p1Time = p1.start[0] + reception[p1.counter[0]];
			int p2Time = p2.start[0] + reception[p2.counter[0]];
			if(p1Time!=p2Time)
				return p1Time-p2Time;
			return p1.counter[0]-p2.counter[0];
		}
	};
	
	private void printLog(List<Person> receptionList, Queue<Person> receptionQ, List<Person> serviceList, Queue<Person> serviceQ) {
		System.out.println("rQueue : "+receptionQ);
		System.out.println("rList  : "+receptionList);
		System.out.println("sQueue : "+serviceQ);
		System.out.println("sList  : "+serviceList);
		System.out.println("ret : "+ret);
		System.out.println();
	}
}

package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q02_DiskController {
	public static void main(String[] args) {
		Q02_DiskController a = new Q02_DiskController();
		int[][] jobs = {
				{0, 3}, 
				{1, 9}, 
				{2, 6}
		};
		System.out.println(a.controller(jobs));
	}
	public int controller(int[][] jobs){
		PriorityQueue<int[]> pq = new PriorityQueue<>(comp);
		for(int i=0 ; i<jobs.length ; i++) {
			pq.add(jobs[i]);
		}
		List<Integer> serviceTime = new ArrayList<>();
		int time = 0;
		while(!pq.isEmpty()) {
//			System.out.println("===== time : " + time+" =====");
			List<int[]> list = new ArrayList<>();
			int size = pq.size();
			for(int i=0 ; i<size ; i++) {
				if(pq.peek()[0]<=time) {
//					System.out.println(pq.peek()[0]+", "+pq.peek()[1]);
					list.add(pq.poll());
				}else
					break;
			}
			int index = countTime(pq,list,time,serviceTime);
//			System.out.println("ret : "+serviceTime+", "+index);
			if(index!=-1) {
				time += list.get(index)[1];
			}else {
//				System.out.println("+ 시간 1초 +");
				time++;
			}
		}
		int sum = 0;
		for(int i=0 ; i<serviceTime.size() ; i++) {
			sum += serviceTime.get(i);
		}
		return sum/serviceTime.size();
	}
	private int countTime(PriorityQueue<int[]> pq,List<int[]> list,int curTime,List<Integer> serviceTime) {
		int size = list.size();
		int index = -1;
		int min = Integer.MAX_VALUE;
		if(size==0)
			return index;
		
//		이건 현재 list에서 실행시간이 최소인 작업을 우선으로
		for(int i=0 ; i<size ; i++) {
			int[] job = list.get(i);
			int time = job[1];
			if(min>time) {
				min = time;
				index = i;
			}
		}
//		이건 대기+실행시간이 최소인 작업을 우선으로 
//		for(int i=0 ; i<size ; i++) {
//			int[] job = list.get(i);
//			int countTime = curTime-job[0]+job[1];
//			System.out.printf("[%d][%d]의 serTime : %d\n",job[0],job[1],countTime);
//			if(min>countTime) {
//				min = countTime;
//				index = i;
//			}
//		}
		serviceTime.add(min+curTime-list.get(index)[0]);
//		System.out.printf("min : %d, ");
//		뺀거 다시 pq로
		for(int i=0 ; i<size ; i++) {
			if(index!=i)
				pq.offer(list.get(i));
		}
		return index;
	}
	
	Comparator comp = new Comparator<int[]>(){
		@Override
		public int compare(int[] o1, int[] o2) {
			int com = o1[0]-o2[0];
			if(com==0) {
				com = o1[1]-o2[1];
			}
			return com;
		}
	};
}

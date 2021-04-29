package D_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q12_CourseSchedule {

	public static void main(String[] args) {
		int course = 4;
		int[][] nums = {
//				course 종류 : 0,1,2,3, 선행과목 정의
				{1,0},	// 1의 선행과목 : 0
				{2,1},	// 2의 선행과목 : 1
				{3,2}	// 3의 선행과목 : 2
 
			};
		int[][] nums2 = {
				{1,0},
				{0,1} };
		Q12_CourseSchedule q12 = new Q12_CourseSchedule();
		System.out.println(q12.solution(course, nums));
	}
	public boolean solution(int courseNumber, int[][] nums) {
		if(courseNumber <=0)
			return false;
		
//		1. inDegree 배열, Queue 생성
		Queue<Integer> q = new LinkedList<>();
		int[] indegree = new int[courseNumber];
		
		int length = nums.length;
		for(int i=0 ; i<length ; i++) {
			// 선행과목이면 +1
			indegree[nums[i][1]]++;
		}
		
		for(int i=0 ; i<indegree.length ; i++) {
			if(indegree[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int val = q.poll();
			for(int i=0 ; i<nums.length ; i++) {
				if(val==nums[i][0]) {
					int valPre = nums[i][1];	// val의 선행과목
					indegree[valPre]--;
					if(indegree[valPre]==0) {
						q.offer(valPre);
					}
				}
			}
		}
		
		for(int i=0 ; i<indegree.length ; i++) {
			if(indegree[i]!=0)
				return false;
		}
		return true;
	}
}

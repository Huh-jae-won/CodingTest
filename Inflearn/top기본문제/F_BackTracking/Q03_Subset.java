package F_BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q03_Subset {
	public static void main(String[] args) {
		Q03_Subset a = new Q03_Subset();
		int[] nums = {1,2,3,4};
//		System.out.println(a.subsets(nums));
		System.out.println(a.solution(nums));
	}
	 public List<List<Integer>> solution(int[] nums) {
		 List<List<Integer>> ret = new ArrayList<>();
		 List<Integer> list = new ArrayList<>();
		 if(nums==null || nums.length==0)
			 return ret;
		 sol_dfs(ret,list,nums,0);
		 System.out.println("size : "+ret.size());
		 return ret;
	 }
	 private void sol_dfs(List<List<Integer>> ret, List<Integer> cur, int[] nums, int start) {
		 ret.add(new ArrayList<Integer>(cur));
		 
		 for(int i=start ; i<nums.length ; i++) {
			 cur.add(nums[i]);
			 sol_dfs(ret,cur,nums,i+1);
			 cur.remove(cur.size()-1);
		 }
	 }

	 ////////////////////////////////////////////////////
	 public List<List<Integer>> subsets(int[] nums) {
		 List<List<Integer>> ret = new ArrayList<>();
		 boolean[] visited = new boolean[nums.length];
		 List<Integer> list = new ArrayList<>();
//		 dfs(ret,list,nums,visited,0);
		 bfs(ret,list,nums,visited);
		 System.out.println(ret.size());
		 return ret;
	 }
	 
	 private void bfs(List<List<Integer>> ret, List<Integer> list, int[] nums, boolean[] visited) {
		 // 인덱스만 담음
		 ret.add(new ArrayList<Integer>(list));
		 // nums의 인덱스만 담는 큐
		 Queue<List<Integer>> q = new LinkedList<>(); 
		 for(int i=0 ; i<nums.length ; i++) {
			 List<Integer> first = new ArrayList<>();
			 first.add(i);
			 q.add(first);
		 }
		 
		 while(!q.isEmpty()) {
			 List<Integer> temp = q.poll();
			 ret.add(new ArrayList<Integer>(temp));
			 int lastIndex = temp.get(temp.size()-1);
			 for(int i=lastIndex+1 ; i<nums.length ; i++) {
				 temp.add(i);
				 q.add(new ArrayList<Integer>(temp));
				 temp.remove(temp.size()-1);
			 }
		 }
		 
	 }
	 
	 private void dfs(List<List<Integer>> ret, List<Integer> list, int[] nums, boolean[] visited,int befI) {
		 List<Integer> temp = new ArrayList<>(list);
		 ret.add(temp);
		 for(int i=befI ; i<nums.length ; i++) {
			 if(!visited[i]) {
				 visited[i] = true;
				 list.add(nums[i]);
				 dfs(ret,list,nums,visited,i);
				 list.remove(list.size()-1);
				 visited[i] = false;
			 }
		 }
	 }
		 

}

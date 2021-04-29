package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q02_Bridge {
	static int ret = 0;
	public static void main(String[] args) {
		Q02_Bridge a = new Q02_Bridge();
		int dist = 25;
		int[] rocks = {2,14,11,21,17};
		int n = 2;
		System.out.println("result : "+a.remove(dist, rocks, n));
	}
	public int remove(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		boolean[] visited = new boolean[rocks.length];
		List<Integer> between = new ArrayList<>();
		between.add(rocks[0]);
		for(int i=1 ; i<rocks.length ; i++) {
			between.add(rocks[i]-rocks[i-1]);
		}
		between.add(distance-rocks[rocks.length-1]);
		System.out.print(" ");
		printArr(rocks);
		System.out.println(between);
		dfs(between,n,0,rocks.length,visited,"");
		return 0;
	}
	private void dfs(List<Integer> list,int n,int dep,int befI,boolean[] visited,String str) {
		if(dep==n) {
			System.out.println("str : "+str);
			StringTokenizer st = new StringTokenizer(str);
			List<Integer> clone = list.subList(0, list.size());
			System.out.println("list  : "+list);
			System.out.println("clone : "+clone);
			while(st.hasMoreElements()) {
				String s = st.nextToken();
				System.out.println("st : "+s);
				//rocks[i]가 사라지면 list의 i와 i+1이 합쳐짐
				int index = Integer.parseInt(s);
				int newDist = clone.get(index)+clone.get(index+1);
				clone.remove(index+1);
				clone.remove(index);
				clone.add(newDist);
			}
			int min = findMin(clone);
			if(min>ret) {
				System.out.println("min : "+min);
				ret = min;
			}
			return;
		}
		for(int i=befI-1 ; i>=0 ; i--) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(list,n,dep+1,i,visited,str+i+" ");
				visited[i] =false;
			}
		}
		return;
	}
	private int findMin(List<Integer> list) {
		int min = Integer.MAX_VALUE;
		for(int num : list) {
			if(num<min)
				min = num;
		}
		return min;
	}
	static void printArr(int[] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			System.out.printf("%-2d, ",arr[i]);
		}
		System.out.println();
	}
}

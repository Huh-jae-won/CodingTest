import java.util.ArrayList;

public class Naver_02 {
	static class Node{
		int num;
		int length = 0;
		ArrayList<Integer> list;
		Node(int num, ArrayList<Integer> list){
			this.num = num;
			this.list = list;
		}
	}
	static Node[] arr;
	public static void main(String[] args) {
		int n = 9;
		arr = new Node[n];
		int[][] edges = {{0,2},{2,1},{2,4},{3,5},{5,4},{5,7},{7,6},{6,8}};
		int[] lineNum = new int[n];
		findLine(edges);
		for(int i=0 ; i<n ;i++) {
			System.out.println(arr[i].list);
		}
	}
	static void findLine(int[][] edges) {
		for(int i=0 ; i<edges.length ; i++) {
			for(int j=0 ; j<2 ; j++) {
				int temp = edges[i][j];
				if(arr[temp]==null) {
					arr[temp] = new Node(temp,new ArrayList<Integer>());
					arr[temp].list.add(edges[i][(j+1/2)]);
					arr[temp].length++;
				}else {
					if(!arr[temp].list.contains(edges[i][(j+1/2)])) {
						arr[temp].list.add(edges[i][(j+1/2)]);
						arr[temp].length++;
					}
				}
			}
		}
	}
	static void print(int[] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+" " );
		}
		System.out.println();
	}
}

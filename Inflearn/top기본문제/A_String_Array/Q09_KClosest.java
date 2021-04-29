package A_String_Array;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q09_KClosest {
	public static void main(String[] args) {
		Q09_KClosest q09 = new Q09_KClosest();
		int N = 5;
		int K = 2;
		int[][] points = new int[N][2];
		for(int i=0 ; i<N ; i++) {
			points[i][0] = (int) (Math.random()*20-10);
			points[i][1] = (int) (Math.random()*20-10);
		}
		q09.print(points);
		int[][] ret = q09.kClosest(points, K);
		
		System.out.println("==result ==");
		q09.print(ret);
		
	}
	public int[][] solution(int[][] points, int k){
		Queue<int[]> pq = new PriorityQueue<>(comp);
		int[][] ret = new int[k][2];
		
		for(int[] p : points) {
			pq.offer(p);
		}
		for(int i=0 ; i<k ; i++) {
			ret[i] = pq.poll();
		}
		return ret;
	}
	
	public int[][] kClosest(int[][] arr, int K){
		int[][] ret = new int[K][2];
		Queue<int[]> pq = new PriorityQueue<>(comp);
		for(int i=0 ; i<arr.length ; i++) {
			pq.add(arr[i]);
		}
		for(int i=0 ; i<K ; i++) {
			int[] temp = pq.poll();
			ret[i][0] = temp[0];
			ret[i][1] = temp[1];
		}
		return ret;
	}
	Comparator<int[]> comp = new Comparator<>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			int a = (int)(Math.pow(o1[0],2) + Math.pow(o1[1],2));
			int b = (int)(Math.pow(o2[0],2) + Math.pow(o2[1],2));
			return a-b;
		}
		
	};
	public void print(int[][] arr) {
		int length = arr.length;
		for(int i=0 ; i<length ; i++) {
			System.out.printf("%2d, %2d\n",arr[i][0],arr[i][1]);
		}
	}

}

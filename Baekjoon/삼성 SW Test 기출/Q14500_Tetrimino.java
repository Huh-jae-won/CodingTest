import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q14500_Tetrimino {
	public static void main(String[] args) throws IOException {
		Q14500_Tetrimino z = new Q14500_Tetrimino();
		z.solution();
	}
	class Block{
		List<int[]> list;
		Block(){
			list = new ArrayList<>();
		}
		private void doRotate(int row, int col) {
			List<int[]> newList1 = new ArrayList<>(list);
			List<int[]> newList2 = symmetry(list);
			
			for(int i=0 ; i<4 ; i++) {
				rotate(newList1);
				rotate(newList2);
				int sum1 = sum(newList1,row,col);
				int sum2 = sum(newList2,row,col);
				int sum  = Math.max(sum1, sum2);
				if(ret<sum) {
					ret = sum;
				}
			}
		}
		private int sum(List<int[]> newList,int row, int col) {
			int sum = 0;
			for(int[] arr : newList) {
				if(inRange(arr,row,col)) {
					sum += board[arr[0]+row][arr[1]+col];
				}else {
					return -1;
				}
			}
			return sum;
		}
		
		private void rotate(List<int[]> newList) {
			for(int[] arr : newList) {
				int newX = -arr[1];
				int newY = arr[0];
				arr[0] = newX;
				arr[1] = newY;
			}
			newList.sort((x,y)->{
				if(x[0]!=y[0]) {
					return x[0]-y[0];
				}else {
					return x[1]-y[1];
				}
			});
		}
		private List<int[]> symmetry(List<int[]> list) {
			List<int[]> newList = new ArrayList<>();
			for(int i=0 ; i<list.size() ; i++) {
				int[] arr = list.get(i);
				newList.add(new int[] {arr[0],-arr[1]});
			}
			newList.sort((x,y)->{
				if(x[0]!=y[0]) {
					return x[0]-y[0];
				}else {
					return x[1]-y[1];
				}
			});
			return newList;
		}
		
		private boolean inRange(int[] arr,int row, int col) {
			int newRow = arr[0]+row;
			int newCol = arr[1]+col;
			if(newRow>=0 && newRow<N && newCol>=0 && newCol<M)
				return true;
			return false;
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for(int[] arr : list) {
				sb.append(Arrays.toString(arr));
				sb.append(", ");
			}
			return sb.toString();
		}
	}
	int N = 0;
	int M = 0;
	int ret = 0;
	int[][] board;
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ret = Integer.MIN_VALUE;
		board = new int[N][M];
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Block[] blockArr = new Block[5];
		for(int i=0 ; i<5 ; i++) {
			blockArr[i] = new Block();
		}
		// 0	ㅁ ㅁ ㅁ ㅁ
		blockArr[0].list.add(new int[] {0,0});
		blockArr[0].list.add(new int[] {0,1});
		blockArr[0].list.add(new int[] {0,2});
		blockArr[0].list.add(new int[] {0,3});
		// 1	ㅁ ㅁ
		//		ㅁ ㅁ
		blockArr[1].list.add(new int[] {0,0});
		blockArr[1].list.add(new int[] {0,1});
		blockArr[1].list.add(new int[] {1,0});
		blockArr[1].list.add(new int[] {1,1});
		// 2	ㅁ
		// 		ㅁ
		//		ㅁ ㅁ
		blockArr[2].list.add(new int[] {0,0});
		blockArr[2].list.add(new int[] {1,0});
		blockArr[2].list.add(new int[] {2,0});
		blockArr[2].list.add(new int[] {2,1});
		// 4	ㅁ
		//		ㅁ ㅁ
		//		    ㅁ
		blockArr[3].list.add(new int[] {0,0});
		blockArr[3].list.add(new int[] {1,0});
		blockArr[3].list.add(new int[] {1,1});
		blockArr[3].list.add(new int[] {2,1});
		//  5	ㅁ ㅁ ㅁ
		//		    ㅁ 
		blockArr[4].list.add(new int[] {0,0});
		blockArr[4].list.add(new int[] {0,1});
		blockArr[4].list.add(new int[] {0,2});
		blockArr[4].list.add(new int[] {1,1});
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				for(int k=0 ; k<5 ; k++) {
					blockArr[k].doRotate(i, j);
				}
			}
		}
		System.out.println(ret);
	}
	private void printBoard() {
		for(int[] arr : board) {
			System.out.println(Arrays.toString(arr));
		}
	}
	private void printList(List<int[]>list) {
		for(int[] arr : list) {
			System.out.print(Arrays.toString(arr)+", ");
		}
		System.out.println();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Q15683_CCTV {
	public static void main(String[] args) throws IOException {
		Q15683_CCTV z = new Q15683_CCTV();
		z.solution();
	}
	int N = 0;
	int M = 0;
	int ret = 10000;
	int[][] office;
	List<CCTV> tvList;
	Map<Integer,Integer> map;
	class CCTV{
		int type;
		int dir;
		int row;
		int col;
		List<int[]> dirList;
		public CCTV(int type, int row, int col) {
			this.type = type;
			this.row = row;
			this.col = col;
			this.dir = 0;
			makeDirList();
		}
		public CCTV(int type, int row, int col,int dir) {
			this.type = type;
			this.row = row;
			this.col = col;
			this.dir = dir;
			makeDirList();
		}
		private void makeDirList() {
			switch (this.type) {
			case 1 :
				// 우
				dirList = Arrays.asList(new int[] {0,1});
				break;
			case 2 :
				// 좌우
				dirList = Arrays.asList(new int[] {0,-1}, new int[] {0,1});
				break;
			case 3 :
				// 상우
				dirList = Arrays.asList(new int[] {-1,0}, new int[] {0,1});
				break;
			case 4 :
				// 상좌우
				dirList = Arrays.asList(new int[] {-1,0}, new int[] {0,-1}, new int[] {0,1});
				break;
			case 5 :
				// 상하좌우
				dirList = Arrays.asList(new int[] {-1,0}, new int[] {0,-1}, new int[] {0,1},new int[] {1,0});
				break;
			default:
				break;
			}
			rotate(this.dir);
		}
		private void rotate(int n) {
			for(int[] arr : this.dirList) {
				for(int i=0 ; i<n ; i++) {
					int num1 = arr[0];
					int num2 = arr[1];
					arr[0] = -num2;
					arr[1] = num1;
				}
			}
		}
		
		@Override
		public String toString() {
			return "<"+type+" : "+dir+" ("+row+","+col+")>";
		}
	}
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ret = Integer.MAX_VALUE;
		tvList = new ArrayList<>();
		map = new HashMap<>();
		map.put(1, 4);
		map.put(2, 2);
		map.put(3, 4);
		map.put(4, 4);
		map.put(5, 1);
		
		office = new int[N][M];
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {
				int num = Integer.parseInt(st.nextToken());
				office[i][j] = num;
				if(num>0 && num<6) {
					tvList.add(new CCTV(num, i, j));
				}
			}
		}
		List<CCTV> cctvList = new ArrayList<>();
		dfs(0, cctvList);
		System.out.println(ret);
	}
	
	private void dfs(int dep,List<CCTV> cctvList) {
		if(dep==tvList.size()) {
			int[][] copyOffi = copyOffi();
			for(CCTV cctv : cctvList)
				diffusion(copyOffi, cctv);
			int cnt = findBlindSpot(copyOffi);
			ret = Math.min(cnt, ret);
			return;
		}
		CCTV tv = tvList.get(dep);
		int type = tv.type;
		for(int i=0 ; i<map.get(type) ; i++) {
			CCTV cctv = new CCTV(tv.type,tv.row,tv.col,i);
			cctvList.add(cctv);
			dfs(dep+1,cctvList);
			cctvList.remove(cctvList.size()-1);
		}
	}
	
	private void diffusion(int[][] offi,CCTV cctv) {
		int row =  cctv.row;
		int col = cctv.col;
		offi[row][col] = 9;
		for(int[] arr : cctv.dirList) {
			int nRow = row + arr[0];
			int nCol = col + arr[1];
			while(inRange(nRow, nCol)) {
				if(offi[nRow][nCol]==6) {
					break;
				}
				if(offi[nRow][nCol]==0) {
					offi[nRow][nCol] = 9;
				}
				nRow += arr[0];
				nCol += arr[1];
			}
		}
	}
	
	private boolean inRange(int row, int col) {
		if(row>=0 && row<N && col>=0 && col<M)
			return true;
		return false;
	}
	
	private int[][] copyOffi(){
		int[][] ret = new int[N][M];
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				ret[i][j] = office[i][j];
			}
		}
		return ret;
	}
	
	private int findBlindSpot(int[][] offi) {
		int cnt = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				if(offi[i][j]==0)
					cnt++;
			}
		}
		return cnt;
	}
	
}

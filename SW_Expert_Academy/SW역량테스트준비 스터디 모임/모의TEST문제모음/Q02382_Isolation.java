package 모의TEST문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q02382_Isolation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Q02382_Isolation a = new Q02382_Isolation();
		a.solution();
	}
	class Group{
		int num;
		int row;
		int col;
		int dir;
		public Group(int num, int row, int col, int dir) {
			this.num = num;
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "["+row+", "+col+"] : ("+num+")"+"dir:"+dir;
		}
		
	}
	int N = 0;
	int M = 0;
	int K = 0;
	int[][] dirs = {
			//		상		하		좌	     우
			null, {-1,0}, {1,0}, {0,-1}, {0,1}	
	};
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=testCase ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 전체 셀판 크기
			M = Integer.parseInt(st.nextToken());	// M시간까지 진행
			K = Integer.parseInt(st.nextToken());	// K개의 군집
			
			List<Group> list = new ArrayList<>();
			for(int i=0 ; i<K ; i++) {
				st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir= Integer.parseInt(st.nextToken());
				list.add(new Group(num, row, col, dir));
			}
			int time = 1;
			while(time<=M) {
//				System.out.println("<"+time+">");
				// move
				move(list);
				// Edge
				checkEdge(list);
				// chkMerge
				chkMerge(list);
				time++;
			}
			int ret = sumNum(list);
			
			bw.write("#"+tc+" "+ret+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	private int sumNum(List<Group> list) {
		int sum = 0;
		for(int i=0 ; i<list.size() ; i++) {
			sum += list.get(i).num;
		}
		return sum;
	}
	
	private void move(List<Group> list) {
		for(int i=0 ; i<list.size() ; i++) {
			list.get(i).row += dirs[list.get(i).dir][0];
			list.get(i).col += dirs[list.get(i).dir][1];
		}
	}
	
	private void chkMerge(List<Group> list) {
		list.sort(comp);	// 좌표순으로 정렬
//		System.out.println("chkMerge안");
//		printList(list);
		for(int i=list.size()-1 ; i>0 ; i--){
			for(int j=i-1 ; j>=0 ; j--) {
				if(list.get(i).row==list.get(j).row && list.get(i).col==list.get(j).col) {
					if(j==0) {
						merge(list,j+1,i);
						i=j+1;
					}
					continue;
				}else {
					merge(list,j+1,i);
//					System.out.println(j+1+"~"+i+" : merge 직후");
//					printList(list);
					i = j+1;
					break;
				}
			}
		}
	}
	private void merge(List<Group> list, int startIdx, int endIdx) {
		if(endIdx-startIdx<1)
			return;
		int maxNum = Integer.MIN_VALUE;
		int maxIdx = -1;
		int row = list.get(startIdx).row;
		int col = list.get(startIdx).col;
		
		int newNum = 0;
		for(int i=startIdx ; i<=endIdx ; i++) {
			newNum += list.get(i).num;
			if(list.get(i).num>maxNum) {
				maxNum = list.get(i).num;
				maxIdx = i;
			}
		}
		Group nG = new Group(newNum,row,col,list.get(maxIdx).dir);
		for(int i=startIdx ; i<=endIdx ; i++) {
			list.remove(startIdx);
		}
		list.add(startIdx,nG);
		return;
	}
	
	private void checkEdge(List<Group> list) {
		for(int i=0 ; i<list.size() ; i++) {
			Group g = list.get(i);
			int row = g.row;
			int col = g.col;
			// 가장 자리 도착시 인구 절반 & 방향 반대
			if(row==0 || row==N-1 || col==0 || col==N-1) {
				if(g.num==1) {
					list.remove(i);
					i--;
					continue;
				}
				g.num /= 2;	// 인구 절반
				// 방향 반대
				if(g.dir%2==1) {
					g.dir += 1;
				}else {
					g.dir -= 1;
				}
			}
		}
	}
	Comparator<Group> comp = new Comparator<Group>() {
		@Override
		public int compare(Group o1, Group o2) {
			if(o1.row!=o2.row) {
				return o1.row-o2.row;
			}
			return o1.col-o2.col;
		}
	};
	private void printList(List<Group> list) {
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i));
		}
	}
}

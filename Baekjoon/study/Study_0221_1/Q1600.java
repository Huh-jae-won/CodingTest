package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1600 {
	static int K;
	static int W;
	static int H;
	static int[][] map;
	static Queue<Node> q;
	static boolean[][] flag;
	static int[] dh = {-2, -1,  1,  2,  2,  1, -1, -2};
	static int[] dw = { 1,  2,  2,  1, -2, -1, -1, -2};
	
	// 상하좌우
	static int[] dx = {-1,  1,  0,  0};
	static int[] dy = { 0,  0, -1,  1};
	
	static class Node{
		int pos_h;
		int pos_w;
		int time;
		int cnt;
		Node(int pos_h,int pos_w,int time,int cnt){
			this.pos_h = pos_h;
			this.pos_w = pos_w;
			this.time = time;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		q = new LinkedList();
		map = new int[H][W];
		flag = new boolean[H][W];
		q.add(new Node(0,0,0,0));
		bfs();
	}
	static void bfs() {
		Node temp = null;
		int minTime = Integer.MAX_VALUE;
		int time = 0;
		while(q.isEmpty()==false) {
			temp = q.poll();
			
			if(temp.pos_h==H-1 && temp.pos_w==W-1) {
				minTime = Math.min(minTime, temp.time);
				if(minTime!=temp.time) {
					// 다른길을 찾았으나 더 오래걸렸으면 이전것이 최소시간이므로 break;
					break;
				}
			}
			
			flag[temp.pos_h][temp.pos_w] = true;
			
			int[] next = new int[2];
			if(temp.cnt<K) {
				for(int i=0 ; i<8 ; i++) {
					move(next,temp,i);
					if(next[0]*next[1]!=0 && !flag[next[0]][next[1]] && map[next[0]][next[1]]!=1 ) {
						q.add(new Node(next[0],next[1],temp.time+1,temp.cnt+1));
					}
				}
			}else {
				for(int i=0 ; i<4 ; i++) {
					move(next,temp,i);
					if(next[0]*next[1]!=0 && !flag[next[0]][next[1]] && map[next[0]][next[1]]!=1 ) {
						q.add(new Node(next[0],next[1],temp.time+1,temp.cnt+1));
					}
				}
			}
		}
		System.out.println(minTime);
	}
	static void move(int[] next, Node node, int i) {
		if(node.cnt<K) {
			int nextH = node.pos_h + dh[i];
			int nextW = node.pos_w + dw[i];
			if(nextH>-1 && nextH<H)
				next[0] = nextH;
			else
				next[0] = 0;
			if(nextW>-1 && nextW<W)
				next[1] = nextW;
			else
				next[1] = 0;
		}else {
			int nextH = node.pos_h + dx[i];
			int nextW = node.pos_w + dy[i];
			if(nextH>-1 && nextH<H)
				next[0] = nextH;
			else
				next[0] = 0;
			if(nextW>-1 && nextW<W)
				next[1] = nextW;
			else
				next[1] = 0;
		}
	}
	
	
}

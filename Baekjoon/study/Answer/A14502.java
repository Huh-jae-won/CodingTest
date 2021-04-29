package Answer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A14502 {
   static int N, M;
   static int[][] map;
   static int[][] origin;
   static Queue<Node> q;
   static int[] dx = {-1,0,1,0};
   static int[] dy = {0,1,0,-1};
   static int answer = Integer.MIN_VALUE;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      N = sc.nextInt();
      M = sc.nextInt();
      
      origin = new int[N][M];
      map = new int[N][M];
      q = new LinkedList<>();
      
      for(int i = 0; i < N; i++) {
         for(int j = 0; j < M; j++) {
            map[i][j] = sc.nextInt();
            origin[i][j] = map[i][j];
            if(map[i][j] == 2) q.add(new Node(i,j));
         }
      }
      
      dfs(0,0,0);
      
      System.out.println(answer);
   }
   
   static void bfs() {
      Queue<Node> queue = new LinkedList<>();
      for(int i = 0; i < q.size(); i++) {
         queue.add(q.peek());
         q.add(q.poll());
      }
      while(!queue.isEmpty()) {
         Node now = queue.poll();
         
         int i = now.i;
         int j = now.j;
         
         for(int dir = 0; dir < 4; dir++) {
            int ni = i + dx[dir];
            int nj = j + dy[dir];
            if(ni < 0 || nj < 0 || ni > N - 1 || nj > M - 1) continue;
            if(map[ni][nj] != 0) continue;
            map[ni][nj] = 2;
            queue.add(new Node(ni,nj));
         }
      }
   }
   
   static void dfs(int si, int sj, int depth) {
      if(depth == 3) {
         int cnt = 0;
         for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
               map[i][j] = origin[i][j];
            }
         }
         
         bfs();
         
         for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
               if(map[i][j] == 0) cnt++;
            }
         }
         answer = Math.max(answer, cnt);
         return;
      }
      
      for(int i = si; i < N; i++) {
         for(int j = sj; j < M; j++) {
            if(origin[i][j] != 0) continue;
            origin[i][j] = 1;
            dfs(i, j+1, depth+1);
            origin[i][j] = 0;
         }
         sj = 0;
      }
   }
   
   static class Node{
      int i,j;
      public Node(int i, int j) {
         super();
         this.i = i;
         this.j = j;
      }
      
   }
}
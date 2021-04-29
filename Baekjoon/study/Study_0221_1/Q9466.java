package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q9466 {
	static int T;
	static int N;
	static int[] student;
	static ArrayList<Integer> team;
	static boolean[] flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int tc=1 ; tc<=T ; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			student = new int[N+1];
			team = new ArrayList();
			flag = new boolean[N+1];
		
			st = new StringTokenizer(br.readLine());
			for(int i=1 ; i<N+1 ; i++) {
				student[i] = Integer.parseInt(st.nextToken());
			}
			
//			System.out.println();
			for(int i=1 ; i<N+1 ; i++) {
				team.add(i);
				if(!flag[i])
					makeTeam();
				init();
			}
			System.out.println(cntFlag());
		}
	}
	static void makeTeam() {
		int indx = 0;
		while(true) {
			if(indx!=0 && team.get(0)==team.get(team.size()-1)) {
				// 처음과 마지막이 같은 수 -> 팀
//				System.out.println(team);
				changeFlag();
				break;
			}else if(indx!=0 && team.get(team.size()-2)==team.get(team.size()-1)) {
				// 끝 두 수가 같음 -> 팀 불가 -> flag=false;
				flag[team.get(team.size()-1)] = true;
//				System.out.println("** : "+team);
				break;
			}else {
				team.add(student[team.get(indx++)]);
			}
			if(indx>N)
				break;
		}
	}
	static int cntFlag() {
		int cnt = N;
		for(int i=1 ; i<flag.length ; i++) {
			if(flag[i])
				cnt--;
		}
		return cnt;
	}
	static void changeFlag() {
		int cnt = N;
		for(int i=0 ; i<team.size() ; i++) {
			int indx = team.get(i);
			flag[indx] = true;
		}
	}
	static void init() {
		int length = team.size();
		for(int i=0 ; i<length ; i++) {
			team.remove(0);
		}
	}

}

package Study_0221_1;

import java.util.ArrayList;
import java.util.Scanner;


public class Q2226 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		N = sc.nextInt();
		int result;
		change(list,1);
		result = count(list); 
//		System.out.println(list);
		System.out.println(result);
		
		
	}
	static int count(ArrayList<Integer> list) {
		int cnt = 0;
		int length = list.size();
		int bef_state=0;
		int cur_state;
		int indx = 10000;
		for(int i=0 ; i<length ; i++) {
			if(list.get(i)==0) {
				indx = i;
				break;
			}
		}
		
		for(int i=indx+1 ; i<length ; i++) {
			if(list.get(i)==1)
				cur_state = 1;
			else
				cur_state = 0;
			if(bef_state==0 && cur_state==1)
				cnt++;
			bef_state = cur_state;
		}
		return cnt;
		
		
	}
	
	static void change(ArrayList<Integer> list,int dep) {
		if(dep==N) {
			return;
		}
		else {
			int length = list.size();
			for(int i=0 ; i<length ; i++) {
				if(list.get(0)==1) {
					list.add(0);
					list.add(1);
				}else {
					list.add(1);
					list.add(0);
				}
				list.remove(0);
			}
			change(list,dep+1);
		}
	}
}


package Step14_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N09_Q10814 {
	static class Member implements Comparable<Member>{
		int age;
		String name;
		int indx;
		Member(int age, String name,int indx){
			this.age = age;
			this.name = name;
			this.indx = indx;
		}
		
		public int compareTo(Member member) {
			if(this.age<member.age) {
				return -1;
			}else if (this.age==member.age) {
				if(this.indx<member.indx) {
					return -1;
				}else
					return 1;
			}else {
				return 1;
			}
		}
	}
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Member[] arr = new Member[N];
		StringTokenizer st;
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String temp = null;
			temp = st.nextToken();
			arr[i] = new Member(age,temp,i);
		}
		Arrays.sort(arr);
		for(int i=0 ; i<N ; i++) {
			System.out.println(arr[i].age+" "+arr[i].name);
		}
	}

}

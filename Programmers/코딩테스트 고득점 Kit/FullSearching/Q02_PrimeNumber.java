package FullSearching;

import java.util.HashSet;
import java.util.Set;

public class Q02_PrimeNumber {
	public static void main(String[] args) {
		Q02_PrimeNumber a = new Q02_PrimeNumber();
//		String numbers = "17";
		String numbers = "011";
		
		System.out.println(a.prime(numbers));
	}
	public int prime(String numbers) {
		boolean[] visited = new boolean[numbers.length()];
		Set<Integer> set = new HashSet<>();
		dfs(set,"",numbers,visited);
		return set.size();
	}
	private void dfs(Set<Integer> set,String str, String numbers,boolean[] visited) {
		if(!str.equals("")) {
			System.out.println("num : "+str);
			if(chk(str)) {
				set.add(Integer.parseInt(str));
				System.out.println("set : "+set);
			}
		}
		for(int i=0 ; i<numbers.length() ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(set,str+numbers.charAt(i),numbers,visited);
				visited[i] = false;
			}
		}
	}
	private boolean chk(String str) {
		int num = Integer.parseInt(str);
		if(num==1||num==0)
			return false;
//		System.out.println("pow : "+Math.pow(num, 0.5));
		for(int i=2 ; i<=(int) Math.pow(num, 0.5) ; i++) {
			if(num%i==0)
				return false;
		}
		return true;
	}

}

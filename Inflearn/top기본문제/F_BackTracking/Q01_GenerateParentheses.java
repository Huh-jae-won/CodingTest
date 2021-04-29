package F_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Q01_GenerateParentheses {
	public static void main(String[] args) {
		Q01_GenerateParentheses a = new Q01_GenerateParentheses();
		
		System.out.println(a.generate(3));
		System.out.println(a.solution(3));
	}
	public List<String> solution(int n){
		List<String> ret = new ArrayList<>();
		sol_dfs(ret,"",n,n,"");
		return ret;
	}
	private void sol_dfs(List<String> ret, String str, int left, int right, String test) {
		if(left<0 || right<0 || left>right)
			return;
		if(left==0 && right==0) {
			ret.add(str); 
		}
		sol_dfs(ret,str+"(",left-1,right,test+"+");
		sol_dfs(ret,str+")",left,right-1,test+"-");
	}
	
	//////////////////////////////////////////////////
	public List<String> generate(int n) {
		List<String> list = new ArrayList<String>();
		dfs(list,n,0,"");
		return list;
	 }
	private void dfs(List<String> list,int n, int dep, String str) {
		if(str.length()==n*2 && dep==0) {
			list.add(str);
			System.out.println(list.size()+" : "+str);
			return ;
		}
		if(dep<0 || dep>n || str.length()>n*2)
			return ;
		dfs(list,n,dep+1,str+"(");
		dfs(list,n,dep-1,str+")");
		return ;
	}
}

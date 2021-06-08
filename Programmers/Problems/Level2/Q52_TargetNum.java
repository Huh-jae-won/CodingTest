package Level2;

import java.util.HashSet;
import java.util.Set;

public class Q52_TargetNum {
	public static void main(String[] args) {
		Q52_TargetNum a = new Q52_TargetNum();
		
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		a.solution(numbers, target);
		System.out.println(ret);
	}
    public int solution(int[] numbers, int target) {
		Set<String> set = new HashSet<>();
		dfs(set,numbers,0,0,target,"");
		return ret;
	}
    static int ret = 0;
	private void dfs(Set<String> set,int[] numbers,int dep,int sum,int target,String str) {
		if(dep==numbers.length) {
//				System.out.println(str);
			if(target==sum && !set.contains(str)) {
				set.add(str+"");
//					System.out.println(str);
				ret++;
			}
			return;
		}
			dfs(set,numbers,dep+1,sum+numbers[dep],target,str+"+"+numbers[dep]);
			dfs(set,numbers,dep+1,sum-numbers[dep],target,str+"-"+numbers[dep]);
		return ;
	}

}

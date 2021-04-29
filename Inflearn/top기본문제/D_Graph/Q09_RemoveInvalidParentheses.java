package D_Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
// 못품 -> bfs로 풀어라!
public class Q09_RemoveInvalidParentheses {
	public static void main(String[] args) {
		String str = "\"(a)())()";
		Q09_RemoveInvalidParentheses q09 = new Q09_RemoveInvalidParentheses();
		System.out.println(q09.solution(str));
	}
	public List<String> solution(String s){
		List<String> ret = new ArrayList<>();
		if(s.equals(null))
			return ret;
		Queue<String> q = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		String bracket = "({[<)}]>";
		q.offer(s);
		visited.add(s);
		
		boolean found = false;
		
		while(!q.isEmpty() ) {
			int size = q.size();
			for(int i=0 ; i<size ; i++) {
				String str = q.poll();
				if(isValid(str)) {
					ret.add(str);
					found = true;
				}
				if(found)
					continue;
				// 하나 뺴서 다시 q에 넣기
				for(int j=0 ; j<str.length() ; j++) {
					// 문자는 skip해야함
					if(!bracket.contains(String.valueOf(str.charAt(j)))) {
						continue;
					}
					// j만 빼고 newStr 생성하고 q에 넣음
					String newStr = str.substring(0,j) + str.substring(j+1);
					if(!visited.contains(newStr)) {
						q.offer(newStr);
						visited.add(newStr);
					}
				}
			}
		}
		return ret;
	}
	private boolean isValid(String str) {
		int count = 0;
		for(char ch : str.toCharArray()) {
			if(ch=='(' || ch=='{' || ch=='[' || ch=='<') {
				count++;
			}else if (ch==')' || ch=='}' || ch==']' || ch=='>') {
				count--;
				if(count<0)
					return false;
			}
		}
		return count==0;
	}

}

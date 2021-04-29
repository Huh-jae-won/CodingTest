package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Q03_WordTransformation {
	public static void main(String[] args) {
		Q03_WordTransformation a = new Q03_WordTransformation();
		
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(a.transform(begin, target, words));
	}
	public int transform(String begin, String target, String[] words) {
//		'a' : 97, 'z' : 122
		Queue<String> q = new LinkedList<>();
		boolean[] visited = new boolean[words.length];
		q.add(begin);
		int ret = 0;
		while(!q.isEmpty()) {
//			System.out.println(ret+" : "+q);
			if(q.contains(target))
				return ret;
			int size = q.size();
			ret++;
			for(int i=0 ; i<size ; i++) {
				String str = q.poll();
				for(int j=0 ; j<words.length ; j++) {
					if(str.equals(words[j]))
						visited[j] = true;
				}
				for(int j=0 ; j<words.length ; j++) {
					if(chkStr(str,words[j]) && !visited[j]) {
						q.add(new String(words[j]));
					}
				}
			}
		}
		return 0;
	}
	private boolean chkStr(String str,String compare) {
		int count = 0;
		for(int i=0 ; i<str.length() ; i++) {
			if(str.charAt(i)==compare.charAt(i)) {
				count++;
				if(count==str.length()-1)
					return true;
			}
		}
		return false;
	}

}

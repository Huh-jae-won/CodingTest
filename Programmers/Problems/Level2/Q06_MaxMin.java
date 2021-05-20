package Level2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q06_MaxMin {

	public static void main(String[] args) {
		Q06_MaxMin a = new Q06_MaxMin();
		String s = "1 2 3 4";
		String ret = a.solution(s);
		System.out.println(ret);
	}
    public String solution(String s) {
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(null);
        String answer = list.get(0)+" "+list.get(list.size()-1);
        return answer;
    }

}

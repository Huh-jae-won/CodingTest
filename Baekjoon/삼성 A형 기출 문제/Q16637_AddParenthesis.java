import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q16637_AddParenthesis {
	public static void main(String[] args) throws IOException {
		Q16637_AddParenthesis z = new Q16637_AddParenthesis();
		
		z.solution();
	}
	int ret = 0;
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ret = Integer.MIN_VALUE;
		String str = br.readLine();
		List<String> aaa = makeList(str);
//		System.out.println(aaa);
		List<String> list = new ArrayList<>();
		List<Integer> parenList = new ArrayList<>();
		int cnt = str.length()-str.length()/2;
		dfs(str, cnt, 0, -2, parenList);
		System.out.println(ret);
	}
	private void dfs(String str, int cnt, int dep, int befo, List<Integer>parenList) {
		if(dep<=cnt) {
			int idx = 0;
			StringBuilder sb = new StringBuilder();
			for(int parenIdx : parenList) {
				for(int i=idx ; i<parenIdx ; i++) {
					sb.append(str.charAt(i));
				}
				int temp = calc(makeList(str.substring(parenIdx,parenIdx+3)));
				sb.append(temp);
				idx = parenIdx+3;
			}
			sb.append(str.substring(idx));
			List<String> lastList = makeList(sb.toString());
			int sum = calc(lastList);
//			System.out.println(parenList+" : "+sb+" sum: "+sum);
			ret = Math.max(ret,sum);
			
		}else {
			return;
		}
		for(int i=befo+2 ; i<str.length()-1 ; i+=2) {
			if(!parenList.contains(i) && !parenList.contains(i-2)) {
				parenList.add(i);
				dfs(str, cnt, dep+1, i, parenList);
				parenList.remove(parenList.size()-1);
			}
		}
	}
	private int calc(List<String> list) {
		int sum = Integer.parseInt(list.get(0));
		int num = 0;
		for(int i=1 ; i<list.size() ; i+=2) {
			String temp = list.get(i);
			switch (list.get(i)) {
			case "+" :
				sum += Integer.parseInt(list.get(i+1));
				break;
			case "-" :
				sum -= Integer.parseInt(list.get(i+1));
				break;
			case "*" :
				sum *= Integer.parseInt(list.get(i+1));
				break;
			default:
				break;
			}
		}
		return sum;
	}
	private List<String> makeList(String str){
		List<String> ret = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<str.length() ; i++) {
			char ch = str.charAt(i);
			if(!isOperator(str, i)) {
				// 연산자가 아닌경우
				sb.append(ch);
			}else {
				ret.add(sb.toString());
				ret.add(String.valueOf(ch));
				sb = new StringBuilder();
			}
		}
		if(sb.length()!=0)
			ret.add(sb.toString());
//		System.out.println("mL : "+ret);
		return ret;
	}
	private boolean isOperator(String str,int idx) {
		String comp = "+-*/";
		if(str.substring(idx,idx+1).matches("[0-9]")) {
			// 숫자인 경우
			return false;
		}
		if(idx==0) {
			// str의 시작인 경우
			return false;
		}
		if(!comp.contains(str.substring(idx-1,idx))) {
			// idx 앞이  숫자인 경우
			return true;
		}
		return false;
	}
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Q14888_OperatorInsertion {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q14888_OperatorInsertion z = new Q14888_OperatorInsertion();
		z.solution();
	}
	int[] ope;
	int[] num;
	int N = 0;
	int minRet = 0;
	int maxRet = 0;
	Map<Integer,String> opeMap;
	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		minRet = Integer.MAX_VALUE;
		maxRet = Integer.MIN_VALUE;
		num = new int[N];
		ope = new int[4];
		opeMap = new HashMap<>();
		opeMap.put(0, "+");
		opeMap.put(1, "-");
		opeMap.put(2, "x");
		opeMap.put(3, "/");
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<4 ; i++) {
			ope[i] = Integer.parseInt(st.nextToken());
		}
		int[] count = new int[4];
		dfs(0, count,"");
		System.out.println(maxRet);
		System.out.println(minRet);
	}
	private void dfs(int dep,int[] count,String log) {
		if(dep==N-1) {
//			System.out.println(log);
			calc(log);
			return;
		}
		for(int i=0 ; i<4 ; i++) {
			if(count[i]<ope[i]) {
				count[i]++;
				dfs(dep+1, count,log+opeMap.get(i)+" ");
				count[i]--;
			}
		}
	}
	
	private void calc(String log) {
		StringTokenizer st = new StringTokenizer(log);
		int ret = num[0];
		int idx = 1;
		while(st.hasMoreTokens()) {
			String ope = st.nextToken();
			int sec = num[idx];
			switch (ope) {
			case "+":
				ret += sec;
				break;
			case "-":
				ret -= sec;
				break;
			case "x":
				ret *= sec;
				break;
			case "/":
				if(ret>=0) {
					ret /= sec;
				}else {
					int temp = (-ret)/sec;
					ret = -temp;
				}
				break;
			default:
				break;
			}
			idx++;
		}
//		System.out.println("ret : "+ret);
		minRet = Math.min(ret, minRet);
		maxRet = Math.max(ret, maxRet);
	}
	
}

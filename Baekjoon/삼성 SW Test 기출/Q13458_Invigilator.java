import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13458_Invigilator {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q13458_Invigilator z = new Q13458_Invigilator();
		z.solution();
	}
	int N = 0;
	int[] room;
	int B = 0;
	int C = 0;
	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		room = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		long ret = 0; 
		for(int i=0 ; i<N ; i++) {
			if(room[i]>0) {
				room[i] -= B;
				ret++;
			}
			if(room[i]<=0)
				continue;
			int div = room[i] / C;
			ret += div;
			int mod = room[i] % C;
			if(mod!=0)
				ret += 1;
		}
		System.out.println(ret);
	}
}

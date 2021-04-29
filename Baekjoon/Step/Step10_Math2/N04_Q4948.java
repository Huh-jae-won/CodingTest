package Step10_Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N04_Q4948 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine().trim());
		while(M!=0) {
			int N = 2*M;
			int cnt = 0;
			for(int i=M+1 ; i<=N ; i++) {
				if(findNum(i))
					cnt++;
			}
			System.out.println(cnt);
			
			M = Integer.parseInt(br.readLine().trim());
		}
	}
	static boolean findNum(int num) {
		boolean flag = true;
		if(num==1)
			return false;
		for(int i=2 ; i<=(int)Math.pow(num, 0.5) ;i++) {
			if(num%i==0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}

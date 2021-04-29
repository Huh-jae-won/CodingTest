package Study_0221_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {
	static int N;
	static int[] numArr;
	static int[] operator;
	static int max;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		numArr = new int[N];
		operator = new int[4];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<4 ; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		// ÀÔ·Â ³¡
		dfs(0,numArr[0],"");
		System.out.println(max);
		System.out.println(min);
		
	}
	static int calc(int indx,int befNum, int ope) {
		int nextNum = numArr[indx+1];
		int num = 0;
		switch (ope) {
		case 0 :	// +
			num = befNum + nextNum;
			break;
		case 1 :	// -
			num = befNum - nextNum;
			break;
		case 2 :	// *
			num = befNum * nextNum;
			break;
		case 3 :	// / 
			if(befNum<0) {
				num = befNum*(-1) / nextNum;
				num *= -1;
			}else {
				num = befNum / nextNum;
			}
			
			break;
		default:
			break;
		}
		return num;
	}
	
	static void dfs(int cnt,int befNum,String str) {
		int calNum = 0;
		String temp = "";
		if(cnt==N-1) {
//			System.out.print(str+numArr[N-1]);
//			System.out.println(" = " + befNum);
			min = Math.min(min, befNum);
			max = Math.max(max, befNum);
			return;
		}
		for(int i=0 ; i<4 ; i++) {
			if(operator[i]>0) {
				operator[i]--;
				calNum = calc(cnt,befNum,i);
				temp = operator(cnt,i);
				dfs(cnt+1,calNum,str+numArr[cnt]+" "+temp+" ");
				operator[i]++;
			}
		}
	}
	
	static String operator(int indx, int ope) {
		String str = "";
		switch (ope) {
		case 0 :
			str = "+";
			break;
		case 1 :
			str = "-";
			break;
		case 2 :
			str = "x";
			break;
		case 3 :
			str = "/";
			break;

		default:
			break;
		}
		return str;
	}

}

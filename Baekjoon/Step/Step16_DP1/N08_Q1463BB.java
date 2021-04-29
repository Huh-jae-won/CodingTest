package Step16_DP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N08_Q1463BB {
	static int N;
	static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	N = Integer.parseInt(br.readLine());
    	arr = new int[N+1];
    	dp();
    	bw.write(arr[1]+"\n");
    	bw.flush();
    	br.close();
    	bw.close();
    }
    static void count(int indx) {
		if(indx%2==0) {
			if(arr[indx/2]==0 || arr[indx/2]>arr[indx]+1) {
				arr[indx/2] = arr[indx] + 1;
			}
		}
		if(indx%3==0) {
			if(arr[indx/3]==0 || arr[indx/3]>arr[indx]+1) {
				arr[indx/3] = arr[indx] + 1;
			}
		}
		if(indx!=1) {
			if(arr[indx-1]==0 || arr[indx-1]>arr[indx]+1) {
				arr[indx-1] = arr[indx] + 1;
			}
		}
    }
    static void dp() {
    	if(N%2==0 && N-1!=N/2) {
			arr[N/2]++;
		}
		if(N%3==0) {
			arr[N/3]++;
		}
		if(N>1) {
			arr[N-1]++;
		}
		for(int i=N-1 ; i>0 ; i--) {
			count(i);
		}
    }
}


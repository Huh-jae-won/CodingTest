package Level2;

public class Q01_LCM {
	public static void main(String[] args) {
		Q01_LCM a = new Q01_LCM();
		int[] arr = {2,6,8,14};
		int ret = a.solution(arr);
		System.out.println(ret);
	}
    public int solution(int[] arr) {
        int answer = 0;
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0 ; i<len ; i++){
            if(arr[i]>max)
                max = arr[i];
        }
        int temp = 1;
        while(true){
            int num = temp*max;
            int cnt = 0;
            for(int i=0 ; i<len ; i++){
                if(num%arr[i]!=0){
//                  안 나눠짐
                    break;                    
                }else{
                    cnt++;
                }
            }
            if(cnt==len){
                return num;
            }
            temp++;
        }        
    }
}

package Level1;

public class Q05_TrainingCloth {

	public static void main(String[] args) {
		Q05_TrainingCloth a = new Q05_TrainingCloth();
		int n= 5;
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		System.out.println("ret : "+a.cloth(n,lost,reserve));
	}
    public int cloth(int n, int[] lost, int[] reserve) {
        int[] student = new int[n+1];
        
        student[0] = -1;
        for(int i=1 ; i<student.length ; i++){
            student[i] = 1;
        }
        for(int i=0 ; i<reserve.length ; i++){
            student[reserve[i]] += 1;
        }
        for(int i=0 ; i<lost.length ; i++){
            student[lost[i]] -= 1;
        }
        
         printArr(student);
        dfs(n,student,1);

        return max;
    }
    static int max = 0;
    private void dfs(int n,int[] stu,int indx){
        // System.out.print(indx+" : ");
        // printArr(stu);
        if( indx>=1 && indx<=n ){
            if(stu[indx]==2){
                if(stu[indx-1]==0){
                    // 본인 앞 확인
                    // System.out.println("-1");
                    stu[indx]--;
                    stu[indx-1]++;
                    dfs(n,stu,indx+1);
                    // 원복
                    stu[indx]++;
                    stu[indx-1]--;
                }
                if(indx<=n-1 && stu[indx+1]==0){
                    // 본인 뒤 확인
                    // System.out.println("1");
                    stu[indx]--;
                    stu[indx+1]++;
                    dfs(n,stu,indx+1);
                    // 원복
                    stu[indx]++;
                    stu[indx+1]--;
                }
                dfs(n,stu,indx+1);
            }else {
                dfs(n,stu,indx+1);
            }
        }else{
            // System.out.print(indx+" finish ");
            // printArr(stu);
            max = Math.max(max,countStudent(stu));
            return;
        }
        //     max = Math.max(max,countStudent(stu));
        // return;
    }
    private int countStudent(int[] arr){
        int ret = 0;
        for(int i=1 ; i<arr.length ; i++){
            if(arr[i]>0)
                ret++;
        }
        return ret;
    }
    static void printArr(int[] arr){
        for(int i=1 ; i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}


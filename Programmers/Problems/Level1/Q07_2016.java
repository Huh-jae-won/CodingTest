package Level1;

public class Q07_2016 {
	public static void main(String[] args) {
		Q07_2016 a = new Q07_2016();
		System.out.println("ret : "+a.year(5,24));
	}
    public String year(int a, int b) {
        String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] month = {0,31,29,31,30,31,30,31,31,30,31,30};
                     //   금, 토, 일, 월, 화, 수, 목
//         int[] dayday = {1,  2, 3,  4, 5,  6, 7};
        int sum = 0;
        for(int i=1 ; i<a ; i++){
            sum += month[i];
        }
        int ret = (sum+b)%7;
        // System.out.println(ret);
        return day[ret];
    }

}

public class Naver_01 {
	public static void main(String[] args) {
		boolean flag = true;
		int n = 7;
		int[] p = {6, 2, 1, 0, 2, 4, 3};
		int[] c = {3, 6, 6, 2, 3, 7, 6};
		double price = 100.00;
		int remain = 0;
		int fail = 0;
		double money = 0.00;
		double result = 0.00;
		for(int i=0 ; i<n ; i++) {
			if(fail==3) {
				flag = false;
				result = money/(i);
				break;
			}
			if(remain+p[i]>=c[i]) {
				money += price*c[i];
				remain = remain+p[i]-c[i];
				price = 100;
				fail = 0;
			}else {
				remain += p[i];
				fail ++;
				price /= 2;
			}
		}
		if(flag) {
			result = money/n;
		}
		String str = String.format("%.2f", result);
	}

}

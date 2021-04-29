import java.util.ArrayList;

public class Naver_03 {
	static ArrayList<Integer> list;
//						0,1,2,3,4,5,6,7,8,9
	static int[] num = {6,2,5,5,4,5,6,3,7,6};
	public static void main(String[] args) {
		int k = 11;
		list = new ArrayList();
		dfs(k,"");
		System.out.println(list);
		System.out.println(list.size());
	}
	static void dfs(int remain,String str) {
		if(remain<=1) {
			if(remain==0) {
				if(!list.contains(str)) {
					if(str.charAt(0)=='0' && str.length()>1) {
						
					}else {
						list.add(Integer.parseInt(str));
					}
				}
			}
		}else {
			for(int i=0 ; i<num.length ; i++) {
				if(remain>=num[i]) {
					remain -= num[i];
					dfs(remain,str+i);
					remain += num[i];
				}
			}
		}
	}

}

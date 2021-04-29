package A_String_Array;
import java.util.HashSet;
import java.util.Set;

public class Q07_Jewels {
	public static void main(String[] args) {
		String J = "aA";
		String S = "aAAbbbb";
		Q07_Jewels q07 = new Q07_Jewels();
		System.out.println(q07.jewel(J, S));
	}
	public int solution(String jew, String stone) {
//		1. ds
		Set<Character> set = new HashSet<>();
		for(char jewel : jew.toCharArray()) {
			set.add(jewel);
		}
		int cnt = 0;
		for(char s : stone.toCharArray()) {
			if(set.contains(s)) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public int jewel(String jew, String stone) {
		int cnt = 0;
		for(int i=0 ; i<jew.length() ; i++) {
			char ch = jew.charAt(i);
			for(int j=0 ; j<stone.length() ; j++) {
				if(ch==stone.charAt(j))
					cnt++;
			}
		}
		return cnt;
	 }

}

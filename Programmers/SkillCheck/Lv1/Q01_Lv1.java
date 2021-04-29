package Lv1;


public class Q01_Lv1 {

	public static void main(String[] args) {

	}
	public boolean solution(String s) {
		int numP = 0;
		int numY = 0;
		s = s.toLowerCase();
		for(int i=0 ; i<s.length() ; i++) {
			if(s.charAt(i)=='p')
				numP++;
			if(s.charAt(i)=='y')
				numY++;
		}
		return numP==numY;
	}

}

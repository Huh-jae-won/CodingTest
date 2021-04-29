package A_String_Array;

public class Q08_LicenseKey {
	public static void main(String[] args) {
		
		Q08_LicenseKey q08 = new Q08_LicenseKey();
		String S = "8F3Z-2e-9-waAB";
		int K = 4;
		System.out.println("my  : "+q08.licenseKeyFormatting(S, K));
		System.out.println("sol : "+q08.solution(S, K));
	}
	public String solution(String S, int K) {
		String str = S.replace("-", "");	// - Á¦°Å
		str = str.toUpperCase();
		int length = str.length();
		
		StringBuilder sb = new StringBuilder(str);
		int cnt=0;
		for(int i=K ; i<length ; i+=K) {
			sb.insert(length-i, "-");
		}
		return sb.toString();
	}
	
	public String licenseKeyFormatting(String S, int K) {
		String str = "";
		String ret = "";
		for(int i=0 ; i<S.length() ; i++) {
			char ch = S.charAt(i);
			if(ch!='-') {
				if(96<ch && ch<123) {
					ch -= 32;
				}
				str += ch;
			}
		}
		int div = str.length()%4;
		for(int i=0 ; i<str.length()-1 ; i++) {
			if(((i+1)-div)%4==0) {
				ret += str.charAt(i)+"-";
			}else {
				ret += str.charAt(i);
			}
		}
		ret += str.charAt(str.length()-1);
		return ret;
	}

}

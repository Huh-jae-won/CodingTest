import java.util.Scanner;

public class Kakao_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String new_id = sc.nextLine().trim();
		// 1단계
		new_id = step1(new_id);
		// 2단계
		new_id = step2(new_id);
//		System.out.println("2 "+new_id);
		// 3단계
		new_id = step3(new_id);
//		System.out.println("3 "+new_id);
		// 4단계
		new_id = step4(new_id);
//		System.out.println("4 "+new_id);
		// 5단계
		new_id = step5(new_id);
//		System.out.println("5 "+new_id);
		// 6단계
		new_id = step6(new_id);
//		System.out.println("6 "+new_id);
		// 7단계
		new_id = step7(new_id);
//		System.out.println("7 "+new_id);
		System.out.println(new_id);
	}
	static String step7(String name) {
		StringBuffer str = new StringBuffer(name);
		if(str.length()<3) {
			while(str.length()<3) {
				str.append(str.charAt(str.length()-1));
			}
		}
		return str.toString();
	}
	static String step6(String name) {
		StringBuffer str = new StringBuffer(name);
		if(str.length()>15) {
			str.replace(15, str.length(), "");
		}
		String ret = step4(str.toString());
		return ret;
	}
	static String step5(String name) {
		if(name.length()==0) {
			return "a";
		}
		return name;
	}
	static String step4(String name) {
		StringBuffer str = new StringBuffer(name);
		if(str.charAt(str.length()-1)=='.') {
			str.replace(str.length()-1, str.length(), "");
		}
		if(str.length()>0 && str.charAt(0)=='.') {
			str.replace(0, 1,"");
		}
		return str.toString();
	}
	static String step3(String name) {
		int length = name.length();
		StringBuffer str = new StringBuffer();
		str.append(name.charAt(0)+"");
		for(int i=1 ; i<length ; i++) {
			int befI = i-1;
			char ch = name.charAt(i);
			if(ch=='.' && ch==name.charAt(befI)) {
				continue;
			}
			str.append(ch);
		}
		return str.toString();
	}
	static String step2(String name) {
		int length = name.length();
		StringBuffer str = new StringBuffer();
		for(int i=0 ; i<length ;i++) {
			char ch = name.charAt(i);
			if((ch>=48&&ch<=57) ||ch==45 || ch==46 || ch==95 || (ch>=97 && ch<=122)){
				str.append(ch);
			}
		}
		return str.toString();
	}
	static String step1(String name) {
		String ret = name.toLowerCase();
		return ret;
	}

}

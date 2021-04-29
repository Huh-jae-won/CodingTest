package A_String_Array;

import java.util.HashSet;
import java.util.Set;

public class Q11_UniqueEmailAddress {

	public static void main(String[] args) {
		Q11_UniqueEmailAddress q11 = new Q11_UniqueEmailAddress();
		int N = 3;
		String[] in = new String[N];
		in[0] = "test.email+james@coding.com";
		in[1] = "test.e.mail+toto.jane@coding.com";
		in[2] = "testemail+tom@cod.ong.com";
//		int ret = q11.numUniqueEmails(in);
		int ret = q11.solution(in);
		System.out.println("===result===");
		System.out.println(ret);
	}
	public int solution(String[] emails) {
		int ret = 0;
		
		Set<String> set = new HashSet<>();
		
		for(String email : emails) {
			String localName = makeLocalName(email);	// 아이디 만들어줌
			String domainName = makeDomainName(email);	// 주소 만들어줌
			set.add(localName + "@" + domainName);
		}
		
		ret = set.size();
		return ret;
	}
	
	private String makeLocalName(String email) {
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<email.length() ; i++) {
			char ch = email.charAt(i);
			if(ch=='.')
				continue;
			if(ch=='+')
				break;
			if(ch=='@')
				break;
			sb.append(ch);
		}
		return sb.toString();
	}
	private String makeDomainName(String email) {
		int index = email.indexOf('@');
		return email.substring(index+1);
	}
	
	
	public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		for(int i=0 ; i<emails.length ; i++) {
			StringBuilder sb = new StringBuilder();
			int indx1 = emails[i].indexOf("+");
			int indx2 = emails[i].indexOf("@");
			for(int j=0 ; j<indx2 ; j++) {
				char ch = emails[i].charAt(j);
				// +뒷부분 걸러내기,  .생략하기
				if(ch=='.' && j<indx2 ||  -1<indx1 && indx1<=j && j<indx2) {
					continue;
				}
				sb.append(emails[i].charAt(j));
			}
			sb.append(emails[i].substring(indx2));
			System.out.println("after : "+sb);
			if(set.contains(sb.toString())) {
				System.out.println(i+" : 중복존재");
			}
			set.add(sb.toString());
		}
		int ret = set.size();
		return ret;
	}

}

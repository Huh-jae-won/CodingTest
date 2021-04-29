package F_BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q04_CombinationOfPhoneNum {

	public static void main(String[] args) {
		Q04_CombinationOfPhoneNum a = new Q04_CombinationOfPhoneNum();
//		System.out.println(a.combiOfPhoneNum("239"));
		System.out.println(a.solution("23"));
	}
	 public List<String> solution(String digits) {
		 String digitletter[] = {
				 "", "", "abc", "def", "ghi", 
				 "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
		 List<String> ret = new ArrayList<>();
		 if(digits.length()==0)
			 return ret;
		 
		 ret.add("");
		 for(int i=0 ; i<digits.length() ; i++) {
			 ret = combine(ret,digitletter[digits.charAt(i)-'0']); // char를 int형으로
		 }
		 return ret;
	 }
	 private List<String> combine(List<String> ret, String digit){
		 List<String> result = new ArrayList<>();
		 for(int i=0 ; i<digit.length() ; i++) {
			 for(String firstStr : ret) {
				 result.add(firstStr+digit.charAt(i));
			 }
		 }
		 return result;
	 }
	 /////////////////////////////////////////////////
	 public List<String> combiOfPhoneNum(String digits) {
		 List<String> ret = new ArrayList<>();
		 Queue<String> q = new LinkedList<>();
		 if(digits==null || digits.length()==0)
			 return ret;
		 String digitletter[] = {
				 "", "", "abc", "def", "ghi", 
				 "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
		 String[] word = new String[digits.length()];
		 for(int i=0 ; i<digits.length() ; i++) {
			 word[i] = digitletter[Integer.parseInt(digits.charAt(i)+"")];
		 }
		 // 첫번째 단어 철자마다 큐에 offer
		 for(int i=0 ; i<word[0].length() ; i++) {
			 q.offer(String.valueOf(word[0].charAt(i)));
		 }
		 int indx = 1;
		 while(!q.isEmpty()) {
			 int size = q.size();
			 for(int i=0 ; i<size ; i++) {
				 String temp = q.poll();
				 if(temp.length()==digits.length()) {
					 ret.add(temp);
					 continue;
				 }
				 for(int j=0 ; j<word[indx].length() ; j++) {
					 String add = temp+String.valueOf(word[indx].charAt(j));
					 q.offer(add);
				 }
			 }
			 indx++;
			 
		 }
		 System.out.println("Size : "+ret.size());
		 return ret;
	 }

}

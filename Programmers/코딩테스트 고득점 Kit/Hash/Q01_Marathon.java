package Hash;

import java.util.Arrays;
import java.util.HashMap;

public class Q01_Marathon {
	public static void main(String[] args) {
		Q01_Marathon a = new Q01_Marathon();
		
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion  = {"eden", "kiki"};
//		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};	;
//		String[] completion  = {"josipa", "filipa", "marina", "nikola"};
//		String[] participant = {"mislav", "stanko", "mislav", "ana"};
//		String[] completion  = {"stanko", "ana", "mislav"};
		System.out.println(a.findPerson(participant, completion));
		System.out.println(a.solution(participant, completion));
	}
	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> hm = new HashMap<>();
		for(String str : participant) {
			hm.put(str, hm.getOrDefault(str, 0)+1);
		}
		for(String str : completion) {
			hm.put(str, hm.get(str)-1);
		}
		for(String str : hm.keySet()) {
			if(hm.get(str)!=0)
				return str;
		}
		return null;
	}
	
	public String findPerson(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);
//		print(participant);
//		print(completion);
		for(int i=0 ; i<completion.length ; i++) {
			if(!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		return participant[completion.length];
	}
	
	static void print(String[] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

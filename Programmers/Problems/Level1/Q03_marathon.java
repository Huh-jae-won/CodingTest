package Level1;

import java.util.Arrays;

public class Q03_marathon {

	public static void main(String[] args) {
		Q03_marathon a = new Q03_marathon();
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println("ret : "+a.solution(participant, completion));
	}
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant); 
        Arrays.sort(completion);
        for(int i=0 ; i<completion.length ; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[completion.length];
    }

}

package Level2;

import java.util.Arrays;
import java.util.Comparator;

public class Q23_RescueBoat {
	public static void main(String[] args) {
		Q23_RescueBoat a = new Q23_RescueBoat();
		int[] people = {70,50,80,50};
		int limit = 100;
		int ret = a.solution(people, limit);
		System.out.println(ret);
	}
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        // System.out.println(Arrays.toString(people));
        int staIdx = 0;
        int endIdx = people.length-1;
        int ret = 0;
        while(staIdx<endIdx){
            if(people[staIdx]+people[endIdx]<=limit){
                // limit 범위 안
                staIdx++;
                endIdx--;
                ret++;
            }else{
                endIdx--;
                ret++;
            }
        }
        if(endIdx==staIdx)
            ret++;
        return ret;
    }
}

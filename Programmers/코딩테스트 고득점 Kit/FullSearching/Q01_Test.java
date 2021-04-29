package FullSearching;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q01_Test {
	public static void main(String[] args) {
		Q01_Test a = new Q01_Test();
//		int[] answers = {1,2,3,4,5};
//		int[] answers = {1,3,2,4,2};
		int[] answers = {5,4,3,2,1,1,2,3,4,5,5,4,3,2,1,1,1};
		
		a.mockTest(answers);
	}
	public int[] mockTest(int[] answers) {
		int len = answers.length;
		int[] ans = new int[len];
		int[][] people = new int[3][len]; //n행 : n번쨰 사람
		int[] num2 = {2,1,2,3,2,4,2,5};
		int[] num3 = {3,3,1,1,2,2,4,4,5,5};
		
		for(int i=0 ; i<len ; i++) {
			people[0][i] = (i%5)+1;
			people[1][i] = num2[i%(num2.length)];
			people[2][i] = num3[i%(num3.length)];
		}
		for(int i=0 ; i<len ; i++) {
			if(answers[i]==people[0][i])
				ans[0]++;
			if(answers[i]==people[1][i])
				ans[1]++;
			if(answers[i]==people[2][i])
				ans[2]++;
		}
		int maxScore = Math.max(ans[0], Math.max(ans[1], ans[2]));
		List<Integer> list = new ArrayList<>();
		for(int i=0 ; i<3 ; i++) {
			if(maxScore==ans[i])
				list.add(i);
		}
		int[] ret = new int[list.size()];
		for(int i=0 ; i<ret.length ; i++) {
			ret[i] = list.get(i)+1;
		}
		return ret;
	}

}

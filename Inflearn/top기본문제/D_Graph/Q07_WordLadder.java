package D_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Q07_WordLadder {

	public static void main(String[] args) {
		Q07_WordLadder q07 = new Q07_WordLadder();
		
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		
		String beginWord = "hit";
		String endWord = "cog";
		
		int ret = 0;
		ret = q07.ladder(beginWord,endWord, wordList);
		ret = q07.solution(beginWord,endWord, wordList);
		System.out.println("===result===");
		System.out.println(ret);

	}
	private List<String> neighbors(String s, List<String> wordList){
		List<String> res = new LinkedList<>();
		Set<String> dict = new HashSet<>(wordList);
		
		for(int i=0 ; i<s.length() ; i++) {
			char[] chars = s.toCharArray();
			for(char ch='a' ; ch<='z' ; ch++) {
				chars[i] = ch;
				String word = new String(chars);
				if(dict.remove(word)) {
					res.add(word);
				}
			}
		}
		return res;
	}
	
	public int solution(String beginWord, String endWord,List<String> wordList) {
		if(wordList==null || !wordList.contains(endWord)) {
			return 0;
		}
		Queue<String> q = new LinkedList<>();
		Set<String> dict = new HashSet<>(wordList);
		
		q.offer(beginWord);
		dict.add(endWord);
		dict.remove(beginWord);
		
		int level = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0 ; i<size ; i++) {
				String str = q.poll();
				if(str.equals(endWord))
					return level;
				for(String neighbor : neighbors(str,wordList)) {
					q.offer(neighbor);
				}
			}
			System.out.print(level+" : ");
			System.out.println(q);
			level++;
		}
		return 0;
	}
	//////////////////////////////////////////////////////////////////
	private int countMismatch(String word,String compare) {
		int mismatch = 0;
		for(int i=0 ; i<word.length() ; i++) {
			if(word.charAt(i)!=compare.charAt(i)){
				mismatch++;
			}
		}
		return mismatch;
	}
	public int ladder(String beginWord,String endWord,List<String>wordList) {
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		int ret = 1;
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0 ; i<size ; i++) {
				String word = q.poll();
				for(String compare : wordList) {
					if(countMismatch(word, compare)==1) {
						q.offer(compare);
					}
				}
			}
			System.out.print(ret+" : ");
			System.out.println(q);
			ret++;
			if(q.contains(endWord)) {
				break;
			}
			if(ret>wordList.size()+2) {
				ret = 0;
				break;
			}
		}
		return ret;
	}

}

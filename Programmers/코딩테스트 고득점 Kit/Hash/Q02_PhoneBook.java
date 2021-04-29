package Hash;

import java.util.HashMap;

public class Q02_PhoneBook {
	public static void main(String[] args) {
		Q02_PhoneBook a = new Q02_PhoneBook();
//		String[] phone_book = {"119", "97674223", "1195524421"};
//		String[] phone_book = {"123","456","789"};
		String[] phone_book = {"123","124","1235","567","88"};
		System.out.println(a.phone_book(phone_book));
		System.out.println(a.solution(phone_book));
	}
    public boolean solution(String[] phone_book) {
    	HashMap<String,Integer> map = new HashMap<>();
    	for(String str : phone_book) {
    		map.put(str, map.getOrDefault(str,0)+1);
    	}
    	System.out.println(map.keySet());
    	for(String str : phone_book) {
//    		System.out.println(str);
    		for(int i = 0; i < str.length(); i++) {
//    			System.out.println(i+" : "+str.substring(0,i));
    			if( map.containsKey(str.substring(0, i)) ) { 
    				return false;
    			}
    		}
    		System.out.println();
    	}
    	return true;
    }
    /////////////////////////////////////////////
    public boolean phone_book(String[] phone_book) {
    	for(int i=0 ; i<phone_book.length-1 ; i++) {
    		for(int j=i+1 ; j<phone_book.length ; j++) {
    			int lengthOfI = phone_book[i].length();
    			int lengthOfJ = phone_book[j].length();
    			if(lengthOfI>lengthOfJ) {
    				if(phone_book[j].equals(phone_book[i].substring(0,lengthOfJ)))
    					return false;
    			}else {
    				if(phone_book[i].equals(phone_book[j].substring(0,lengthOfI)))
    					return false;
    				
    			}
    		}
    	}
    	return true;
    }

}

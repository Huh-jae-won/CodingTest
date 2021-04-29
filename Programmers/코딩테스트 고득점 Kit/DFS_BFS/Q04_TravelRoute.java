package DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q04_TravelRoute {
	public static void main(String[] args) {
		Q04_TravelRoute a = new Q04_TravelRoute();
//		String[][] tickets = {
//			{"ICN", "JFK"}, 
//			{"HND", "IAD"}, 
//			{"JFK", "HND"}	
//		};
		String[][] tickets = {
				{"ICN", "SFO"}, 
				{"ICN", "ATL"}, 
				{"SFO", "ATL"},
				{"ATL", "ICN"},
				{"ATL","SFO"}
		};
		a.route(tickets);
	}
	public String[] route(String[][] tickets) {
		Queue<List<Integer>> q = new LinkedList<>();
		List<List<Integer>> route = new ArrayList<>();
		int len = tickets.length;
		// 큐에 초기값(ICN) 넣음
		for(int i=0 ; i<len ; i++) {
			if(tickets[i][0].equals("ICN")) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				q.offer(list);
			}
		}
		while(!q.isEmpty()) {
			int size = q.size();
//			System.out.println(q);
			for(int i=0 ; i<size ; i++) {
				List<Integer> list = q.poll();
				if(list.size()>=len) {
					route.add(list);
					continue;
				}
				int arrivalIndex = list.get(list.size()-1);
				String arrivalStr = tickets[arrivalIndex][1];
				// arrivalStr에서 출발할 항공권 추가
				for(int j=0 ; j<len ; j++) {
					if(tickets[j][0].equals(arrivalStr) && !list.contains(j)) {
						List<Integer> temp = new ArrayList<>(list);
						temp.add(j);
						q.offer(temp);
					}
				}
			}
		}
//		System.out.println("LIST : "+route);
		return makeRoute(route,tickets);
	}
	private String[] makeRoute(List<List<Integer>> route, String[][] tickets) {
		int len = route.size();
		String[] str = new String[len];
		for(int i=0 ; i<len ; i++) {
			List<Integer> list = route.get(i);
			StringBuilder sb = new StringBuilder();
			sb.append("ICN ");
			for(int j=0 ; j<list.size() ; j++) {
				int indx = list.get(j);
				sb.append(tickets[indx][1]+" ");
			}
//			System.out.println(list+" : "+sb);
			str[i] = sb.toString();
		}
		
		for(int i=0 ; i<len-1 ; i++) {
			if(str[i].compareTo(str[i+1])<0) {
				String temp = new String(str[i]);
				str[i] = new String(str[i+1]);
				str[i+1] = temp;
			}
		}
//		System.out.println();
//		System.out.println(str[len-1]);
		StringTokenizer st = new StringTokenizer(str[len-1]);
		String[] ret = new String[tickets.length+1];
		for(int i=0 ; i<ret.length ; i++) {
			ret[i] = st.nextToken();
		}
		return ret;
	}
}

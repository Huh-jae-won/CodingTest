package 모의TEST문제모음;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q01952_SwimmingPool {
	class Person{
		int curMonth;
		int curPrice;
		String log;
		public Person(int month,int price,String log) {
			this.curMonth = month;
			this.curPrice = price;
			this.log = log;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Q01952_SwimmingPool a = new Q01952_SwimmingPool();
		a.solution();
	}
	String[] str = {"day","month","3month","year"};
	int maxPrice = 0;
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=10 ; tc++) {
//			이용권 가격 map
			Map<String,Integer> subs = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0 ; i<4 ; i++) {
				subs.put(str[i], Integer.parseInt(st.nextToken()));
			}
//			월별 이용 배열
			int[] month = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int i=1 ; i<13 ; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			maxPrice = Integer.MAX_VALUE;
//			System.out.println(subs);
//			printMonth(month);
			
//			BFS로 
			Queue<Person> q = new LinkedList<>();
			q.add(new Person(1,0,""));
			while(!q.isEmpty()) {
				Person person = q.poll();
				if(person.curMonth>12) {
//					System.out.println(person.log);
					maxPrice = Math.min(person.curPrice, maxPrice);
				}else {
					if(month[person.curMonth]!=0) {
						for(int i=0 ; i<4 ; i++) {
							int[] temp = getPrice(month, person.curMonth, subs, str[i]);
							q.add(new Person(temp[1],person.curPrice+temp[0],person.log+" ["+person.curMonth+","+person.curPrice+"]"));
						}
					}else {
						q.add(new Person(person.curMonth+1,person.curPrice,person.log));
					}
				}
			}
			bw.write("#"+tc+" "+maxPrice+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	private int[] getPrice(int[] month,int mIndex,Map<String,Integer> subs, String period) {
		int price = 0;
		int nMonth = mIndex;
		switch (period) {
		case "day":
			price = month[mIndex]*subs.get(period);
			nMonth +=1;
			break;
		case "month":
			price = subs.get(period);
			nMonth += 1;
			break;
		case "3month":
			price = subs.get(period);
			nMonth += 3;
			break;
		case "year":
			price = subs.get(period);
			nMonth = 13;
			break;
		default:
			break;
		}
		return new int[] {price,nMonth};
	}
	
	private void printMonth(int[] month) {
		for(int i=1 ; i<13 ; i++) {
			System.out.print(month[i]+ " " );
		}
		System.out.println();
	}
}

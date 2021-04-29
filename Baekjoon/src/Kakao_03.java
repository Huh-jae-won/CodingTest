import java.util.ArrayList;

public class Kakao_03 {
	static int[] answer;
	static ArrayList<Person> list;
	static class Person{
		String language;
		String job;
		String career;
		String food;
		int test;
		Person(String language,String job,String career,String food,int test){
			this.language = language;
			this.job = job;
			this.career = career;
			this.food = food;
			this.test = test;
		}
	}
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		list = new ArrayList();
		makeList(info);
		for(int i=0 ; i<list.size() ; i++) {
			Person ps = list.get(i);
//			System.out.println(ps.language+", "+ps.job+", "+ps.career+", "+ps.food+", "+ps.test);
		}
		answer = new int[query.length];
		for(int i=0 ; i<query.length ; i++) {
			String[] queryList = query[i].split(" ");
			howManyPerson(list, queryList,i);
//			for(int j=0 ; j<queryList.length ; j++) {
//				System.out.print(queryList[j]+",");
//			}
//			System.out.println();
		}
		for(int i=0 ; i<answer.length ; i++) {
			System.out.print(answer[i]+" ");
		}
	}
	
	static boolean chkPerson(Person person,String[] queryList) {
		boolean ret = true;
		String[] candidate = new String[5];
		candidate[0] = person.language;
		candidate[1] = person.job;
		candidate[2] = person.career;
		candidate[3] = person.food;
		
		int[] indx = {0,2,4,6};
		// 0~4번 질문
		for(int i=0 ; i<indx.length ; i++) {
			// 					i : candidate의 인덱스
			int j = indx[i];	// queryList의 인덱스
			if(queryList[j].equals("-")) {
				continue;
			}
			if(!candidate[i].equals(queryList[j])) {
				ret = false;
				break;
			}
		}
		int testScore = Integer.parseInt(queryList[7]);
		if(person.test<testScore) {
			ret = false;
		}
		return ret;
	}
	static void howManyPerson(ArrayList<Person> list,String[] queryList,int indx) {
		for(int i=0 ; i<list.size() ; i++) {
			if(chkPerson(list.get(i),queryList)) {
				answer[indx]++;
			}
		}
	}
	static void makeList(String[] info) {
		for(int i=0 ; i<info.length ; i++) {
			String person = null;
			String[] arr = null;
			person = info[i];
			arr = person.split(" ");
			list.add(new Person(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4])));
		}
	}

}

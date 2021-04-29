public class main {
	public static void main(String[] args) {
		String str = "123,1234";
		for(String s : str.split("")) {
			System.out.println(s);
		}
		String ss = ",";
		for(String s : ss.split(","))
			System.out.println(s);
	}
}




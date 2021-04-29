package Step05_practice;
import java.util.Scanner;

public class N01_Q10039{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int[] arr = new int[5];
		for(int i=0 ; i<5 ; i++) {
			int temp = sc.nextInt();
			if(temp<40)
				arr[i] = 40;
			else
				arr[i] = temp;
			sum += arr[i];
		}
		System.out.println(sum/5);
	}
}
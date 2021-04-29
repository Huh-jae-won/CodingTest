package Step05_practice;
import java.util.Scanner;
public class N02_Q5543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] burger = new int[3];
		int[] drink = new int[2];
		int min_burger = Integer.MAX_VALUE;
		int min_drink = Integer.MAX_VALUE;
		
		for(int i=0 ; i<3 ; i++) {
			burger[i] = sc.nextInt();
			if(burger[i]<min_burger) {
				min_burger = burger[i];
			}
		}
		for(int i=0 ; i<2 ; i++) {
			drink[i] = sc.nextInt();
			if(drink[i]<min_drink) {
				min_drink = drink[i];
			}
		}
		
		System.out.println(min_burger+min_drink-50);
	}

}

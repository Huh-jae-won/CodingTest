package Stack_Queue;

public class Q01_TruckOnBridge {

	public static void main(String[] args) {
		Q01_TruckOnBridge a = new Q01_TruckOnBridge();
		int bridge_length = 2;
		int weight = 10;
		int[] truck = {7,4,5,6};
		
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck = {10};

//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck = {10,10,10,10,10,10,10,10,10,10};
	System.out.println(a.truck(bridge_length, weight, truck));
	}
	public int truck(int bridge_length, int weight, int[] truck) {
		int[] newTruck = new int[truck.length+1];
		for(int i=0 ; i <truck.length ; i++) {
			newTruck[i] = truck[i];
		}
		int[] bridge = new int[bridge_length];
		if(newTruck[0]>weight)
			return 0;
		int indx=0;
		int time=0;
		while(true) {
			time++;
			move(bridge);
			if(curWeight(bridge)+newTruck[indx]<=weight) {
				bridge[0]=newTruck[indx];
				if(indx<newTruck.length-1)
					indx++;
			}
//			print(bridge,time);
			if(curWeight(bridge)==0 && indx==newTruck.length-1)
				break;
		}
		return time;
	}
	
	private void move(int[] bridge) {
		for(int i=bridge.length-1 ; i>0 ; i--) {
			bridge[i] = bridge[i-1];
		}
		bridge[0] = 0;
	}
	private int curWeight(int[] bridge) {
		int sum = 0;
		for(int i=0 ; i<bridge.length ; i++) {
			sum += bridge[i];
		}
		return sum;
	}
	private void print(int[] bridge,int time) {
		System.out.print(time+" : ");
		for(int i=0 ; i<bridge.length ; i++) {
			System.out.print(bridge[i]+" ");
		}
		System.out.println();
	}
}

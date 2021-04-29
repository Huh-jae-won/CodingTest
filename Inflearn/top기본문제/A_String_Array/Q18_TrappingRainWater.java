package A_String_Array;

import java.util.StringTokenizer;


public class Q18_TrappingRainWater {
	public static void main(String[] args) {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int[] nums = {2,0,3};
		
//		System.out.println(trap1(nums));
//		System.out.println(trap2(nums));
		System.out.println(solution(nums));
	}
	
	public static int solution(int[] height) {
		int ret = 0;
		if(height==null || height.length<=2)
			return ret;
		int[] left = new int[height.length];
		int[] right= new int[height.length];
		int[] result = new int[height.length];
		// left배열 설정
		left[0] = height[0];
		int max = height[0];
		for(int i=1 ; i<height.length ; i++) {
			if(height[i]<max) {
				left[i] = max;
			}else {
				left[i] = height[i];
				max = left[i];
			}
		}
		// right배열 설정
		right[height.length-1] = height[height.length-1];
		max = height[height.length-1];
		for(int i=height.length-2 ; i>=0 ; i--) {
			if(height[i]<max) {
				right[i] = max;
			}else {
				right[i] = height[i];
				max = height[i];
			}
		}
		for(int i=0 ; i<height.length ; i++) {
			result[i] = Math.min(left[i], right[i])-height[i];
		}
		
		System.out.print(" left  : ");
		for(int i=0 ; i<height.length ; i++) {
			System.out.print(left[i]+" ");
		}
		System.out.println();
		System.out.print(" right : ");
		for(int i=0 ; i<height.length ; i++) {
			System.out.print(right[i]+" ");
		}
		System.out.println();
		System.out.print("result : ");
		for(int i=0 ; i<height.length ; i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
		
		for(int i=0 ; i<height.length ; i++) {
			ret += result[i];
		}
		return ret;
	}
	
	public static int trap2(int[] height) {
		int result = 0;
		
		int maxValue = 0;
		for(int i=0 ; i<height.length ; i++) {
			if(height[i]>maxValue)
				maxValue = height[i];
		}
		int indx=0;
		int indxBefore = 0;
		while(indx<height.length) {
			indxBefore = indx;
			if(height[indx]!=0) {
				String temp = countRain(height,indx);
				StringTokenizer st = new StringTokenizer(temp);
				result += Integer.parseInt(st.nextToken());
System.out.print("startIndex "+indx+", result "+result);
				indx = Integer.parseInt(st.nextToken());
System.out.println(", nextIndex : "+indx);
System.out.println();
			}else {
				indx++;
			}
			if(indxBefore==indx)
				break;
		}
		return result;
	}
	public static String countRain(int[] arr, int index) {
		int result = 0;
		boolean flag = false;
		StringBuilder nextIndex = new StringBuilder(); 
		int[] startIndex = new int[arr[index]+1];
System.out.print("startIndex : ");
		for(int i=1 ; i<=arr[index] ; i++) {
			startIndex[i] = index;
System.out.print(startIndex[i] + " ");
		}
System.out.println("__끝");
		for(int i=index+1 ; i<arr.length ; i++) {
System.out.print("i "+i);
			if(arr[i]!=0) {
				if(arr[i]<arr[index]) {
					result += i-startIndex[arr[i]]-1;
					for(int j=1 ; j<=arr[i] ; j++) {
						startIndex[j] = i;
					}
				}else {
					for(int j=1 ; j<=arr[index] ; j++) {
						result += i-startIndex[j]-1;
					}
					nextIndex.append(String.valueOf(i));
					flag = true;
					break;
				}
			}
System.out.print("\t startIndex : ");
			for(int j=1 ; j<=arr[index] ; j++) {
System.out.print(startIndex[j] + " ");
			}
System.out.println(" : "+"result "+result);
		}
		StringBuilder ret = new StringBuilder();
		if(flag) {
			ret.append(String.valueOf(result)+" "+nextIndex.toString());
		}else {
			ret.append(String.valueOf(result)+" "+String.valueOf(arr.length-1));
		}
System.out.println(" : ret(ret, next) : "+ret);
		return ret.toString();
	}
/////////////////////////////////////////////////////////
	public static int trap1(int[] height) {
		int maxValue = 0;
		for(int i=0 ; i<height.length ; i++) {
			if(height[i]>maxValue)
				maxValue = height[i];
		}
		int[][] map = makeMap(height,maxValue);
//		print(map);
		return countRain(map);
	}
	static int countRain(int[][] map) {
		int result = 0;
		int cnt = 0;
		for(int i=map.length-1 ; i>=0 ; i--) {
			for(int j=0 ; j<map[i].length ; j++) {
				if(map[i][j]==0) {
					if(checkRain(map,i,j))
						cnt++;
				}
			}
		}
		return cnt;
	}
	static boolean checkRain(int[][] map, int row, int col) {
		boolean leftBlock = false;
		boolean rightBlock = false;
		// 왼쪽벽 체크
		for(int j=col-1 ; j>=0 ; j--) {
			if(map[row][j]==1) {
				leftBlock = true;
				break;
			}
		}
		for(int j=col+1 ; j<map[row].length ; j++) {
			if(map[row][j]==1) {
				rightBlock = true;
				break;
			}
		}
		if(leftBlock==true && rightBlock==true) {
			return true;
		}else {
			return false;
		}
	}
	static int[][] makeMap(int[] height,int maxValue) {
		int[][] map = new int[maxValue][height.length];
		for(int j=0 ; j<height.length ; j++) {
			for(int i=2 ; i>=3-height[j] ; i--) {
				map[i][j] = 1;
			}
		}
		return map;
	}
	static void print(int[][] map) {
		for(int i=0 ; i<map.length ; i++) {
			for(int j=0 ; j<map[i].length ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}

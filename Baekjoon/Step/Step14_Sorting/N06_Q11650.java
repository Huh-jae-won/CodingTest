package Step14_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N06_Q11650 {
	// 퀵소팅 다시해봐야함!!
    public static void main(String[] args) throws IOException {
    	System.out.println("다시해보기!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> input = new ArrayList<int[]>();// 좌표 담을 ArrayList
        int[] temp = new int[1];
        for (int i = 0; i < N; i++) { // x좌표와 y좌표의 arrayList만들기
            st = new StringTokenizer(br.readLine());
            int point[] = new int[2]; // x,y값 담을 배열
            point[0] = Integer.parseInt(st.nextToken()); // x

            point[1] = Integer.parseInt(st.nextToken()); // y
            input.add(i, point);
        }

        input=quickSort(input);
        for(int i=0;i<input.size();i++) {
            System.out.println(input.get(i)[0]+" "+input.get(i)[1]);
        }
    }

    public static ArrayList<int[]> quickSort(ArrayList<int[]> li) { // 퀵정렬 메소드
        // arr을 start부터 end까지 퀵정렬 하는 함수

        if (li.size() < 2) {// 첫 값이 끝 값보다 항상 작아야 함
            return li;
        }
        ArrayList<int[]> left = new ArrayList<>(); // 작은 값을 담을 좌 list
        ArrayList<int[]> right = new ArrayList<>();// 큰 값을 넣을 우 list

        int[] pivot = li.get(li.size() / 2); // 배열의 첫 값
        li.remove(li.size() / 2);

        for (int i = 0; i < li.size(); i++) {
            if (li.get(i)[0] <= pivot[0]) {
                if (li.get(i)[0]==pivot[0]&&li.get(i)[1] > pivot[1]) {
                    right.add(li.get(i));
                } else {
                    left.add(li.get(i)); // 만약 배열의 숫자가 pivot보다 클 때 right에 저장
                }
            } else {
                right.add(li.get(i)); // 만약 배열의 숫자가 pivot보다 작을 때 left에 저장

            }
        }
        left = quickSort(left);
        right = quickSort(right);
        ArrayList<int[]> sortedList = new ArrayList<>();
        sortedList.addAll(left);
        sortedList.add(pivot);
        sortedList.addAll(right);

        return sortedList;

    }

}

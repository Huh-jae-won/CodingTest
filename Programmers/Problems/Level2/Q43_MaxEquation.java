package Level2;

import java.util.ArrayList;
import java.util.List;

public class Q43_MaxEquation {
	public static void main(String[] args) {
		Q43_MaxEquation z = new Q43_MaxEquation();
		String expression = "100-200*300-500+20";
		long ret = z.solution(expression);
		System.out.println(ret);
	}
    long answer;
    public long solution(String expression) {
        answer = 0;
        String[] operator = {"*","+","-"};
        boolean[] visited = new boolean[4];
        List<String> list = makeList(expression);
        // System.out.println(list);
        dfs(list,operator,visited,0,"");
        return answer;
    }
    private void dfs(List<String> list, String[] ope, boolean[] visited, int dep,String order){
        if(dep==3){
            // System.out.println(order);
            Long temp = Math.abs(calculate(list,order));
            answer = Math.max(temp,answer);
            // System.out.println();
            return;
        }
        for(int i=0 ; i<3 ; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(list,ope,visited,dep+1,order+ope[i]);
                visited[i] = false;
            }
        }
    }
    
    private long calculate(List<String> list, String order){
        List<String> newList = new ArrayList<>(list);
        for(int i=0 ; i<order.length() ; i++){
            String ope = String.valueOf(order.charAt(i));
            // ope연산이 있다면 연산 수행
            for(int j=0 ; j<newList.size()-1 ; j++){
                if(newList.get(j).equals(ope)){
                    long num1 = Long.parseLong(newList.get(j-1));
                    Long num2 = Long.parseLong(newList.get(j+1));
                    Long tempSum = cal(num1,num2,ope);
                    newList.add(j-1,String.valueOf(tempSum));
                    newList.remove(j);
                    newList.remove(j);
                    newList.remove(j);
                    j--;
                    continue;
                }
            }
            // System.out.println("<"+ope+" : "+newList+"> ");
        }
        
        return Long.parseLong(newList.get(0));
    }
    
    private long cal(long num1, long num2, String ope){
        switch(ope){
            case "*" :
                return num1*num2;
            case "+" :
                return num1+num2;
            case "-" :
                return num1-num2;
            default :
                break;
                
        }
        return -1;
    }
    
    private List<String> makeList(String expression){
        List<String> list = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<expression.length() ; i++){
            char ch = expression.charAt(i);
            if(!isOperator(ch)){
                // 숫자인 경우
                sb.append(ch+"");
            }else{
                // 연산자인 경우
                list.add(sb.toString());
                list.add(ch+"");
                sb = new StringBuilder();
            }
        }
        if(sb.length()!=0)
            list.add(sb.toString());
        return list;
    }
    private boolean isOperator(char ch){
        if(ch=='+' || ch=='-' || ch=='*')
            return true;
        return false;
    }
}

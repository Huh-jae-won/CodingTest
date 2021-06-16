package Level2;

public class Q59_TakePicture {
	public static void main(String[] args) {
		Q59_TakePicture z = new Q59_TakePicture();
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		int ret = z.solution(n, data);
		System.out.println(ret);
	}
    int ret = 0;
    public int solution(int n, String[] data) {
        ret = 0;
        char[] member = {'A','C','F','J','M','N','R','T'};
        boolean[] visited = new boolean[8];
        dfs(member,visited,data,"");
        return ret;
    }
    private void dfs(char[] member,boolean[] visited, String[] data, String log){
        if(log.length()==8){
            if(condition(data,log)){
                // System.out.println(log);
                ret++;
            }
            return;
        }
        if(!condition(data,log)){
            // System.out.println("false : "+log);
            return;
        }
        
        for(int i=0 ; i<8 ; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(member,visited,data,log+member[i]);
                visited[i] = false;
            }
        }
    }
    private boolean condition(String[] data, String log){
        int far = 0;
        for(int i=0 ; i<data.length ; i++){
            char member1 = data[i].charAt(0);
            char member2 = data[i].charAt(2);
            char comparison = data[i].charAt(3);
            int dist = Integer.parseInt(data[i].substring(4,5));
            far = Math.max(far,dist);
            if(log.length()<far)
                return true;
            
            int idx1 = log.indexOf(member1);
            int idx2 = log.indexOf(member2);
            if(idx1==-1 || idx2==-1){
                return true;
            }
            if(comparison=='>'){
                if(Math.abs(idx1-idx2)<=dist+1){
                    return false;
                }
            }else if(comparison=='<'){
                if(Math.abs(idx1-idx2)>=dist+1){
                    return false;
                }
            }else{
                if(Math.abs(idx1-idx2)!=dist+1){
                    return false;
                }
            }
        }
        return true;
    }
}


package D_Graph;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		this.val = x;
	}
}
public class Q03_MaxDepOfBiTree_Recursive {
	public static void main(String[] args) {
		Q03_MaxDepOfBiTree_Recursive q03 = new Q03_MaxDepOfBiTree_Recursive();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(8);
		
		root.left.left.left = new TreeNode(7);
		int ret = q03.maxDep_Recursive(root, 0);
		System.out.println("===result===");
		System.out.println(ret);
		System.out.println(q03.solution(root));
	}
	public int solution(TreeNode root) {
		if(root==null)
			return 0;
		int leftMax = solution(root.left);
		int rightMax = solution(root.right);
		return Math.max(leftMax, rightMax)+1;
	}
	
	public int maxDep_Recursive(TreeNode root,int dep) {
		int leftDep = 0;
		int rightDep = 0;
		if(root==null) {
			return dep;
		}else {
			System.out.printf("node : %2d, dep : %2d \n",root.val,dep);
			leftDep = maxDep_Recursive(root.left, dep+1);
			rightDep = maxDep_Recursive(root.right, dep+1);
		}
		return Math.max(leftDep, rightDep);
	}
}

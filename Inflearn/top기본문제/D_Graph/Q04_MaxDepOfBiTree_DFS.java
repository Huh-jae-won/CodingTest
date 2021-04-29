package D_Graph;

import java.util.Stack;

public class Q04_MaxDepOfBiTree_DFS {
	public static void main(String[] args) {
		Q04_MaxDepOfBiTree_DFS q04 = new Q04_MaxDepOfBiTree_DFS();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(8);
		
//		root.right.right = new TreeNode(9);
//		root.right.right.right = new TreeNode(99);
//		root.right.right.right.right = new TreeNode(999);
//		
		
		root.left.left.left = new TreeNode(7);
		
		System.out.println("===result===");
		System.out.println(q04.solution(root));
	}
	public int solution(TreeNode root) {
		if(root==null)
			return 0;
		Stack<TreeNode> st = new Stack<>();
		Stack<Integer> stVal = new Stack<>();
		st.push(root);
		stVal.push(1);
		int max = 0;
		while(!st.isEmpty()) {
			TreeNode node = st.pop();
			int count = stVal.pop();
			max = Math.max(max, count);
			if(node.left!=null) {
				st.push(node.left);
				stVal.push(count+1);
			}
			if(node.right!=null) {
				st.push(node.right);
				stVal.push(count+1);  
			}
			
		}
		return max;
	}
}

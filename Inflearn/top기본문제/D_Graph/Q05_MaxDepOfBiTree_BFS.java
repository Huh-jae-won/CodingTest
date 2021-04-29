package D_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q05_MaxDepOfBiTree_BFS {

	public static void main(String[] args) {
		Q05_MaxDepOfBiTree_BFS q05 = new Q05_MaxDepOfBiTree_BFS();
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
		int ret = q05.maxDep_BFS(root);
		System.out.println(ret);
	}
	public int maxDep_BFS(TreeNode root) {
		if(root==null)
			return 0;
		int dep = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0 ; i<size ; i++) {
				TreeNode node = q.poll();
				if(node.left!=null)
					q.offer(node.left);
				if(node.right!=null)
					q.offer(node.right);
			}
			dep++;
		}
		return dep;
	}

}

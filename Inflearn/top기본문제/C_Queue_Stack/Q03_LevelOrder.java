package C_Queue_Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}

public class Q03_LevelOrder {
	public static void main(String[] args) {
		Q03_LevelOrder q03 = new Q03_LevelOrder();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
//		System.out.println(q03.levelOrder(root));
		System.out.println(q03.solution(root));

	}
	
	
	/////////////////////////////////////////////////////
	public List<List<Integer>> solution(TreeNode root){
		// Queue 사용 -> bfs
		List<List<Integer>> ret = new ArrayList<>();
		 Queue<TreeNode> q = new LinkedList<>();
		 q.offer(root);
		 while(!q.isEmpty()) {
			 int size = q.size();
			 List<Integer> list = new ArrayList<>();
			 for(int i=0 ; i<size ; i++) {
				 TreeNode node = q.poll();
				 list.add(node.val);
				 if(node.left!=null) {
					 q.offer(node.left);
				 }
				 if(node.right!=null) {
					 q.offer(node.right);
				 }
			 }
			 System.out.println(list);
			 ret.add(list);
		 }
		return ret;
	}
	
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> ret = new ArrayList<>();
		TreeNode[] arr = new TreeNode[256];
		TreeNode tn = root;
		arr[1] = tn;
		int indx = 1;
		place(arr,tn,indx);
		int cnt = 1;
		while(arr[cnt]!=null) {
			List<Integer> list = new ArrayList<>();
			for(; cnt<indx*2 && arr[cnt]!=null ; cnt++) {
				list.add(arr[cnt].val);
			}
			ret.add(list);
			indx*=2;
		}
		return ret;
	}
	// 본인, 좌, 우 -> 자식으로
	private void place(TreeNode[] arr, TreeNode node, int indx){
		arr[indx] = node;
		if(node.left!=null) {
			arr[indx*2] = node.left;
			place(arr,node.left,indx*2);
		}
		if(node.right!=null) {
			arr[indx*2+1] = node.right;
			place(arr,node.right,indx*2+1);
		}
	}
}

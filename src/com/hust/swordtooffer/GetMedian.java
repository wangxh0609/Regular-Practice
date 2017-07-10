package com.hust.swordtooffer;

public class GetMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer.valueOf(i)(s)
	}
	class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	
	// 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
	//中序遍历
	int count=0;
	TreeNode pNext=null;
	 TreeNode KthNode(TreeNode pRoot, int k)
	 {
		 visitTreeNode(pRoot, k);
		 return pNext;
	 }
	 
	 void visitTreeNode(TreeNode pRoot, int k){
		   
	        if(pRoot!=null){
	        	visitTreeNode(pRoot.left,k);
	        	count++;
	        	if(count==k){
	        		pNext=pRoot;
	        	}
	        	visitTreeNode(pRoot.right,k);
	        }	        	       
	      
	 }
	/*
	 * 
	 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	*/
	
	
}

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
	
	// ����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣���磬 5 / \ 3 7 /\ /\ 2 4 6 8 �У��������ֵ��С˳�����������ֵΪ4��
	//�������
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
	 * ����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣���磬 5 / \ 3 7 /\ /\ 2 4 6 8 �У��������ֵ��С˳�����������ֵΪ4��
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

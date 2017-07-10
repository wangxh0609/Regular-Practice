package com.hust.swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LayerVisitTreeNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 /*
	  * 层序遍历二叉树，每行打印一层LayerVisitTreeNode
	  */
	     ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
	    	
	    			 
	    	 ArrayList<ArrayList<Integer>> outArrayList=new ArrayList<>();
	    	 if(pRoot==null){
	    		 return outArrayList;
	    	 }
	    	 Queue<TreeNode> queue=new LinkedList<>();
	    	 int start=0;int end=1;
	    	 queue.add(pRoot);
	    	 ArrayList<Integer> tempArr=new ArrayList<>();
	    	 while(!queue.isEmpty()){
	    		 TreeNode tempNode=queue.remove();
	    		 start++;
	    		 tempArr.add(tempNode.val);
	    		 if(tempNode.left!=null){
	    			 queue.add(tempNode.left);	    			 
	    		 }
	    		 if(tempNode.right!=null){
	    			 queue.add(tempNode.right);
	    		 }
	    		 if(start==end){
	    			 outArrayList.add(tempArr);
	    			 end=queue.size();
	    			 start=0;
	    			 tempArr=new ArrayList<>();
	    		 }
	    		 
	    	 }
	    	 
	    
	    	 return outArrayList;
	    }
}

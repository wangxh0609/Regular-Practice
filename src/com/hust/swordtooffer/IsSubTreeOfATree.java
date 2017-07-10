package com.hust.swordtooffer;

import java.util.Stack;

public class IsSubTreeOfATree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//代码通过测试用例
	
	/*
	 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
	 * 判断root2是否是root1的子树
	 * 是子树的话  节点的左子树是比较后节点的左子树的子树
	 * 1.遍历节点 递归
	 * 	判断是否与root2值相等的节点，
	 *    1.1如果相等 判断是否是子树结构
	 *    	左子树是否相等，右子树是否相等 递归
	 * 	  1.2 不相等 继续访问下一个节点 执行1.1
	 */ 
	private static  boolean isSubTree=false;
	public static boolean HasSubtree(TreeNode root1,TreeNode root2) {	  
	    if(root1==null||root2==null){
	    	return false;
	    }
	    if(root1.val==root2.val){
	    	isSubTree=isHadSameStruc(root1,root2);
	    }
	    if(isSubTree){
	    	return isSubTree;
	    }else{
	    	return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
	    }	    	   
	}
	
	/*
	 * 用来判断以一个节点开头的是否是子树
	 */
	private static boolean isHadSameStruc(TreeNode father,TreeNode child){
		if(child==null){
			return true;
		}
		if(father==null){
			return false;
		}
		if(father.val!=child.val){
			return false;
		}
		else{
			//判断是否有相同的左结构与右结构
			return isHadSameStruc(father.left,child.left)&&isHadSameStruc(father.right,child.right);
		}
	}
	

}

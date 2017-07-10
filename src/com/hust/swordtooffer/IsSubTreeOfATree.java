package com.hust.swordtooffer;

import java.util.Stack;

public class IsSubTreeOfATree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//����ͨ����������
	
	/*
	 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
	 * �ж�root2�Ƿ���root1������
	 * �������Ļ�  �ڵ���������ǱȽϺ�ڵ��������������
	 * 1.�����ڵ� �ݹ�
	 * 	�ж��Ƿ���root2ֵ��ȵĽڵ㣬
	 *    1.1������ �ж��Ƿ��������ṹ
	 *    	�������Ƿ���ȣ��������Ƿ���� �ݹ�
	 * 	  1.2 ����� ����������һ���ڵ� ִ��1.1
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
	 * �����ж���һ���ڵ㿪ͷ���Ƿ�������
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
			//�ж��Ƿ�����ͬ����ṹ���ҽṹ
			return isHadSameStruc(father.left,child.left)&&isHadSameStruc(father.right,child.right);
		}
	}
	

}

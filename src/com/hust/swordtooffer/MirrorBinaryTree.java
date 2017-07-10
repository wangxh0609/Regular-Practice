package com.hust.swordtooffer;

public class MirrorBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) {
			return false;
		}
		return childIsMirror(pRoot.left, pRoot.right);

	}

	public static boolean childIsMirror(TreeNode left,TreeNode right){
		if(left==null&&right==null){
			return true;
		}else if(left==null||right==null){//����һ��Ϊnull
			return false;
		}else if(left.val==right.val){
		//����Ϊ����Ϊnull
			return childIsMirror(left.left,right.right)&&childIsMirror(left.right,right.left);
		}
		return false;
	}

}

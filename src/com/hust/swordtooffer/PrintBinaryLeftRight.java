package com.hust.swordtooffer;

import java.util.*;

public class PrintBinaryLeftRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tn0=new TreeNode(1);
		TreeNode tn1=new TreeNode(2);
		TreeNode tn2=new TreeNode(3);
		TreeNode tn3=new TreeNode(4);
		TreeNode tn4=new TreeNode(5);
		TreeNode tn5=new TreeNode(6);
		TreeNode tn6=new TreeNode(7);
		TreeNode tn7=new TreeNode(8);
		TreeNode tn8=new TreeNode(9);
		tn0.left=tn1;
		tn0.right=tn2;
		tn1.left=tn3;
		tn1.right=tn4;
		tn2.left=tn5;
		tn3.left=tn6;
		tn5.left=tn7;
		tn5.right=tn8;
		Print(tn0);
	}

	/*
	 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印， 第二层按照从右至左的顺序打印，
	 * 第三行按照从左到右的顺序打印，其他行以此类推。
	 */
	/*
	 * 思路： //s1存奇数层节点 //s2存偶数层节点
	 */

	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		if (pRoot == null) {
			return arrayList;
		}
		Stack<TreeNode> stack1 = new Stack<TreeNode>();// 存放奇数层节点
		Stack<TreeNode> stack2 = new Stack<TreeNode>();// 存放偶数层节点
		stack1.push(pRoot);
		int layer = 1;// 记录层次

		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			if ((layer & 1) == 0) {// 偶数层
				ArrayList<Integer> temList = new ArrayList<>();
				while (!stack2.isEmpty()) {
					TreeNode temNode = stack2.pop();
					if (temNode != null) {
						// 将它的孩子放入存放奇数层节点的stack1; stack1应该是从左往右打印所以要从右往左存
						// stack2是从右往左存放的所以只需要把他的孩子按从右往左放入stack2就能保证整体上是从右
						// 往左
						stack1.push(temNode.right);
						stack1.push(temNode.left);						
						temList.add(temNode.val);
						//System.out.print(temNode.val+" ");
					}
					
				}
				if (!temList.isEmpty()) {
					layer++;
					arrayList.add(temList);
					//System.out.println();
				}
			} else {// 奇数层
				ArrayList<Integer> temList = new ArrayList<>();			
				while (!stack1.isEmpty()) {
					TreeNode temNode = stack1.pop();
					if (temNode != null) {
						// 将它的孩子放入存放偶数层节点的stack2; stack2应该是从右往左打印所以要从左往右存
						// stack1是从左往右存放的所以只需要把他的孩子按从左往右放入stack2就能保证整体上是从左
						// 往右
						stack2.push(temNode.left);
						stack2.push(temNode.right);						
						temList.add(temNode.val);
						//System.out.print(temNode.val+" ");
					}
					
				}
				if (!temList.isEmpty()) {
					layer++;
					arrayList.add(temList);
					//System.out.println();
				}
			}
		}
		return arrayList;
	}
}

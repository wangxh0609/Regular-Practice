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
	 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ�� �ڶ��㰴�մ��������˳���ӡ��
	 * �����а��մ����ҵ�˳���ӡ���������Դ����ơ�
	 */
	/*
	 * ˼·�� //s1��������ڵ� //s2��ż����ڵ�
	 */

	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		if (pRoot == null) {
			return arrayList;
		}
		Stack<TreeNode> stack1 = new Stack<TreeNode>();// ���������ڵ�
		Stack<TreeNode> stack2 = new Stack<TreeNode>();// ���ż����ڵ�
		stack1.push(pRoot);
		int layer = 1;// ��¼���

		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			if ((layer & 1) == 0) {// ż����
				ArrayList<Integer> temList = new ArrayList<>();
				while (!stack2.isEmpty()) {
					TreeNode temNode = stack2.pop();
					if (temNode != null) {
						// �����ĺ��ӷ�����������ڵ��stack1; stack1Ӧ���Ǵ������Ҵ�ӡ����Ҫ���������
						// stack2�Ǵ��������ŵ�����ֻ��Ҫ�����ĺ��Ӱ������������stack2���ܱ�֤�������Ǵ���
						// ����
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
			} else {// ������
				ArrayList<Integer> temList = new ArrayList<>();			
				while (!stack1.isEmpty()) {
					TreeNode temNode = stack1.pop();
					if (temNode != null) {
						// �����ĺ��ӷ�����ż����ڵ��stack2; stack2Ӧ���Ǵ��������ӡ����Ҫ�������Ҵ�
						// stack1�Ǵ������Ҵ�ŵ�����ֻ��Ҫ�����ĺ��Ӱ��������ҷ���stack2���ܱ�֤�������Ǵ���
						// ����
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

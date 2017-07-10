package com.hust.swordtooffer;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class NextNodeInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode tn1 = new TreeLinkNode(1);
		TreeLinkNode tn2 = new TreeLinkNode(2);
		TreeLinkNode tn3 = new TreeLinkNode(3);
		TreeLinkNode tn4 = new TreeLinkNode(4);
		TreeLinkNode tn5 = new TreeLinkNode(5);
		TreeLinkNode tn6 = new TreeLinkNode(6);
		TreeLinkNode tn7 = new TreeLinkNode(7);
		TreeLinkNode tn8 = new TreeLinkNode(8);
		TreeLinkNode tn9 = new TreeLinkNode(9);
		TreeLinkNode tn10 = new TreeLinkNode(10);
		tn1.left = tn2;
		tn1.right = tn3;
		tn2.next = tn1;
		tn3.next = tn1;
		tn2.left = tn4;
		tn2.right = tn5;
		tn4.next = tn2;
		tn5.next = tn2;
		tn3.left = tn6;
		tn3.right = tn9;
		tn6.next = tn3;
		tn9.next = tn3;
		tn4.left = tn7;
		tn7.next = tn4;
		tn5.right = tn8;
		tn8.next = tn5;
		tn6.right = tn10;
		tn10.next = tn6;
		TreeLinkNode temp = GetNext(tn7);
		System.out.println(temp == null ? "null" : temp.val);
		//Iterator<E>
		//
		//ConcurrentHashMap<K, V>
		//Blocking
		//Deque
	}

	/*
	 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
	 */
	public static TreeLinkNode GetNext(TreeLinkNode pNode) {
		if(pNode==null){
			return null;
		}
		TreeLinkNode tempNode=pNode.right;
		if(tempNode==null){//查找的节点没有右孩子
			//TreeLinkNode fatherNode=pNode.next;
			return getNodeFromNoRight(pNode);					
		}else{//查找的节点有右孩子
			TreeLinkNode leftNode=tempNode.left;
			//用这一个函数与下面的几行代码的效果一样
			return getNoLeftFirst(tempNode,leftNode);
//			if(leftNode==null){//查找的节点的右孩子没有左孩子
//				return tempNode;
//			}else{//查找的节点的右孩子有左孩子
//				//一直找左孩子找到没有左孩子的第一个节点返回即可
//				return getNoLeftFirst(leftNode.left,leftNode);
//			}
		}
		//return null;    
	}
	
	public static TreeLinkNode getNodeFromNoRight(TreeLinkNode pNode){
		TreeLinkNode fatherNode=pNode.next;
		if(fatherNode==null){
			return null;
		}else{
			//判断pNode是father的左孩子还是右孩子
			TreeLinkNode temp=fatherNode.left;
			if(pNode==temp){//左孩子
				return fatherNode;
			}else{//右孩子
				return getNodeFromNoRight(fatherNode);
			}
		}
	}
	
	/*
	 * 找到没有左孩子的第一个节点
	 */
	public static TreeLinkNode getNoLeftFirst(TreeLinkNode pNode,TreeLinkNode father){
		if(pNode==null){//查找的节点的右孩子没有左孩子
			return father;
		}else{//查找的节点的右孩子有左孩子
			return getNoLeftFirst(pNode.left,pNode);
		}
	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}

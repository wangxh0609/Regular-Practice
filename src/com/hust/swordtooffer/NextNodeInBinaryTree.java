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
	 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء� ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
	 */
	public static TreeLinkNode GetNext(TreeLinkNode pNode) {
		if(pNode==null){
			return null;
		}
		TreeLinkNode tempNode=pNode.right;
		if(tempNode==null){//���ҵĽڵ�û���Һ���
			//TreeLinkNode fatherNode=pNode.next;
			return getNodeFromNoRight(pNode);					
		}else{//���ҵĽڵ����Һ���
			TreeLinkNode leftNode=tempNode.left;
			//����һ������������ļ��д����Ч��һ��
			return getNoLeftFirst(tempNode,leftNode);
//			if(leftNode==null){//���ҵĽڵ���Һ���û������
//				return tempNode;
//			}else{//���ҵĽڵ���Һ���������
//				//һֱ�������ҵ�û�����ӵĵ�һ���ڵ㷵�ؼ���
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
			//�ж�pNode��father�����ӻ����Һ���
			TreeLinkNode temp=fatherNode.left;
			if(pNode==temp){//����
				return fatherNode;
			}else{//�Һ���
				return getNodeFromNoRight(fatherNode);
			}
		}
	}
	
	/*
	 * �ҵ�û�����ӵĵ�һ���ڵ�
	 */
	public static TreeLinkNode getNoLeftFirst(TreeLinkNode pNode,TreeLinkNode father){
		if(pNode==null){//���ҵĽڵ���Һ���û������
			return father;
		}else{//���ҵĽڵ���Һ���������
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

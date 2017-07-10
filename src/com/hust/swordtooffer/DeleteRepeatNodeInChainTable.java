package com.hust.swordtooffer;

import java.util.*;
public class DeleteRepeatNodeInChainTable {

	/*
	 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 
	 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode ln0=new ListNode(1);
		ListNode ln1=new ListNode(1);
		ListNode ln2=new ListNode(3);
		ListNode ln3=new ListNode(3);
		ListNode ln4=new ListNode(4);
		ListNode ln5=new ListNode(4);
		ListNode ln6=new ListNode(5);
		ln0.next=ln1;
		ln1.next=ln2;
		ln2.next=ln3;
		ln3.next=ln4;
		ln4.next=ln5;
		ln5.next=ln6;
		deleteDuplication(ln0);
	}
	
	/*
	 * ˼·�����ҳ�ͷ�ڵ㣬���ҳ��ýڵ��ĵ�һ�����ظ��Ľڵ㣬�ٴӸò��ظ��Ľڵ㿪ʼ����һ�����ظ��Ľڵ㣬���� 
	 *��������������ģ��Ҳ��ظ��Ľڵ�ʱ���жϵ�ǰ�ڵ㣬ǰһ���ڵ���һ���ڵ��Ƿ���ͬ���ɣ�����ͬ��Ϊ���ظ��Ľڵ�
	 *��Ҫ���� ��һ���ڵ����һ���ڵ���������
	 */
	 public static ListNode deleteDuplication(ListNode pHead)
	 {
		 ListNode lastDiff=null;
		 ListNode preNode=null;
		 ListNode  curNode=null;
		 if(pHead==null||pHead.next==null){
			 return pHead;
		 }		
		 preNode=pHead;
		 curNode=pHead.next;	
		 //��ͷ�ڵ�
		 if(preNode.val==curNode.val){
			 ListNode temp=getFirstNotRepeatNode(pHead);
			 if(temp!=null){
				 pHead=temp;
			 }else{
				 return null;
			 }
		 }
		//�ҵ���һ�����ظ��Ľڵ�;
		 lastDiff=pHead;
		 while(lastDiff!=null){
			 lastDiff.next=getFirstNotRepeatNode(lastDiff.next);
			 lastDiff=lastDiff.next;
		 } 
		 printListNode(pHead);
		 return pHead;
	 } 
	 	 
	 public static ListNode getFirstNotRepeatNode(ListNode listNode){
		 ListNode resultNode=null;
		 ListNode preNode=null;
		 ListNode curNode=listNode;
		 ListNode nextNode=null;
		 while(curNode!=null){
			 nextNode=curNode.next;
			 if(preNode==null){//�����ǵ�һ���ڵ�
				 if(nextNode==null){//ֻ��һ���ڵ�
					 return curNode;
				 }
				 else{
					 if(nextNode.val==curNode.val){
						 preNode=curNode;
						 curNode=curNode.next;
					 }else{
						 return curNode;
					 }
				 }
			 }else{//�м�ڵ�
				 if(nextNode==null){//curNode���һ���ڵ�
					 if(preNode.val==curNode.val){
						 return null;
					 }else{
						 return curNode;
					 }
				 }else{//�������һ���ڵ�
					 if(nextNode.val!=curNode.val&&preNode.val!=curNode.val){
						 return curNode;
					 }else{
						 preNode=curNode;
						 curNode=nextNode;
						 nextNode=nextNode.next;
					 }
				 }
				 
			 }
		 }
		 return resultNode;
	 }
	 
	 public static void printListNode(ListNode head){
		 while(head!=null){
			 System.out.println(head.val);
			 head=head.next;
		 }
	 }

}

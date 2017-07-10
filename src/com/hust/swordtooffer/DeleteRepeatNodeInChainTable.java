package com.hust.swordtooffer;

import java.util.*;
public class DeleteRepeatNodeInChainTable {

	/*
	 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
	 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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
	 * 思路：先找出头节点，在找出该节点后的第一个不重复的节点，再从该不重复的节点开始找下一个不重复的节点，依次 
	 *由于链表是排序的，找不重复的节点时，判断当前节点，前一个节点下一个节点是否相同即可，不相同即为不重复的节点
	 *需要考虑 第一个节点最后一个节点的特殊情况
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
		 //找头节点
		 if(preNode.val==curNode.val){
			 ListNode temp=getFirstNotRepeatNode(pHead);
			 if(temp!=null){
				 pHead=temp;
			 }else{
				 return null;
			 }
		 }
		//找到第一个不重复的节点;
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
			 if(preNode==null){//代表是第一个节点
				 if(nextNode==null){//只有一个节点
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
			 }else{//中间节点
				 if(nextNode==null){//curNode最后一个节点
					 if(preNode.val==curNode.val){
						 return null;
					 }else{
						 return curNode;
					 }
				 }else{//不是最后一个节点
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

package com.hust.swordtooffer;

import java.util.Scanner;
import java.util.Stack;

public class PrintChainTailToHead {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		ListNode phead=null;
		ListNode ptail=phead;
		for(int i=0;i<n;i++){
			ListNode temNode=new ListNode(0);
			temNode.val=scan.nextInt();
			if(phead==null){
				phead=temNode;
				ptail=temNode;
			}
			else{
				ptail.next=temNode;
				ptail=temNode;
			}
		}
		printListNodeTailToHead(phead);
		
		
	}
	
	public static void printListNodeTailToHead(ListNode phead){
		//1.基于递归实现
		if(phead!=null){
			printListNodeTailToHead(phead.next);
		}
		else{
			return;
		}
		System.out.println(phead.val);
		
//		//2.使用栈
//		Stack<ListNode> stack=new Stack<ListNode>(); 
//		while(phead!=null){
//			stack.push(phead);
//			phead=phead.pNext;
//		}
//		while(!stack.isEmpty()){
//			System.out.println(stack.pop().data);
//		}
	}

}

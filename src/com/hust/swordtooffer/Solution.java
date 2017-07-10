package com.hust.swordtooffer;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    
    //1->2->3->4
    // 保存2，保存3
    // 1<-2 3->4 
	
	/*
	 * 反转链表
	 */
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        
        ListNode  reverseHead=null;
		ListNode  curNode=head;
        ListNode  preNode=null;
      
   
       while(curNode!=null){
            ListNode  nextNode=curNode.next;
           	curNode.next=preNode;
           	preNode=curNode;
           	curNode=nextNode;
           	reverseHead=preNode;
        }
        return reverseHead;
       
    }
}
package com.hust.swordtooffer;

public class FindEntranceCircleChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
		 ListNode meetNode=null;
		 if(pHead==null){
			 return meetNode;
		 }
		 meetNode=findMeet(pHead);
		 if(meetNode==null){
			 return meetNode;
		 }
		 ListNode midNode=meetNode;
		 meetNode=null;
	     ListNode first=pHead;
         while(midNode!=null&&first!=null){
        	 if(midNode==first){
        		 meetNode=midNode;
        		 break;
        	 }
        	 midNode=midNode.next;
        	 first=first.next;
         }
         return meetNode;
    }
	 
	 public ListNode findMeet(ListNode pHead){
		    ListNode tempNode=null;
		 	ListNode fast=pHead;
	        ListNode slow=pHead;
	        if(pHead==null){
	        	return tempNode;
	        }
	        while(fast!=null&&slow!=null){
	        	if(fast.next!=null){
	        		fast=fast.next.next;
	        	}
	        	slow=slow.next;
	        	if(fast==slow){
	        		tempNode=fast;
	        		break;
	        	}
	        }
	       return tempNode;
	 }

}



package com.hust.swordtooffer;

public class MergeSortChainTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
	 */
	 public ListNode Merge(ListNode list1,ListNode list2) {		
		 if(list1==null){
			 return list2;
		 }
		 if(list2==null){
			 return list1;
		 }
		 if(list1.val<=list2.val){
			 list1.next=Merge(list1.next,list2);
			 return list1;
		 }else{
			 list2.next=Merge(list2.next,list1);
			 return list2;
		 }
	 }
}

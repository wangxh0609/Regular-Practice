package com.hust.swordtooffer;

public class NumRepeatOneInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
	 */
	 public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		 if(array==null){
			 return;
		 }
		 if(num1==null){
			 num1=new int[1];
		 }
		 if(num2==null){
			 num2=new int[1];
		 }
		 if(array.length==2){
			 num1[0]=array[0];
			 num2[0]=array[1];
		 }
		 int bitResult=0;
		 for(int i=0;i<array.length;i++){
			 bitResult^=array[i];
		 }
		// index=
		 		 
	        
	 }
}

package com.hust.swordtooffer;

public class NumRepeatOneInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
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

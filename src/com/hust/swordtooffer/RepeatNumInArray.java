package com.hust.swordtooffer;

import java.util.*;

public class RepeatNumInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ�
	 * ���ҳ�����������һ���ظ������֡� ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ��������ظ�������2����3��
	 */
	 public boolean duplicate(int numbers[],int length,int [] duplication) {
		 Map<Integer,Integer> map=new HashMap<>();
		 boolean hasRepeat=false;
		 if(numbers==null){
			 return hasRepeat;
		 }
		 if(duplication==null){
			 duplication=new int[1];
		 }
		 for(int i=0;i<length;i++){
			 if(map.containsKey(numbers[i])){
				 duplication[0]=numbers[i];
				 hasRepeat=true;
				 break;
			 }
			 else{
				 map.put(numbers[i],1);
			 }
		 }		 
		 return hasRepeat;
	 }
}

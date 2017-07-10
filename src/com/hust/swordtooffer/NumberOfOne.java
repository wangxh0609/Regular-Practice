package com.hust.swordtooffer;

public class NumberOfOne {

	public static void main(String[] args) {
		System.out.println(numberOf1_1(9));

	}
	/*
	 * ͳ�����Ķ����Ʊ�ʾ��1�ĸ���
	 * һ��ⷨ��ע������������ƽ����ܲ�����ѭ��
	 */
	public static int numberOf1(int src){
		int count=0;
		int flag=1;
		while(flag>0){
			if((flag&src)>0){
				count++;
			}
			flag=flag<<1;
		}
		return count;
	}
/*
 * �߶˵�Ľⷨ
 */
	public static int numberOf1_1(int src){
		int count=0;
		while(src!=0){
			src=src&(src-1);
			count++;
		}
		return count;
	}
	
}

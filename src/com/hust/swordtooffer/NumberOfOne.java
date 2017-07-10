package com.hust.swordtooffer;

public class NumberOfOne {

	public static void main(String[] args) {
		System.out.println(numberOf1_1(9));

	}
	/*
	 * 统计数的二进制表示中1的个数
	 * 一般解法，注意如果采用右移将可能产生死循环
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
 * 高端点的解法
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

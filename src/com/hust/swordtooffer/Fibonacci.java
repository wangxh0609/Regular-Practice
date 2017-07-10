package com.hust.swordtooffer;

public class Fibonacci {
	/*
	 * 非递归算法计算 斐波那契数列
	 */

	public static void main(String[] args) {
		

	}

	public static int FibonacciNth(int n){
		if(n==0){
			return 0;
		}else if(n==1){
			return 1;
		}else{
			int preOne=1;
			int preTwo=0;
			int cur=0;
			for(int i=2;i<n;i++){
				cur=preOne+preTwo;
				preTwo=preOne;
				preOne=cur;
			}
			return cur;
		}
	}
}

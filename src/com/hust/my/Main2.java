package com.hust.my;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		while(scan.hasNextLine()){
			System.out.println(getLastStatus(scan.nextLine()));
		}

	}
	public static String getLastStatus(String input){
		String status="123456";
		char[] statusChar=status.toCharArray();
		int length=input.length();
		for(int i=0;i<length;i++){
			char ope=input.charAt(i);
			switch(ope){
			
				case 'A'://左0 右1 前2 后3 上4 下5
					changePos(statusChar,0,2,3,1);
//					temp=statusChar[0];//左
//					statusChar[0]=statusChar[2];
//					temp1= statusChar[3];//后
//					statusChar[3]=temp;
//					temp=statusChar[1];//右
//					statusChar[1]=temp1;
//					statusChar[2]=temp;
					//左翻转  上下不变   2j 前给左0i  ，0左给后3k   ，3后给右h1， 1右给前2
					break;
				case 'C'://右翻转  上下不变   前2给右 1 ，右给后3   ，后给左， 左给前
					//左右前后上下
					changePos(statusChar,1,2,3,0);
					break;
				case 'F':	//前翻转  左右不变  前2给下5  下5给后  3后给上4，上给前;
					changePos(statusChar,5,2,3,4);
					break;
				case 'B'://后翻转 
					changePos(statusChar,4,2,3,5);
					break;
				case 'L'://逆时针旋转 前后不变  上4给左0  左给下5 下给右 右给上
					changePos(statusChar,0,4,5,1);
					break;
				case 'R'://顺时针旋转
					changePos(statusChar,1,4,5,1);
					break;
			}
		}
		
		
		return status;
		
	}
	public static void changePos(char[] statusChar,int i,int j, int k, int h){
		//上下不变   2j 前给左0i  ，0左给后3k   ，3后给右h1， 1右给前2
		//左右前后上下
		//0,2,3,1
		//temp=statusChar[0];//左
//		statusChar[0]=statusChar[2];
//		temp1= statusChar[3];//后
//		statusChar[3]=temp;
//		temp=statusChar[1];//右
//		statusChar[1]=temp1;
//		statusChar[2]=temp;
		
		
		char temp;
		char temp1;//i=0;j=2,k=3,h=1
		temp=statusChar[i];//左
		statusChar[i]=statusChar[j];
		temp1= statusChar[k];//后
		statusChar[k]=temp;
		temp=statusChar[h];//右
		statusChar[h]=temp1;
		statusChar[j]=temp;
	}
}

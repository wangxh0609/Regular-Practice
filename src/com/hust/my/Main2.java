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
			
				case 'A'://��0 ��1 ǰ2 ��3 ��4 ��5
					changePos(statusChar,0,2,3,1);
//					temp=statusChar[0];//��
//					statusChar[0]=statusChar[2];
//					temp1= statusChar[3];//��
//					statusChar[3]=temp;
//					temp=statusChar[1];//��
//					statusChar[1]=temp1;
//					statusChar[2]=temp;
					//��ת  ���²���   2j ǰ����0i  ��0�����3k   ��3�����h1�� 1�Ҹ�ǰ2
					break;
				case 'C'://�ҷ�ת  ���²���   ǰ2���� 1 ���Ҹ���3   ������� ���ǰ
					//����ǰ������
					changePos(statusChar,1,2,3,0);
					break;
				case 'F':	//ǰ��ת  ���Ҳ���  ǰ2����5  ��5����  3�����4���ϸ�ǰ;
					changePos(statusChar,5,2,3,4);
					break;
				case 'B'://��ת 
					changePos(statusChar,4,2,3,5);
					break;
				case 'L'://��ʱ����ת ǰ�󲻱�  ��4����0  �����5 �¸��� �Ҹ���
					changePos(statusChar,0,4,5,1);
					break;
				case 'R'://˳ʱ����ת
					changePos(statusChar,1,4,5,1);
					break;
			}
		}
		
		
		return status;
		
	}
	public static void changePos(char[] statusChar,int i,int j, int k, int h){
		//���²���   2j ǰ����0i  ��0�����3k   ��3�����h1�� 1�Ҹ�ǰ2
		//����ǰ������
		//0,2,3,1
		//temp=statusChar[0];//��
//		statusChar[0]=statusChar[2];
//		temp1= statusChar[3];//��
//		statusChar[3]=temp;
//		temp=statusChar[1];//��
//		statusChar[1]=temp1;
//		statusChar[2]=temp;
		
		
		char temp;
		char temp1;//i=0;j=2,k=3,h=1
		temp=statusChar[i];//��
		statusChar[i]=statusChar[j];
		temp1= statusChar[k];//��
		statusChar[k]=temp;
		temp=statusChar[h];//��
		statusChar[h]=temp1;
		statusChar[j]=temp;
	}
}

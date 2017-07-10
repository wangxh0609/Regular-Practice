package com.hust.swordtooffer;

import java.util.*;

public class FirstOneAppearInString {

	public static void main(String[] args) {
		String str="google";
		// TODO Auto-generated method stub
		System.out.println(FirstNotRepeatingChar(str));
	}
	
	/*
	 * ��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,
	 * ����������λ�á�����ַ���Ϊ��,����-1 
	 */
	/*
	 * ˼·��һ��list��¼����
	 * �ڶ��������¼���ֵĴ���
	 * �����������¼���ֵ�һ�ε�λ�� ���ظ������е�һ��
	 */
	public static int FirstNotRepeatingChar(String str) {
		
		if(str==null||str.isEmpty()){
			return -1;
		}
		List<Character> list=new ArrayList<>();
		int[] charCount=new int[52];
		int[] charPos=new int[52];
		int length=str.length();
		for(int i=0;i<length;i++){
			int pos=0;
			if((pos=list.indexOf(str.charAt(i)))>=0){
				charCount[pos]+=1;
			}else{
				list.add(str.charAt(i));				
				charPos[list.size()-1]=i;
				charCount[list.size()-1]=1;
			}
			
		}
		for(int i=0;i<charCount.length;i++){
			if(charCount[i]==1){
				return charPos[i];
			}
		}
        return 0;
    }

}

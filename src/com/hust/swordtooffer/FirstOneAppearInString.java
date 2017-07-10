package com.hust.swordtooffer;

import java.util.*;

public class FirstOneAppearInString {

	public static void main(String[] args) {
		String str="google";
		// TODO Auto-generated method stub
		System.out.println(FirstNotRepeatingChar(str));
	}
	
	/*
	 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
	 * 并返回它的位置。如果字符串为空,返回-1 
	 */
	/*
	 * 思路，一个list记录次序
	 * 第二个数组记录出现的次数
	 * 第三个数组记录出现第一次的位置 返回该数组中的一个
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

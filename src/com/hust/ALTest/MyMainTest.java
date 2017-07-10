package com.hust.ALTest;

import java.util.*;

public class MyMainTest {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int[] srcInt=new int[]{88,459,5262,88,-17,677,88,667,-17,459,5262};
		System.out.println(getNumberRepeatThree(srcInt));
	}
	
	public static int getNumberRepeatThree(int[] srcInt){
		if(srcInt==null){
			return -1;
		}
		int findNum=-1;
		int length=srcInt.length;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<length;i++){
			if(map.containsKey(srcInt[i])){
				int num=map.get(srcInt[i]);
				if(num==2){
					findNum=srcInt[i];
					break;
				}
				else{
					map.put(srcInt[i], num+1);
				}				
			}else{
				map.put(srcInt[i],1);
			}
			
		}
		
		return findNum;
		
		
	}

}

package com.hust.mutiThread;

import java.util.*;

public class MaxOfWindow {

	public static void main(String[] args) {
		int [] num=new int[]{2,3,4,2,6,2,5,1};
		int size=3;
		ArrayList<Integer> list=maxInWindows(num,size);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	 public static ArrayList<Integer> maxInWindows(int [] num, int size)
	    {
		 	ArrayList<Integer> list=new ArrayList<Integer>();
			if(size<=0||num==null||size>num.length){
				return null;
			}
			int windowCount=num.length-size+1;
			for(int i=0;i<windowCount;i++){
				getMax(num,size,list,i);
			}
		    return list;
	    }	    
	    public static void getMax(int[] num, int size,List<Integer> list,int count){
			int max=0;
			if(list.size()==0){
				max=num[0];
				for(int i=1;i<size;i++){
					if(max<num[i]){
						max=num[i];
					}
				}
				
			}else{
				max=list.get(list.size()-1);
				if(num[count-1]==max){
					max=num[count];
					for(int i=count+1;i<size+count;i++){
						if(max<num[i]){
							max=num[i];
						}
					}
				}else{//比较最大值与新加进来的值谁大即可
					if(max<num[size+count-1]){
						max=num[size+count-1];
					}
				}
		    }
			list.add(max);				
			return;
	    }
}

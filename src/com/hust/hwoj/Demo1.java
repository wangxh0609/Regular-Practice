package com.hust.hwoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo1 {
	 public static void main(String[] args){  
	     Scanner scan=new Scanner(System.in);  
	     while(scan.hasNextInt()){  
	        System.out.println(numberOf1(scan.nextInt()));     
	           
	     }  
	       
	 }  
	 public static int numberOf1(int n){
	        int count = 0;
	        int flag = 1;
	        while(flag!=0){
	            if((n&flag)!=0){
	                count++;
	            }
	            flag = flag<<1;
	        }
	        return count;
	    }
	    public static int findNumberOf1(int intnum)  
	    {  
	    	if(intnum<0){
	    		intnum=Math.abs(intnum);
	    	}
	        int count=0;  
	        while(intnum>0){  
	            if((intnum&1)==1){  
	                count++;  
	            }  
	           intnum>>=1;  
	        }  
	        return count ; 
	          
	    }  
	    public ArrayList<Integer> maxInWindows(int [] num, int size)
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
	    //public int count=0;
	  //public int count=0;
	    /*
	    输入判断   
	    计算总共有几个窗口，窗口总数为num.length-size+1个
	    首先得到第一个窗口的最大值，加入list 并传进去第几个窗口count
	    再得到第i个窗口的最大值 第i个窗口的最大值为 如果前一个窗口出去的不是list对应的前一个窗口的最大值，则比较前一个窗口的最大值与新加进来值的大小（size+i）
	    */
	    public void getMax(int[] num, int size,List<Integer> list,int count){
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
					for(int i=count;i<size+count;i++){
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

package com.hust.my;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		//List<Integer> list=new ArrayList<Integer>();
		while(scan.hasNextInt()){
			int a=scan.nextInt();
            int b=scan.nextInt();
			
			System.out.println(reverseAdd(a,b));
			
		}
	}

	public static int reverseAdd(int a,int b){
		if(a<1||a>70000||b<1||b>70000){
	          return -1;
	      }
		int aa=intreverse(a);
		int bb=intreverse(b);
		return aa+bb;
	}
	
	public static int intreverse(int x) {    
		  long tmp = x; // 防止结果溢出    
		  long result = 0;    
		  while (tmp != 0) {    
		     result = result *10 + tmp % 10;    
		     tmp = tmp /10; }    
		    // 溢出判断    
		    if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)  
		    {    
		     result =0; }    
		     return (int) result;     
		   }  
	
}

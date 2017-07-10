package com.hust.hwoj;
import java.util.*;  
public class HCD {

	  
	
	    public static void main(String[] args) {  
	        Scanner sc=new Scanner(System.in);  
	        int n=sc.nextInt();  
	        int[] upArr=new int[n];  
	        int[] downArr=new int[n];  
	        int[] input=new int[n];  
	        for(int i=0;i<n;i++){              
	            upArr[i]=1;  
	            downArr[i]=1;  
	        }  
	        for(int i=0;i<n;i++){  
	            input[i]=sc.nextInt();  
	        }  
	              
	        for(int i=0;i<n;i++)  
	        {  
	            if(i==0){  
	                upArr[i]=1;  
	                continue;  
	            }  
	            for(int j=0;j<i;j++)  
	            {  
	                if(input[i]>input[j])  
	                {  
	                    if(upArr[j]+1>upArr[i]){  
	                        upArr[i]=upArr[j]+1;  
	                    }  
	                }  
	            }  
	              
	        }  
	        for(int i=n-1;i>=0;i--)  
	        {  
	            if(i==n-1)  
	            {  
	                downArr[i]=1;  
	                continue;  
	            }  
	            for(int j=n-1;j>i;j--)  
	            {  
	                if(input[i]>input[j])  
	                {  
	                    if(downArr[j]+1>downArr[i]){  
	                        downArr[i]=downArr[j]+1;  
	                    }  
	                }  
	            }  
	        }  
	        int max=upArr[0]+downArr[0];  
	        for(int i=0;i<n;i++){  
	            if(max<upArr[i]+downArr[i]){  
	                max=upArr[i]+downArr[i];  
	            }  
	        }  
	        System.out.println(n-max+1);  
	        sc.close();  
	    }  
	      
	             
 
}

package com.hust.my;

import java.util.*;  
public class DAAD{    
 public static void main(String[] args){    
       Scanner scan=new Scanner(System.in);  
       while(scan.hasNextInt()){
	       int input=scan.nextInt();  
	       snackMatric(input);  
       }
 }    
   public static void snackMatric(int input){    
       if(input<=0){    
           return;    
       }    
       int[][] inputArr=new int[input][input];    
       inputArr[0][0]=1;    
       int i;    
       int j;    
       for(i=0;i<input;i++){    
            for(j=0;j<input-i;j++){    
                if(i==0&&j==0){    
                    continue;    
                }    
                else if(j==0){    
                    inputArr[i][0] = inputArr[i-1][0]+i;    
                }    
                else{    
                     inputArr[i][j]=inputArr[i][j-1]+1+i+j;    
                }    
            }    
       }    
         for(i=0;i<input;i++){    
            for(j=0;j<input-i;j++){    
              System.out.print(inputArr[i][j]+" ");    
            }    
             if(i!=input-1){    
                 System.out.println();    
             }    
       }    
           
   }    
}
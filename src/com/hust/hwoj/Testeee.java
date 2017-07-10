package com.hust.hwoj;

import java.util.*;

public class Testeee {
	 public static int getMaxValue(int[] val, int[] weight, int[] q, int num, int money) {
	        int[][] dp = new int[num + 1][money + 1];
	        for (int i = 1; i <= num; i++) {
	            for (int j = 1; j <= money; j++) {
	                if (q[i-1] == 0) {  // 主件
	                    if (weight[i - 1] <= j) // 用j这么多钱去买 i 件商品 可以获得最大价值
	                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j- weight[i - 1]]+ val[i - 1]);
	                }
	                else { //附件
	                    if (weight[i - 1] + weight[q[i - 1]] <= j) //附件的话 加上主件一起算
	                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j- weight[i - 1]]+ val[i - 1]);
	                }
	            }
	        }
	        return dp[num][money];
	    }
	 
	 public static void main(String[] args) {  
         Scanner scan=new Scanner(System.in);  
         int moneyAll=scan.nextInt();
         int buyCount=scan.nextInt();
         int[] price=new int[buyCount];
         int[] weight=new int[buyCount];
         int[] code=new int[buyCount];       
         for(int i=0;i<buyCount;i++){
             price[i]=scan.nextInt();
             weight[i]=price[i]*scan.nextInt();
             code[i]=scan.nextInt();
         }
     	//System.out.println(getMaxSum(moneyAll,price,weight,code));
     }
     
     /*
     背包问题的变形 二维数组 列表示多少钱，行表示在商品，在每一行表示只能选择该行以下的商品
     */
     public int getMaxSum(int moneyAll,int buyCount,int[] price,int[] weight,int[] code){          
         
         int[][] weightMatrix=new int[buyCount+1][moneyAll+1];
         for(int i=1;i<=buyCount;i++){
             for(int j=1;j<=moneyAll;j++){
                 if(code[i-1]==0){
                     weightMatrix[i][j]=Math.max(weightMatrix[i-1][j],weightMatrix[i-1][j-price[i-1]]+weight[i-1]);
                 }else{
                      //如何判断已经加进来了主件是个问题
                         //前面没有加主件就加进来
                     if(weight[i-1]+weight[code[i-1]]<=j){
                        
                         weightMatrix[i][j]=Math.max(weightMatrix[i-1][j],weightMatrix[i-1][j-price[i-1]-price[code[i-1]]]+weight[i-1]);
                         //如果加了主件
                         
                     }
                 }
             }
         }
         
         
         
         return weightMatrix[buyCount][moneyAll];
     }      
	

}

package com.hust.my;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		//int[][] array=new int[][]{{1,2,8,9},{4,7,10,13}};
		//System.out.println(new Solution().Find(7, array));
		Scanner scan=new Scanner(System.in);
		String str="";
		//str.trim()
		while(scan.hasNextLine());
		System.out.println(6&5);
	}
	
	public boolean Find(int target, int [][] array) {
        if(array==null){
            return false;
        }
        int rowCount=array.length;
        if(rowCount<1){
            return false;
        }
        int columnCount=array[0].length;
        for(int i=0;i<rowCount;i++){
            for(int j=columnCount-1;j>=0;j--){
                if(array[i][j]>target){
                    columnCount=columnCount-1;
                    if(columnCount==0){
                        return false;
                    }
                }
                else if(array[i][j]<target){
                    break;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
	
}

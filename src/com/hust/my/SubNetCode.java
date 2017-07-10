package com.hust.my;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SubNetCode {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		while(scan.hasNextLine()){
			String mask=scan.nextLine();
			//String[] strArr=str.split(" ");
			String ip1=scan.nextLine();
			String ip2=scan.nextLine();
		//ip1.substring(beginIndex)
			System.out.println(checkNetSegment(mask,ip1,ip2));
		}
		HashSet<Integer> set=new HashSet<>();
		Iterator<Integer> iter=set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		
		
	}
	
	
	public static int checkNetSegment(String mask, String ip1, String ip2) {
		if(mask==null||ip1==null||ip2==null){
			return 1;
		}
		String[] maskArr=mask.split("\\.");
		String[] ip1Arr=ip1.split("\\.");
		String[] ip2Arr=ip2.split("\\.");
		if(checkIsLegal(maskArr)&&checkIsLegal(ip1Arr)&&checkIsLegal(ip2Arr)){
			int length=maskArr.length;
			for(int i=0;i<length;i++){
				if(!andIsEqual(maskArr[i],ip1Arr[i],ip2Arr[i])){
					return 2;
				}
			}
		}
		else{
			return 1;
		}
		return 0;
	}
	public static boolean checkIsLegal(String[] srcChar){
		int length=srcChar.length;
		if(length>4){
			return false;
		}
		else {
			for(int i=0;i<length;i++){
				if(Integer.valueOf(srcChar[i].trim())>255||Integer.valueOf(srcChar[i].trim())<0){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean andIsEqual(String mask,String ip1,String ip2){
		if((Integer.valueOf(mask)&Integer.valueOf(ip1))==(Integer.valueOf(mask)&Integer.valueOf(ip2))){
			return true;
		}
		else{
			return false;
		}
		
	}

}

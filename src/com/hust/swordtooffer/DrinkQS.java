package com.hust.swordtooffer;
import java.util.*;
public class DrinkQS {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		while(scan.hasNextLine()){
			count=0;
			int intSrc=Integer.parseInt(scan.nextLine());
			if(intSrc==0){
				return;
			}
			getCount(intSrc);
			System.out.println(count);
		}

	}
	public static int count=0;
	public static void getCount(int countAll){
		int canGet=countAll/3;
		int emptyCount=countAll%3;
		count+=canGet;
		int allEmpty=canGet+emptyCount;
		if(allEmpty>3){
			getCount(allEmpty);
		}
		if(allEmpty==2){
			count++;
		}
		
	}

}

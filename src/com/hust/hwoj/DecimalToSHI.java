package com.hust.hwoj;

import java.util.Scanner;

public class DecimalToSHI {
		public static void main(String[] args){
			Scanner scan=new Scanner(System.in);
			while(true){
				String str=scan.next();
				int number=calculateToDecimalism(str);
				System.out.println(number);			
			}
		}
		public static int calculateToDecimalism(String str){
		if(str==null){
		}
		String temp=str.substring(2,str.length());
		int length=temp.length();
		int number=0;
		for(int i=length-1;i>=0;i--){
			//int up=1
			int base=charToInt(temp.charAt(i));
			base=base<<(4*(length-i-1));
			number+=base;
		}
		return number;
		
	}
	
	public static int charToInt(char myChar){
		switch(myChar){
			case '0':
				return 0;
			case '1':
				return 1;
			case '2':
				return 2;
			case '3':
				return 3;
			case '4':
				return 4;
			case '5':
				return 5;
			case '6':
				return 6;
			case '7':
				return 7;
			case '8':
				return 8;
			case '9':
				return 9;
			case 'A':
				return 10;
			case 'B':
				return 11;
			case 'C':
				return 12;
			case 'D':
				return 13;
			case 'E':
				return 14;
			case 'F':
				return 15;
			default:
				return 0;
		}
	}
	
	
	

}

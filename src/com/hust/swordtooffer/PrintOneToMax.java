package com.hust.swordtooffer;

public class PrintOneToMax {

	public static void main(String[] args) {
		
		printMaxOfDegits(2);
	}
	
	public static void printMaxOfDegits(int n){
		if(n<=0){
			return;
		}		
		for(int i=0;i<10;i++){
			char[] sb=new char[n];
			sb[0]=(char)(i+'0');
			printMaxOfDegitsRecur(sb,n,0);
		}		
	}	
	public static void printMaxOfDegitsRecur(char[] sb,int n,int index){
		if(n-1==index){
			printNumber(sb);			
			return;
		}
		for(int i=0;i<10;i++){
			sb[index+1]=(char)(i+'0');
			printMaxOfDegitsRecur(sb,n,index+1);
		}		
	}	
	public static void printNumber(char[] number){
		int length=number.length;
		if(length==0){
			return;
		}
		boolean isbeginzero=true;
		for(int i=0;i<length;i++){
			if(number[i]!='0'){
				isbeginzero=false;
			}
			if(!isbeginzero){
				System.out.print(number[i]);
				if(i==length-1){
					System.out.println();
				}
			}	
		
		}
	}

}



package com.hust.thread;

public class TaskSplit {

	public static void main(String[] args) {
		parseExcel(1,500);
	}

	public static void parseExcel(int start,int end){
		
		if(end<=start){
			return;
		}
		if(end-start>50){
			int b=start+(end-start)/2;
			Thread thread1=new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					parseExcel(start,b);
				}
			});
			Thread thread2=new Thread(new Runnable() {
				
				@Override
				public void run() {
					parseExcel(b+1,end);
				}
			});
			thread1.start();
			thread2.start();
			try {
				thread1.join();
				thread2.join();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			
		}
		else{
			for(int i=start;i<=end;i++){
				System.out.println(i);
			}
		}
	}
}

package com.hust.thread.SkyNet;

import java.util.Vector;

public class Test {
	ThreadLocal<Integer> tl=new ThreadLocal<>();
	private static volatile boolean ready;
	private static int number;

	public static void main(String[] args) {
		new ReaderThread().start();
		number=42;
		ready=true;
	}
	static class ReaderThread extends Thread{
		public void run(){
			while(!ready){
				Thread.yield();				
			}
			System.out.println(number);
		}
	}
	
} 

class MyTestDo{
	private MyTestDo(){
		
	}
	private static MyTestDo _instance=new MyTestDo();
	
	public static MyTestDo getInstance(){
		return _instance;
	}
	
	public void doSome(Object key,String value){
		try {
			Thread.sleep(1000);
			System.out.println(key+":"+value+":"+(System.currentTimeMillis()/1000));
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}

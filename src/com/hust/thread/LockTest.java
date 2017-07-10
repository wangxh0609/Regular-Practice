package com.hust.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	public static void main(String[] args){
		new LockTest().init();
	}
	private void init(){
		final Outputer output=new Outputer();
		new Thread(new Runnable() {			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					output.output("aaaaaaa");
				}
				
			}
		}).start();
		
new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					output.output("hhhhhhhh");
				}
				
			}
		}).start();
	}	
	class Outputer{
		Lock lock=new ReentrantLock();
		public void output(String names){
			
			int len=names.length();
			lock.lock();
			try
			{
				for(int i=0;i<len;i++){
					System.out.print(names.charAt(i));
				}
				System.out.println();
			}finally{
				lock.unlock();
			}
		}
	}
}

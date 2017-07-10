package com.hust.thread.SkyNet;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class ComsumerTest {
	public static void main(String[] args){
		Semaphore sp=new Semaphore(1);
		//同步队列 只有有人需要时才放的进去
		SynchronousQueue<String> queue=new SynchronousQueue<String>();
		for(int i=0;i<10;i++){
			new Thread(new Runnable() {				
				@Override
				public void run() {			
					try {
						sp.acquire();
						String output = TestDo.doSome(queue.take());
						System.out.println(Thread.currentThread().getName()+":"+output);
						sp.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
			}).start();
			
		}
		
		 System.out.println("begin:"+(System.currentTimeMillis()/1000));
		
		 for(int i=0;i<10;i++){//这行不能改动
			 String intput=i+"";//这行不能改动
			 	try {
					queue.put(intput);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
		 }
	}
} 

//不能改动此类
class TestDo{
	public static String doSome(String input){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
		String output=input+":"+(System.currentTimeMillis()/1000);
		return output;
	}
}

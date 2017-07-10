package com.hust.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueApplyingTest {
	public static void main(String[] args){
		//LinkedBlockingQueue<E>
		BlockingQueue queue=new ArrayBlockingQueue(3);
		for(int i=0;i<2;i++){
			new Thread(){
				public void run(){
					while(true){
						try{
							Thread.sleep((long)Math.random()*1000);
							System.out.println(Thread.currentThread().getName()+"准备放数据");
							queue.put(1);
							System.out.println(Thread.currentThread().getName()+"放了数据，队列目前有"+queue.size()+"个数据");
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
				}
			}.start();
		}
		new Thread(){
			public void run(){
				while(true){
					try{
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()+"准备取数据");
						queue.take();
						System.out.println(Thread.currentThread().getName()+"取走一个数据，队列目前有"+queue.size()+"个数据");
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
				}
			}
		}.start();
	}
}

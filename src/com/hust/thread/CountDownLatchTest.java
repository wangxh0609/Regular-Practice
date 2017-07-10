package com.hust.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//CountDownLatch当计数结果为0时 所有的等待者或单个等待者开始执行

public class CountDownLatchTest {
	public static void main(String[] args){
		ExecutorService threadpool = Executors.newCachedThreadPool();
		final CountDownLatch cdorder=new CountDownLatch(1);
		final CountDownLatch cdanswer=new CountDownLatch(3);
		for(int i=0;i<3;i++){
			Runnable runnable=new Runnable() {
				
				@Override
				public void run() {
					
					try {
						System.out.println("线程"+Thread.currentThread().getName()+"正准备接受命令");
						cdorder.await();
						System.out.println("线程"+Thread.currentThread().getName()+"已接受命令");
						
						Thread.sleep((long)Math.random()*10000);
						System.out.println("线程"+Thread.currentThread().getName()+"回应命令处理结果");
						cdanswer.countDown();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
			threadpool.execute(runnable);
		}
		
		try {
			Thread.sleep((long)Math.random()*10000);
			System.out.println("线程"+Thread.currentThread().getName()+"即将发布命令");
			cdorder.countDown();
			System.out.println("线程"+Thread.currentThread().getName()+"已发送命令，正在等待结果");
			cdanswer.await();
			System.out.println("线程"+Thread.currentThread().getName()+"已收到所有响应结果");
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadpool.shutdown();
		
	}
}

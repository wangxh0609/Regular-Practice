package com.hust.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	//Semaphore与阻塞队列有什么区别吗除了缓冲区
	//
	//
	//
	public static void main(String[] args){
		
		ExecutorService threadpool = Executors.newCachedThreadPool();
	
		final Semaphore sp=new Semaphore(3);
		
		
		for(int i=0;i<10;i++){
			Runnable runnable=new Runnable() {
				
				@Override
				public void run() {					
						try {
							sp.acquire();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("线程" + Thread.currentThread().getName() +" 进入，当前有" + (3- sp.availablePermits())+ " 个线程并发");
						try {
							Thread.sleep((long)(Math.random()*10000));
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
						System.out.println("线程"+Thread.currentThread().getName()+"即将离开");
						sp.release();
						
						System.out.println("线程"+Thread.currentThread().getName()+"已离开,当前已有"+(3-sp.availablePermits())+"个线程并发");
				}
			};
			
			threadpool.execute(runnable);
			
		}
		
	}

}

//使用Semaphore控制任务的提交速率
class BoundedExecutor{
	private final Executor exec;
	private final Semaphore semaphore;
	public BoundedExecutor(Executor exec,Semaphore semaphore){
		this.exec=exec;
		this.semaphore=semaphore;
	}
	public void submitTask(final Runnable command) throws InterruptedException{
		semaphore.acquire();
		try{
			exec.execute(new Runnable() {
				
				@Override
				public void run() {
					try{
						command.run();
					}finally{
						semaphore.release();
					}
					
				}
			});
		}catch(RejectedExecutionException e){
			semaphore.release();
		}
		
	}
	
	
	
	
	
}




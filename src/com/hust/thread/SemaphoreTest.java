package com.hust.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	//Semaphore������������ʲô��������˻�����
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
						System.out.println("�߳�" + Thread.currentThread().getName() +" ���룬��ǰ��" + (3- sp.availablePermits())+ " ���̲߳���");
						try {
							Thread.sleep((long)(Math.random()*10000));
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
						System.out.println("�߳�"+Thread.currentThread().getName()+"�����뿪");
						sp.release();
						
						System.out.println("�߳�"+Thread.currentThread().getName()+"���뿪,��ǰ����"+(3-sp.availablePermits())+"���̲߳���");
				}
			};
			
			threadpool.execute(runnable);
			
		}
		
	}

}

//ʹ��Semaphore����������ύ����
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




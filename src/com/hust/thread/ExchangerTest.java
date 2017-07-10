package com.hust.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//买卖，两者到了之后开始工作然后各忙各的
public class ExchangerTest {
	public static void main(String[] args){
		//Exchanger<Integer> 
		ExecutorService threadpool = Executors.newCachedThreadPool();
		
		final Exchanger exchanger=new Exchanger<>();
		threadpool.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					String data1="zxx";
					System.out.println("线程"+Thread.currentThread().getName()+"正在把数据"+data1+"交换出去");
				
					Thread.sleep((long)Math.random()*10000);
					String data2=(String)exchanger.exchange(data1);
					System.out.println("线程"+Thread.currentThread().getName()+"换回的数据"+data2);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
threadpool.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					String data1="lhm";
					System.out.println("线程"+Thread.currentThread().getName()+"正在把数据"+data1+"交换出去");
				
					Thread.sleep((long)Math.random()*10000);
					String data2=(String)exchanger.exchange(data1);
					System.out.println("线程"+Thread.currentThread().getName()+"换回的数据"+data2);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}

}

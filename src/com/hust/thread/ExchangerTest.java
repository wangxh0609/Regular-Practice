package com.hust.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//���������ߵ���֮��ʼ����Ȼ���æ����
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
					System.out.println("�߳�"+Thread.currentThread().getName()+"���ڰ�����"+data1+"������ȥ");
				
					Thread.sleep((long)Math.random()*10000);
					String data2=(String)exchanger.exchange(data1);
					System.out.println("�߳�"+Thread.currentThread().getName()+"���ص�����"+data2);
					
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
					System.out.println("�߳�"+Thread.currentThread().getName()+"���ڰ�����"+data1+"������ȥ");
				
					Thread.sleep((long)Math.random()*10000);
					String data2=(String)exchanger.exchange(data1);
					System.out.println("�߳�"+Thread.currentThread().getName()+"���ص�����"+data2);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}

}

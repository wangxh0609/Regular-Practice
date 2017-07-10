package com.hust.thread.SkyNet;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class ComsumerTest {
	public static void main(String[] args){
		Semaphore sp=new Semaphore(1);
		//ͬ������ ֻ��������Ҫʱ�ŷŵĽ�ȥ
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
		
		 for(int i=0;i<10;i++){//���в��ܸĶ�
			 String intput=i+"";//���в��ܸĶ�
			 	try {
					queue.put(intput);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
		 }
	}
} 

//���ܸĶ�����
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

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
							System.out.println(Thread.currentThread().getName()+"׼��������");
							queue.put(1);
							System.out.println(Thread.currentThread().getName()+"�������ݣ�����Ŀǰ��"+queue.size()+"������");
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
						System.out.println(Thread.currentThread().getName()+"׼��ȡ����");
						queue.take();
						System.out.println(Thread.currentThread().getName()+"ȡ��һ�����ݣ�����Ŀǰ��"+queue.size()+"������");
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
				}
			}
		}.start();
	}
}

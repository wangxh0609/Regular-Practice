package com.hust.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//��ʾ��ұ˴˵ȴ�����Ҽ��Ϻú�ų�������ɢ�������ָ���ص㼯������ 
public class CyclicBarrierTest {
	//CyclicBarrier �Ǽ����̵߳���һ�����������̵߳���һ�����  �ĸ��ط��Ⱦ����ĸ��ط�����await()
	public static void main(String[] args){
		ExecutorService threadpool=Executors.newCachedThreadPool();
		final CyclicBarrier cb=new CyclicBarrier(3);
		for(int i=0;i<3;i++){
			Runnable runnable=new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep((long)Math.random()*10000);
						System.out.println("�߳�" + Thread.currentThread().getName() +  "��������ص�1����ǰ����"+(cb.getNumberWaiting()+1 )+"���߳�");
						//���������
						cb.await();
						Thread.sleep(10000);
						
						System.out.println("�߳�"+Thread.currentThread().getName()+"�������Ｏ�ϵص�2����ǰ����"+(cb.getNumberWaiting()+1)+"���߳�");
						
						cb.await();
						Thread.sleep(10000);
						System.out.println("�߳�"+Thread.currentThread().getName()+"�������Ｏ�ϵص�3����ǰ����"+(cb.getNumberWaiting()+1)+"���߳�");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			};
			threadpool.execute(runnable);
			
		}
		
		
		
		
	}

}

package com.hust.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//表示大家彼此等待，大家集合好后才出发，分散活动后又在指定地点集合碰面 
public class CyclicBarrierTest {
	//CyclicBarrier 是几个线程导了一个点后等其他线程到了一起出发  哪个地方等就在哪个地方调用await()
	public static void main(String[] args){
		ExecutorService threadpool=Executors.newCachedThreadPool();
		final CyclicBarrier cb=new CyclicBarrier(3);
		for(int i=0;i<3;i++){
			Runnable runnable=new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep((long)Math.random()*10000);
						System.out.println("线程" + Thread.currentThread().getName() +  "即将到达地点1，当前已有"+(cb.getNumberWaiting()+1 )+"个线程");
						//到达出发点
						cb.await();
						Thread.sleep(10000);
						
						System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合地点2，当前已有"+(cb.getNumberWaiting()+1)+"个线程");
						
						cb.await();
						Thread.sleep(10000);
						System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合地点3，当前已有"+(cb.getNumberWaiting()+1)+"个线程");
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

package com.hust.my;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MutiSplitTask {
	
	public static void main(String[] args) {
		
		
		long start=System.currentTimeMillis();
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				loopTest();
			}
		});
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				loopTest();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end=System.currentTimeMillis();		
		System.out.println(end-start);
		
		long start1=System.currentTimeMillis();
		loopTest();
		loopTest();
		long end1=System.currentTimeMillis();
		System.out.println(end1-start1);
	}
	public static void loopTest(){
		String str="";
		for(int i=0;i<90000;i++){
			str+=""+i;
		}
		
	}
}

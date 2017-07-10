package com.hust.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class ConcurrentTest {
	public static void main(String[] args){
		AtomicInteger ai=new AtomicInteger(1);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
			   
				
			}
		}).start();
		AtomicIntegerArray aia=new AtomicIntegerArray(2);
	}

}

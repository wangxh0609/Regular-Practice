package com.hust.thread;

import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadTest {
	Thread thread = new Thread();
	Hashtable<String, Integer> hashmap = new Hashtable<>();
	AtomicLong ac = new AtomicLong();
	StringBuffer sb = new StringBuffer();
	ThreadLocal<Integer> tl = new ThreadLocal<Integer>();

	public static void main(String[] args) {
		MyThread myThread1 = new MyThread();
		MyThread myThread2 = new MyThread();
		myThread1.start();
		myThread2.start();
	}
}

class MyThread extends Thread {
	public void run() {
		System.out.println("MyThread.run()");
	}
}

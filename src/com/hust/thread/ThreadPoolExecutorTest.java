package com.hust.thread;

import java.util.Hashtable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
	private static final int N_THREADS=2;
	private static final int CAPACITY=10;

	//创建了一个固定大小的线程池，并采用了有界队列以及“调用者优先”饱和策略
	
	public static void main(String[] args) {
		ThreadPoolExecutor executor=new ThreadPoolExecutor(N_THREADS, N_THREADS, 0l, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10));
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		//executor.submit()   submit()里面调用的是execute()
	}
	
}



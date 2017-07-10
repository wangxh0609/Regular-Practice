package com.hust.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	public static void main(String[] args) {
		// ExecutorService threadPool =
		// Executors.newFixedThreadPool(3);//创建固定线程池
		// ExecutorService threadPool = Executors.newCachedThreadPool();//动态增加线程
		ExecutorService threadPool = Executors.newSingleThreadExecutor();// 始终保持一个进程，如果一个死了就创建一个替身

		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		for (int i = 0; i < 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						System.out.println(Thread.currentThread().getName() + " in loop " + j + " task " + task);
					}
				}
			});

		}
		System.out.println("finished");
		threadPool.shutdown();
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {

			public void run() {
				System.out.println("bloming");

			}
		}, 6, 2, TimeUnit.SECONDS);
	}

	
}

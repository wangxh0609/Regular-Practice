package com.hust.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClallableTest {
	public static void main(String[] args){
		ExecutorService executorService=Executors.newFixedThreadPool(3);
		try{
			Future<String> future=executorService.submit(new MyCallable());
			System.out.println(future.get());
			Thread.sleep(2000);
			System.out.println(future.get());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}

class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		Thread.sleep(5000);
		return "hello";
	}
	
}

package com.hust.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

	static FutureTask<Integer> future=new FutureTask<Integer>(new Callable() {
		public Double call(){
			return Math.random();
		}
	});
	public static void main(String[] args) {
		  new Thread(future).start();
		 // future.run();
		 
		  ConcurrentHashMap<String, Integer> chm=new ConcurrentHashMap<>();
		 // chm.putIfAbsent(key, value)
	}
	
	
}

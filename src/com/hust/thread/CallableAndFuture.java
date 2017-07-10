package com.hust.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//��Ҫ
public class CallableAndFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<String> future = threadPool.submit(
			new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "hello";
			}
			
		});
		System.out.println("�ȴ����");
		try {
			System.out.println("�ȴ������"+future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExecutorService threadPool1 = Executors.newFixedThreadPool(10);
		//����֪���Ƕ��ٸ��߳���0  ��ȡ�̳߳ص�ִ�н��
		CompletionService<Integer> completionService=new ExecutorCompletionService<Integer>(threadPool1);
		for(int i=1;i<=10;i++){
			final int sequence=i;
			completionService.submit(new Callable<Integer>() {
	
				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));
					return sequence;
				}
			});
		}
		for(int i=0;i<10;i++){
			Future<Integer> take = completionService.take();
			System.out.println(take.get());
		}
	}
	

	
//	CompletionService<V> completionService=new ExecutorCompletionService<>(executor)
}

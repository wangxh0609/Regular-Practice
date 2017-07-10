package com.hust.threadbook;

import java.io.*;
import java.util.concurrent.*;

public class LogWriter {
	private final BlockingQueue<String> queue;
	private final ExecutorService executorService;
	//private final LoggerThread lt;
	private boolean isshutdown;
	private int reservations;
	private Writer writer;
	public LogWriter(Writer writer){
		this.queue=new LinkedBlockingDeque<String>(9);
		this.executorService=Executors.newFixedThreadPool(3);
		//this.lt=new LoggerThread(writer);
		this.writer=writer;
	}
	public void start(){
		for(int i=0;i<3;i++){
			Runnable runnable=new LoggerThread(writer);
			executorService.submit(runnable);
		}
		//lt.start();
	}
	public void stop() throws InterruptedException{
		try{
			executorService.shutdown();
			executorService.awaitTermination(50, TimeUnit.SECONDS);
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void log(String msg) throws InterruptedException{
			queue.put(msg);
	}
	
	
	 private class LoggerThread implements Runnable{
		private final PrintWriter writer;
		public LoggerThread(Writer writer){
			this.writer=(PrintWriter)writer;
		}
		public void run() {
			while(true){
				try {
					Thread.currentThread().sleep(500);
					
					System.out.println(queue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					//writer.close();
				}
			}
		}
	}
	
}

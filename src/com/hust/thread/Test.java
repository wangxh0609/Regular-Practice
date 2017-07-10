package com.hust.thread;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public abstract class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ThreadPoolExecutor
		Logger log=Logger.getAnonymousLogger();
		AtomicInteger ai=new  AtomicInteger();		
		
	}

}

final class SingleTon{
	private SingleTon(){
		
	}
	private static SingleTon instance;
	
	public static SingleTon getInstence(){
		
		if(instance==null){
			synchronized(SingleTon.class){
				if(instance==null){
					instance=new SingleTon();
				}
			}
		}		
		return instance;
	}
	
	
}

package com.hust.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteTest {
	private static ReentrantReadWriteLock rrwl=new ReentrantReadWriteLock();
	
	
	public static void main(String[] args){
		rrwl.readLock().lock();
		rrwl.readLock().unlock();
		
		rrwl.writeLock().lock();
		rrwl.writeLock().unlock();
		
	}

}

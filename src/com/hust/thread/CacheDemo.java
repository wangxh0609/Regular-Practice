package com.hust.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
	private Map<String,Object> cache=new HashMap<String,Object>();
	
	public static void main(String[] args){
		
	}
	private ReadWriteLock rwl=new ReentrantReadWriteLock();
	public  Object getData(String key){
		rwl.readLock().lock();
		Object obj=null;
		try{
			obj=cache.get(key);
			if(obj==null){
				rwl.readLock().unlock();
				rwl.writeLock().lock();	
				try{
					obj=cache.get(key);
					if(obj==null){
						obj="ss";//∑√Œ  ˝æ›ø‚
					}
				}
				finally{
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
				if(obj!=null){
					
					cache.put(key, obj);
				}
			}
		}finally{
			rwl.readLock().unlock();
		}
		return obj;
	}
}

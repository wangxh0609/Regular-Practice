package com.hust.ALTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;
import java.util.*;
public class BuyTicket {

	public static void main(String[] args) {
		while(!hasSellOut){
			Thread thread=new Thread(new Runnable() {
				
				@Override
				public void run() {
					double temp=Math.random();
					while(temp==0){
						temp=Math.random();
					}
					int my=(int)(temp*20);
					allocateToUser(Thread.currentThread().getName(),my*1000);
					
				}
			});
			thread.start();					
		}
		for(String str:map.keySet()){
			System.out.println(str+"¬Ú¡À"+map.get(str).buy+" ªπ £"+map.get(str).remain);
		}
	}
	static class MyInteger{
		int  remain;
		int  buy;
	}
	private static volatile boolean hasSellOut=false;
	private static Map<String,MyInteger> map=new Hashtable<String,MyInteger>();
	private static int remainCount=2000000;
	private static ReentrantReadWriteLock rrw=new ReentrantReadWriteLock();
	
	public static boolean allocateToUser(String useName,int buyCount){
		boolean hasAllo=false;				
			if(buyCount<1000||buyCount>20000){
				return false;
			}			
			try{
				rrw.readLock().lock();
				if(remainCount<1000){
					hasSellOut=true;					
					return false;
				}
				if(remainCount<buyCount){					
					return false;
				}				
			}catch(Exception e){
				hasAllo=false;
				rrw.readLock().unlock();
				return hasAllo;
			}finally{
				rrw.readLock().unlock();
			}
			try{
			rrw.writeLock().lock();
			remainCount=remainCount-buyCount;
			MyInteger entity=new MyInteger();
			entity.buy=buyCount;
			entity.remain=remainCount;
			map.put(useName, entity);
			hasAllo=true;					
		}
		catch(Exception e){
			hasAllo=false;		
		}finally{				
			rrw.writeLock().unlock();
		}		
		return hasAllo;		
	}
	

}

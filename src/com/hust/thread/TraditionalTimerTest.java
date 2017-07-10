package com.hust.thread;

import java.util.*;


public class TraditionalTimerTest {
	public static void main(String[] args){
		/*new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("bombing!");
				
			}
		}, 10000,3000);*/
		
	new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("bombing!");
//				new Timer().schedule(/*new TimerTask() {
//					
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						System.out.println("bombing!");
//						
//					}
//				}*/this.clone(), 2000);
			}
		},2000);
		
		while(true){
			System.out.println(new Date().getSeconds());
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
	}

}

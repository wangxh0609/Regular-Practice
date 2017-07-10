package com.hust.thread;

public class TranditionalThreadSynchronized {
	public static void main(String[] args){
		new TranditionalThreadSynchronized().init();
	}
	private void init(){
		final Outputer output=new Outputer();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					output.output("aaaaaaaaa");
				}
				
			}
		}).start();
		
new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					output.output("hhhhhhhhhh");
				}
				
			}
		}).start();
	}
	class Outputer{
		public void output(String names) {
			String xxx="";
			int len=names.length();
			synchronized(xxx) 						
			{
				for(int i=0;i<len;i++){
					System.out.print(names.charAt(i));
				}
				System.out.println();
			}
		}
	}
}

package com.hust.threadbook;

import java.io.PrintWriter;

public class Test {

	public static void main(String[] args) {
		LogWriter lw=new LogWriter(new PrintWriter(System.out));
		lw.start();
		int i=0;
		while(true){
			try {
				Thread.currentThread().sleep(1000);
				lw.log(""+(i++));
				//
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

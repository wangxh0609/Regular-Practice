package com.hust.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	public static void main(String[] args) {
		
		new Timer().schedule(new MyTimerTask1(), 1000);
	}
}

class MyTimerTask1 extends TimerTask {

	private static int count = 0;
	@Override
	public void run() {
		count = (count + 1) % 2;
		System.out.println("bombing!");
		new Timer().schedule(new MyTimerTask1(), 1000 + count * 1000);
	}
}

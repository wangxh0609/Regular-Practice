package com.hust.thread;

import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndConditionTest {
	Lock lock=new ReentrantLock();
	Condition condition=lock.newCondition();
	public static void main(String[] args){
		
	}
	public void test(){
		try {
			condition.await(); //�൱��object ��wait()
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		condition.signal();//�൱��Object ��notify()
		//condition.  ��������
		BlockingQueue<Integer> bq=new ArrayBlockingQueue<Integer>(8);
		//Statement
	}

}

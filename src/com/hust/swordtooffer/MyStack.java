package com.hust.swordtooffer;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack<T> implements IStack<T> {
	
	private Queue<T> queue1=new LinkedList<T>();
	private Queue<T> queue2=new LinkedList<T>();
	@Override
	public synchronized void push(T data) {
		if(queue1.isEmpty()&&queue2.isEmpty()){
			queue1.add(data);	
		}else if(queue1.isEmpty()){
			queue2.add(data);
		}else{
			queue1.add(data);
		}		
	}

	@Override
	public synchronized T pop() {
		T data=null;
		if(queue1.isEmpty()&&queue2.isEmpty()){
			return null;	
		}else if(queue1.isEmpty()){
			while(!queue2.isEmpty()){
				if(data!=null){
					queue1.add(data);
				}
				data=queue2.poll();
			}
		}else{
			while(!queue1.isEmpty()){
				if(data!=null){
					queue2.add(data);
				}
				data=queue1.poll();
			}
			
		}	
		return data;
	}
	
	
}

interface IStack<T>{
	public void push(T data);
	public T pop();
}

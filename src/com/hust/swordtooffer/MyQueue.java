package com.hust.swordtooffer;

import java.util.Stack;

public class MyQueue<T> implements IQueue<T> {

	public static void main(String[] args) {
	
	}
	private Stack<T> addStack=new Stack<T>();
	private Stack<T> deleteStack=new Stack<T>();
	@Override
	public void appendTail(T data) {
		synchronized(addStack){
			addStack.push(data);
		}
	}

	@Override
	public T deleteHead() {
		if(deleteStack==null&&addStack==null){
			return null;
		}
		else if(deleteStack==null){
			synchronized(addStack){
				while(!addStack.isEmpty()){
					T temp=addStack.pop();
					deleteStack.push(temp);
				}
			}
		}		
		return deleteStack.pop();
	}

}
interface IQueue<T>{
	public void appendTail(T data);
	public T deleteHead();
}

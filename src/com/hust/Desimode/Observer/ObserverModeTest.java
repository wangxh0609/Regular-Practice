package com.hust.Desimode.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverModeTest {
	public static void main(String[] args){
		IObserver observer=new ConObserver();
		IObserver observer1=new ConObserver();
		IObserver observer2=new ConObserver();
		Subject subject=new ConSubject();
		subject.add(observer);
		subject.add(observer1);
		subject.add(observer2);
		subject.update("Œ“πÿ±’¡À");
	}
}

abstract class Subject{
	public List<IObserver> observers=new ArrayList<IObserver>();
	public void add(IObserver observer){};
	public void remove(IObserver observer){};
	public void update(String str){};
	public void notifyObseverAll(){};
}

interface IObserver{
	public void update(String str);
}


class ConObserver implements IObserver{
	private String state;
	public void update(String str) {
		this.state=str;
		System.out.println("subject state is"+state);
	}	
}


class ConSubject extends Subject{	
	private String state;
	@Override
	public void add(IObserver observer) {
		if(observer!=null){
			observers.add(observer);
		}
	}


	@Override
	public void update(String str) {
		this.state=str;
		this.notifyObseverAll();
	}

	@Override
	public void notifyObseverAll() {
		for(IObserver observer:observers){
			observer.update(state);
		}
	}

	@Override
	public void remove(IObserver observer) {
		if(observer!=null){
			observers.remove(observer);
		}	
	}
	
}
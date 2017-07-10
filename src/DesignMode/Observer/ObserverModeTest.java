package DesignMode.Observer;
import java.util.*;
/*
 * 观察者模式实现
 * 一个状态的改变能通知到所有观察者做相应的变化
 */

public class ObserverModeTest  {
	
	public static void main(String[] args){
		Subject subject=new EntitySubject();
		MyObserver obverser=new EntityObserver();
		subject.attach(obverser);
		subject.change("哈哈");
		
		//看系统中如何实现观察者的
		
	}

}
class EntityObserver implements MyObserver {
	
	public String status;
	@Override
	public void update(String str) {
		// TODO Auto-generated method stub
		this.status=str;
		System.out.println("状态为"+status);
	}

}
interface Subject{
	void nodifyObservers(String str);
	void attach(MyObserver observer);
	void detach(MyObserver observer);
	void change(String newState);
}
interface MyObserver{
	void update(String str);
}
class EntitySubject implements Subject{
	List<MyObserver> list=new ArrayList<MyObserver>();
	public String state;
	
	@Override
	public void nodifyObservers(String str) {
		// TODO Auto-generated method stub
		for(MyObserver observer:list){
			observer.update(str);
		}
	}

	@Override
	public void attach(MyObserver observer) {
		list.add(observer);	
		
	}

	@Override
	public void detach(MyObserver observer) {
		// TODO Auto-generated method stub
		list.remove(observer);
	}
	 public void change(String newState){
	        state = newState;
	        System.out.println("主题状态为：" + state);
	        //状态发生改变，通知各个观察者
	        this.nodifyObservers(state);
	    }
}

package DesignMode.Observer;
import java.util.*;
/*
 * �۲���ģʽʵ��
 * һ��״̬�ĸı���֪ͨ�����й۲�������Ӧ�ı仯
 */

public class ObserverModeTest  {
	
	public static void main(String[] args){
		Subject subject=new EntitySubject();
		MyObserver obverser=new EntityObserver();
		subject.attach(obverser);
		subject.change("����");
		
		//��ϵͳ�����ʵ�ֹ۲��ߵ�
		
	}

}
class EntityObserver implements MyObserver {
	
	public String status;
	@Override
	public void update(String str) {
		// TODO Auto-generated method stub
		this.status=str;
		System.out.println("״̬Ϊ"+status);
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
	        System.out.println("����״̬Ϊ��" + state);
	        //״̬�����ı䣬֪ͨ�����۲���
	        this.nodifyObservers(state);
	    }
}

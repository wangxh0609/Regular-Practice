package DesignMode.Decorator;

public class RealDecorator extends BasicDecorator {

	public RealDecorator(BasicComponent component) {
		super(component);		
	}
	public void runfirst(){
		System.out.println("first");
	}
	public void runlast(){
		System.out.println("last");
	}
	public void run(){
		runfirst();
		super.run();
		runlast();
	}
}

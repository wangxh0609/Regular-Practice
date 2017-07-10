package DesignMode.Decorator;

public class OtherDecortor extends BasicDecorator {

	public OtherDecortor(BasicComponent component) {
		super(component);
	}
	public void runFirst(){
		System.out.println("other first");
	}
	public void run(){
		runFirst();
		super.run();
		runLast();		
	}
	public void runLast(){
		System.out.println("other last");
	}
}

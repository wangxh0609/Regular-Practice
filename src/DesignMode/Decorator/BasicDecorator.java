package DesignMode.Decorator;

public abstract class BasicDecorator implements BasicComponent{
	private BasicComponent component;
	public BasicDecorator(BasicComponent component){
		this.component=component;
	}
	public void run(){
		component.run();
	}
}

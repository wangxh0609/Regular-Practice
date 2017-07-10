package DesignMode.Decorator;

public class TestDecortor {
	public static void main(String[] args){
     	BasicComponent component=new RealComponent();//component基本功能
		BasicDecorator decortor=new RealDecorator(component);//A功能
		decortor.run();
		BasicDecorator decortorOther=new OtherDecortor(component);//B功能
		decortorOther.run();
		BasicDecorator twoDecortor=new OtherDecortor(decortor);//当用到两者的功能时只需要装配即可
		twoDecortor.run();
	}
}

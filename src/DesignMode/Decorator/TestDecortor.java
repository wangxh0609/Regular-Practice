package DesignMode.Decorator;

public class TestDecortor {
	public static void main(String[] args){
     	BasicComponent component=new RealComponent();//component��������
		BasicDecorator decortor=new RealDecorator(component);//A����
		decortor.run();
		BasicDecorator decortorOther=new OtherDecortor(component);//B����
		decortorOther.run();
		BasicDecorator twoDecortor=new OtherDecortor(decortor);//���õ����ߵĹ���ʱֻ��Ҫװ�伴��
		twoDecortor.run();
	}
}

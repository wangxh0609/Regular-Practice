package DesignMode.Adapter;

public class CurrentAdapter extends Current {
	public void user18V(){
		System.out.println("ʹ��������");
		this.user220V();
	}
}

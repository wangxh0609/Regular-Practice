package DesignMode.Adapter;

public class CurrentAdapter extends Current {
	public void user18V(){
		System.out.println("Ê¹ÓÃÊÊÅäÆ÷");
		this.user220V();
	}
}

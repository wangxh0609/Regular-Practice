package DesignMode.StaticProxy;

public class ProxySubject implements ISubject {
	private RealSubject realSubject;

	public void setRealSubject(RealSubject realSubject) {
		this.realSubject = realSubject;
	}

	@Override
	public void sailBook() {
		disCount();
		this.realSubject.sailBook();
		give();		
	}
	
	public void disCount(){
		System.out.println("´òÕÛ");
	}
	
	public void give(){
		System.out.println("´ú½ðÈ¯");
	}
}

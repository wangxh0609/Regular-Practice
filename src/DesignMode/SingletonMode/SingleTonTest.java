package DesignMode.SingletonMode;

public class SingleTonTest {
	private SingleTonTest(){
		
	}
	public SingleTonTest getInstance(){
		return InnerSingle.instance;
	}
	private static class InnerSingle{
		private static SingleTonTest instance=new SingleTonTest();
	}
}

package DesignMode.SingletonMode;

public class SingleTon {
	//private static final SingleTon singleton=new SingleTon();����ʽ ���߳̿ɱ�ֻ֤��һ��
	private static  SingleTon singleton=null;
	private static Object obj=new Object();
	private SingleTon(){
		
	}
	
	public static  SingleTon getInstance(){
		
		if(singleton==null){	
			synchronized(obj){
				if(singleton==null){
					singleton=new SingleTon();
				}
			}
		}
		return singleton;
	}

}

/*
 * ��õ�ʵ�ַ�ʽ
 */
class NiceSingleTon{
	private NiceSingleTon(){	
	}
	public static NiceSingleTon getInstance(){
		return InnerSingleTon.instance;
	}
	private static class InnerSingleTon{
		public static NiceSingleTon instance=new NiceSingleTon();
	}
}

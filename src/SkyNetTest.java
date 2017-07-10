

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SkyNetTest {
	public static void main(String[] args){
		BlockingQueue<String> queue=new ArrayBlockingQueue<String>(1);
		for(int i=0;i<4;i++){			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true){
						try {
							String log = queue.take();
							parseLog(log);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
			}).start();
		}
		
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		/*
		 * 模拟处理16行日志，下面的代码产生了16 个日志对象，当前代码需要巡行16 秒才能打印完
		 * 
		 * 修改程序代码。开四个线程让这16个对象在4秒钟打完
		 */
		for(int i=0;i<16;i++){//这行代码不能动
			final String log=""+(i+1);//这行代码不能动
			{
				//parseLog(log);
				try {
					queue.put(log);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

	private static void parseLog(String log) {
		System.out.println(log+":"+(System.currentTimeMillis()/1000));
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}

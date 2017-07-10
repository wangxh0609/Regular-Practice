

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
		 * ģ�⴦��16����־������Ĵ��������16 ����־���󣬵�ǰ������ҪѲ��16 ����ܴ�ӡ��
		 * 
		 * �޸ĳ�����롣���ĸ��߳�����16��������4���Ӵ���
		 */
		for(int i=0;i<16;i++){//���д��벻�ܶ�
			final String log=""+(i+1);//���д��벻�ܶ�
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

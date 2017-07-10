package com.hust.thread;

public class ThreadLocalTest {

	 //����һ��Integer�͵��̱߳��ر���
		public static final ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
			@Override
			protected Integer initialValue() {
				return 0;
			}
		};
		public static void main(String[] args) throws InterruptedException {
			Thread[] threads = new Thread[5];
			for (int j = 0; j < 5; j++) {		
	               threads[j] = new Thread(new Runnable() {
					@Override
					public void run() {
	                                        //��ȡ��ǰ�̵߳ı��ر�����Ȼ���ۼ�5��
						int num = local.get();
						for (int i = 0; i < 5; i++) {
							num++;
						}
	                                        //���������ۼӺ�ı��ر���
						local.set(num);
						System.out.println(Thread.currentThread().getName() + " : "+ local.get());

					}
				}, "Thread-" + j);
			}

			for (Thread thread : threads) {
				thread.start();
			}
		}

}

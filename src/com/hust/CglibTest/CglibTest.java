package com.hust.CglibTest;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibTest implements MethodInterceptor  {

    private Object target;	//Ŀ�����
	
	public CglibTest(Object target) {
		this.target = target;
	}
	
	/**
	 * ���ش������
	 */
	public Object getProxyInstance() {
		//����������
		Enhancer enhancer = new Enhancer();
		//���ø���
		enhancer.setSuperclass(target.getClass());
		//���ûص�����
		enhancer.setCallback(this);
		//�����������(����)
		return enhancer.create();
	}

	/**
	 * �ص�����
	 */
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getSimpleName()+"������󸽼ӵĲ�����ִ��ǰ");						
		//mehtod����Ŀ����󱻵��õķ�����
		System.out.println(method.getName());
		// ִ��Ŀ����󷽷�
		Object result = method.invoke(target, args);
		System.out.println(this.getClass().getSimpleName()+"������󸽼ӵĲ�����ִ�к�");
		return result;
	}
	
	public static void main(String[] args) {
		TestBean target = new TestBean();
		TestBean userDao = (TestBean) new CglibTest(target).getProxyInstance();		
		userDao.test();
	}

}

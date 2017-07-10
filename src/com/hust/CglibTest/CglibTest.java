package com.hust.CglibTest;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibTest implements MethodInterceptor  {

    private Object target;	//目标对象
	
	public CglibTest(Object target) {
		this.target = target;
	}
	
	/**
	 * 返回代理对象
	 */
	public Object getProxyInstance() {
		//创建工具类
		Enhancer enhancer = new Enhancer();
		//设置父类
		enhancer.setSuperclass(target.getClass());
		//设置回调方法
		enhancer.setCallback(this);
		//创建代理对象(子类)
		return enhancer.create();
	}

	/**
	 * 回调方法
	 */
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getSimpleName()+"代理对象附加的操作，执行前");						
		//mehtod代表目标对象被调用的方法名
		System.out.println(method.getName());
		// 执行目标对象方法
		Object result = method.invoke(target, args);
		System.out.println(this.getClass().getSimpleName()+"代理对象附加的操作，执行后");
		return result;
	}
	
	public static void main(String[] args) {
		TestBean target = new TestBean();
		TestBean userDao = (TestBean) new CglibTest(target).getProxyInstance();		
		userDao.test();
	}

}

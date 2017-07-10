package com.hust.CglibTest;

public class mainTeat {

	public static void main(String[] args) {
		IProxyTest test=new TestBean();
		IProxyTest userDao=(IProxyTest)(new DynamicProxy().getInstance(test));
		userDao.test();
	}

}

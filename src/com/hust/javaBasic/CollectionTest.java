package com.hust.javaBasic;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.IntStream.Builder;

public class CollectionTest {

	public static void main(String[] args) {
		Collection books=new HashSet();
		//ArrayList
		//LinkedList<E>
		Builder intStream=IntStream.builder();
		//HashSet
		Iterator iter=books.iterator();
		while(iter.hasNext()){
			iter.next();
		}
		//String
		B test=new B();
		//Object
		test.test();
	}

}
interface C{
	public void printTest();
	//�ӿ��п��Զ��徲̬����
	public static void testint(){
	
	}
}
class A implements C{
	public void test(){
		System.out.println("test");	
		printTest();
	}
	public void printTest(){
		System.out.println("A");
	}
	
}
class B extends A{
	public void printTest(){
		System.out.println("B");
	}
	
}

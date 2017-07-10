package DesignMode.ProtoType;

public class MainClass {

	public static void main(String[] args) {
		Person person1=new Person();
		person1.setName("liming");
		person1.setAge(20);
		person1.setGender("ÄÐ");
//		
//		Person person2=new Person();
//		person2.setName("liming");
//		person2.setAge(20);
//		person2.setGender("ÄÐ");
		
		Person person2=person1.clone();
		System.out.println(person1.getName());
		System.out.println(person1.getGender());
		System.out.println(person1.getAge());
		System.out.println(person2.getName());
		System.out.println(person2.getGender());
		System.out.println(person2.getAge());
		

	}

}

package DesignMode.ProtoType;

import java.util.ArrayList;
import java.util.List;

public class Person implements Cloneable{
	private String name;
	private int age;
	private String gender;
	private List<String> friends;
	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Person clone(){
		try {
			Person person= (Person) super.clone();
			List<String> friends=new ArrayList<>();
			for(String friend:this.getFriends()){
				friends.add(friend);
			}
			person.setFriends(friends);
			return person;
			
		} catch (CloneNotSupportedException e) {			
			e.printStackTrace();
			return null;
		}
	}

}

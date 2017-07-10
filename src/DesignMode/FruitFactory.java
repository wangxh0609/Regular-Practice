package DesignMode;

public class FruitFactory {
	public static Fruit getFruit(String type) throws InstantiationException, IllegalAccessException{
		if(type.equalsIgnoreCase("apple")){
			return Apple.class.newInstance();
		}else if(type.equalsIgnoreCase("banana")){
			return Banana.class.newInstance();
		}else if(type.equalsIgnoreCase("pear")){
			return Pear.class.newInstance();
		}		
		else{
			System.out.println("找不到对应的类！");
			return null;
		}
	}

}

package DesignMode;

public class MainClass {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		//简单工厂
		Fruit apple=FruitFactory.getFruit("apple");
		Fruit banana=FruitFactory.getFruit("banana");
		Fruit pear=FruitFactory.getFruit("pear");
		apple.get();
		banana.get();
		pear.get();
		
		//工厂方法  利用的事多态
		FruitFactoryMethod ff=new AppleFactory();
		Fruit apple1=ff.getFruit();
		
		apple1.get();
		FruitFactoryMethod bf=new BananaFactory();
		Fruit ba=bf.getFruit();
		ba.get();
		
		//abstractFactory
	}

}

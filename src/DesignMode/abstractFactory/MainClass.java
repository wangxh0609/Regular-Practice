package DesignMode.abstractFactory;

public class MainClass {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		FruitFactory ff=new NorthFruitFactory();
		Fruit apple=ff.getApple();
		apple.get();
		
		Fruit banana=ff.getBanana();
		banana.get();
		
		FruitFactory fff=new SouthFruitFactory();
		Fruit apple2=fff.getApple();
		apple2.get();
		Fruit banana2=fff.getBanana();
		banana2.get();
		
		
		FruitFactory ffff=new WenshiFruitFactory();
		Fruit apple3=ffff.getApple();
		apple3.get();
		Fruit banana3=ffff.getBanana();
		banana3.get();
	}

}

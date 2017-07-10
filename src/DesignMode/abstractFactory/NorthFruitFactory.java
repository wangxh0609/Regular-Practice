package DesignMode.abstractFactory;

public class NorthFruitFactory implements FruitFactory {

	@Override
	public Fruit getApple() {
		// TODO Auto-generated method stub
		return new NorthApple();
	}

	@Override
	public Fruit getBanana() {
		// TODO Auto-generated method stub
		return new NorthBanana();
	}

}

package DesignMode.abstractFactory;

public class WenshiFruitFactory implements FruitFactory {

	@Override
	public Fruit getApple() {
		// TODO Auto-generated method stub
		return new WenshiApple();
	}

	@Override
	public Fruit getBanana() {
		// TODO Auto-generated method stub
		return new WenshiBanana();
	}

}

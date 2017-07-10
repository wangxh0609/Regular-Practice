package DesignMode.abstractFactory;

public class SouthFruitFactory implements FruitFactory {

	@Override
	public Fruit getApple() {
		// TODO Auto-generated method stub
		return new SourthApple();
	}

	@Override
	public Fruit getBanana() {
		// TODO Auto-generated method stub
		return new SourthBanana();
	}

}

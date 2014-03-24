package tutorial.pat.behavior.decorator;

public class ChickenPizza implements Pizza {
	
	Pizza pizza;
	
	public ChickenPizza(Pizza _pizza) {
		this.pizza = _pizza;
	}

	@Override
	public String getDescription() {		
		return pizza.getDescription() + " and Chicken";
	}

	@Override
	public double getPirce() {		
		return pizza.getPirce() + 3.99;
	}

}

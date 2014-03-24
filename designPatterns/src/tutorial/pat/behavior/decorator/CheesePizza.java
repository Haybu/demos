package tutorial.pat.behavior.decorator;

public class CheesePizza implements Pizza {
	
	Pizza pizza;
	
	public CheesePizza(Pizza _pizza) {
		this.pizza = _pizza;
	}

	@Override
	public String getDescription() {		
		return pizza.getDescription() + " and Cheese";
	}

	@Override
	public double getPirce() {		
		return pizza.getPirce() + 2.80;
	}

		
}

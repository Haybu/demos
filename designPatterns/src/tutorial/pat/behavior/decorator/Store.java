package tutorial.pat.behavior.decorator;

public class Store {
	
	public static void main (String[] args) {
		Pizza order = new ChickenPizza(new CheesePizza(new PlainPizza()));
		
		System.out.println("order is description " + order.getDescription());
		System.out.println("order price is " + order.getPirce());
	}

}

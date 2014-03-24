package tutorial.pat.behavior.decorator;

public class PlainPizza implements Pizza {

	@Override
	public String getDescription() {
		return "Plain Pizza";
	}

	@Override
	public double getPirce() {		
		return 5.99;
	}

}

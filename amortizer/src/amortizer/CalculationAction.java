package amortizer;
/**
 * A set of action to take during the monthly payment computations.
 * 
 * @author Haytham Mohamed
 */


public enum CalculationAction {
    
        MONTHLY_PAYMENT("monthlyPayment")
        , BALANCE("balance")
        , PRINCIPLE_PAYMENT("principlePayment")
        , INTEREST_PAYMENT("interestPayment")
        , START("start")
        , DONE("done");
 
        private String action;
 
	private CalculationAction(String s) {
		action = s;
	}
 
	public String getActionCode() {
		return action;
	}
}

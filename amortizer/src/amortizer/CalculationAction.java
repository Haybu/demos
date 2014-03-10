/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amortizer;

/**
 *
 * @author hmohamed
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

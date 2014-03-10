/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amortizer;

import java.util.ArrayList;

/**
 *
 * @author hmohamed
 */
public class EndCalculator extends AbstractChain {
    
    @Override
     public void calculate(Loan loan) 
    {       
        if(loan.getCalculationWanted() == CalculationAction.DONE) {
            // add a payment
            loan.addAmotizationPayment();
            // start over
            loan.setCalculationWanted(CalculationAction.START);            
        } else {
            getNextChain().calculate(loan);    
        }
    }
    
}

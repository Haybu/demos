/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amortizer;

import java.math.BigDecimal;

/**
 *
 * @author hmohamed
 */
public class PrinciplePaymentCalculator extends AbstractChain {
    
    @Override
     public void calculate(Loan loan) 
    {              
        if (loan.getCalculationWanted() == CalculationAction.PRINCIPLE_PAYMENT) 
        {             
            BigDecimal payment = 
              loan.getMonthlyPayment().subtract( 
                    loan.getInterestPayment());
            
            loan.setPrinciplePayment(payment);                        
            
            loan.setCalculationWanted(CalculationAction.BALANCE);
            
        } else {
            getNextChain().calculate(loan);        
        }
    }
}

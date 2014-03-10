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
public class BalanceCalculator extends AbstractChain {
    
    @Override
     public void calculate(Loan loan) 
    {              
        if (loan.getCalculationWanted() == CalculationAction.BALANCE) {                                      
            
            BigDecimal balance = 
              loan.getBalance().subtract(loan.getPrinciplePayment());
                             
            loan.setBalance((balance.doubleValue() > 0)? balance 
                    : new BigDecimal(0));
                                   
            loan.setCalculationWanted(CalculationAction.DONE);
            
        } else {
            getNextChain().calculate(loan);        
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
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
public class InterestPaymentCalculator extends AbstractChain {

     @Override
     public void calculate(Loan loan) 
    {              
        if (loan.getCalculationWanted() == CalculationAction.INTEREST_PAYMENT)
        {                           
            double monthlyInterest = loan.getAnualPercentageRage() / 12;
            
            double payment = 
              loan.getBalance().doubleValue() * monthlyInterest ;
            
            loan.setInterestPayment(new BigDecimal(payment));
            
            BigDecimal total = 
                 loan.getTotalInterestPayments().add(loan.getInterestPayment());
            
            loan.setTotalInterestPayments(total);
            
            loan.setCalculationWanted(CalculationAction.PRINCIPLE_PAYMENT);
            
        } else {
            getNextChain().calculate(loan);        
        }
    }
    
}

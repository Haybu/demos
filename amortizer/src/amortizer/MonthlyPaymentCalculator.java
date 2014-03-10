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
public class MonthlyPaymentCalculator extends AbstractChain {
    
    @Override
    public void calculate(Loan loan) 
    {              
        if (loan.getCalculationWanted() == CalculationAction.MONTHLY_PAYMENT) 
        {  
           // increment the payment number
           loan.setPaymentNumber(loan.getPaymentNumber() + 1);
           if(loan.getMonthlyPayment().doubleValue() == 0) {// do it just once
                double monthlyInterest = 
                        loan.getAnualPercentageRage() / 12;

                double payment = 
                  loan.getPrinciple().doubleValue() * 
                    (monthlyInterest / (1 - Math.pow((1/(1 + monthlyInterest))
                            , (loan.getTermYear() * 12)))) ;

                loan.setMonthlyPayment(new BigDecimal(payment));
           }
           
           BigDecimal total = 
                   loan.getTotalPayments().add(loan.getMonthlyPayment());
           
           loan.setTotalPayments(total);
           
           loan.setCalculationWanted(CalculationAction.INTEREST_PAYMENT);
            
        } else {
            getNextChain().calculate(loan);        
        }
    }
    
}

package amortizer;
/**
 * Principle Payment calculator component. It computes the monthly payment amount
 * towards the loan principle. After it is done, it delegates to
 * the next component in the calculation cycle.
 * 
 * Computation formula: 
 *      Principle Payment = Monthly Payment amount - Interest Payment amount
 * 
 * @author Haytham Mohamed
 */

import java.math.BigDecimal;

public class PrinciplePaymentCalculator extends AbstractChain {
    
    @Override
     public void calculate(Loan loan) 
    {              
        if (loan.getCalculationWanted() == CalculationAction.PRINCIPLE_PAYMENT) 
        {          
            // priciple payment made
            BigDecimal payment = 
              loan.getMonthlyPayment().subtract( 
                    loan.getInterestPayment());
            
            // keep the principle payment to help with evaluating the balance next
            loan.setPrinciplePayment(payment);                        
            
            // balance component to kick in next in order to evaluate the balance 
            loan.setCalculationWanted(CalculationAction.BALANCE);
            
        } else {
            getNextChain().calculate(loan);        
        }
    }
}

package amortizer;

import java.math.BigDecimal;

/**
 * A last component in the chain to represent a terminating element. it helps 
 * to perform post-calculation tasks, such as assembling the amortization payment 
 * result after each month's payment calculations.
 * 
 * @author Haytham Mohamed
 */

public class EndCalculator extends AbstractChain {
    
    @Override
     public void calculate(Loan loan) 
    {       
        if(loan.getCalculationWanted() == CalculationAction.DONE) {                        
            // add a month's payment information into the amortization list
            loan.addAmotizationPayment();
            // start over
            loan.setCalculationWanted(CalculationAction.START);            
        } else {
            getNextChain().calculate(loan);    
        }
    }
    
}

package amortizer;
/**
 * Balance calculator component. It computes the monthly balance amount after
 * every month's payment. After it is done, it delegates to
 * the next component in the calculation cycle.
 * 
 * Computation formula: 
 *      Balance amount = Previous balance amount - principle payment
 * 
 * @author Haytham Mohamed
 */

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
            
            // balance amount
            BigDecimal balance = 
              loan.getBalance().subtract(loan.getPrinciplePayment());
                        
            // keep the balance on this computation cycle
            loan.setBalance((balance.doubleValue() > 0)? balance 
                    : new BigDecimal(0));
                                   
            // last component in the change it the one the assembles a payment
            // information into the amortization list.
            loan.setCalculationWanted(CalculationAction.DONE);
            
        } else {
            getNextChain().calculate(loan);        
        }
    }
    
}

package amortizer;
/**
 * Monthly interest Payment calculator component. It computes the monthly payment 
 * amount towards the interest.
 * 
 * formula used for computation: 
 *      Monthly interest paid = Monthly Interest Rate X Current Balance
 * 
 * Monthly Interest Rate = APR / 12
 * Where APR is the annual percentage rate in decimal point.
 * 
 * @author Haytham Mohamed
 */

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
            // montly interest 
            double monthlyInterest = 
                        loan.getAnnualPercentageRage() / 12 ;
            
            // interest paid
            double payment = 
              loan.getBalance().doubleValue() * monthlyInterest ;
            
            loan.setInterestPayment(new BigDecimal(payment));
            
            // total interest payments made so far
            BigDecimal total = 
                 loan.getTotalInterestPayments().add(loan.getInterestPayment());
            
            loan.setTotalInterestPayments(total);
            
            // next to evaluate the payment made twoards the loan prinicple
            loan.setCalculationWanted(CalculationAction.PRINCIPLE_PAYMENT);
            
        } else {
            getNextChain().calculate(loan);        
        }
    }
    
}

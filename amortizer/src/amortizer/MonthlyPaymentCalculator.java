package amortizer;
/**
 * Monthly Payment calculator component. It computes the monthly payment amount.
 * As the monthly payment is constant during the loan period, This component 
 * evaluates the monthly payment only once. After it is done, it delegates to
 * the next component in the calculation cycle.
 * 
 * @author Haytham Mohamed
 */

import java.math.BigDecimal;

public class MonthlyPaymentCalculator extends AbstractChain {
    
    @Override
    public void calculate(Loan loan) 
    {              
        if (loan.getCalculationWanted() == CalculationAction.MONTHLY_PAYMENT) 
        {  
           // increment the payment number
           loan.setPaymentNumber(loan.getPaymentNumber() + 1);
           
           // only perform the monthly payment calcuation once
           if(loan.getMonthlyPayment().doubleValue() == 0) {
                              
                double monthlyInterest = (loan.getAnnualPercentageRage() != 0)?
                        loan.getAnnualPercentageRage() / 12 : 0;

                double payment = 0;
                
                if (monthlyInterest > 0) {
                
                  payment =  loan.getPrinciple().doubleValue() * 
                    (monthlyInterest / (1 - Math.pow((1/(1 + monthlyInterest))
                            , (loan.getTermYear() * 12)))) ;
                } else {
                  payment = 
                          loan.getPrinciple().doubleValue() 
                          / (loan.getTermYear() * 12);
                }

                loan.setMonthlyPayment(new BigDecimal(payment));
           }
           
           // set the total amount paid so far
           BigDecimal total = 
                   loan.getTotalPayments().add(loan.getMonthlyPayment());
           
           loan.setTotalPayments(total);
           
           // next component to evaluate the interest paid
           loan.setCalculationWanted(CalculationAction.INTEREST_PAYMENT);
            
        } else {
            getNextChain().calculate(loan);        
        }
    }
    
}

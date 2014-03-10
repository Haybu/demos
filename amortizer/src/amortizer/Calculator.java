/**
 * Amortization is paying off of debt in regular installments over 
 * a period of time.
 * 
 * To calculate the payments over a period of time, the calculator evaluates
 * the constant monthly payments based on the loan amount, the annual interest
 * rate and the term of the loan.
 * 
 * To utilize this calculator you need to instantiate the calculator with the 
 * following inputs:
 * <ul>
 * <li>The loan principle amount
 * <li>The annual interest rate in decimal point
 * <li>The term of the loan in number of years
 * <p>
 * This calculator uses the chain of command design pattern. The calculator is 
 * divided into sub calculation components: 
 * <ul>
 * <li>Starting up and configuration component
 * <li>Monthly payment calculator component
 * <li>Interest payment calculator component
 * <li>Principle payment calculator component
 * <li>Balance calculator component
 * <li>Ending component to assemble the amortization payments list
 * </ul>
 * The calculator components are chained together to perform the evaluation of 
 * payments in cycles. Each cycle start with the starter component for 
 * initialization, then the monthly payment component to calculate the monthly 
 * payment, followed by the interest component to evaluate the amount to pay 
 * towards the interest, then the principle component to determine the amount
 * paid towards the loan principle, then the balance is evaluated by the balance
 * component, and at the end of the cycle the last component terminate
 * a calculation cycle by injecting a payment instance into the amortization 
 * list.
 * 
 * The monthly calculation cycles of payments are performed as many as 
 * the number month of loan term.
 * </p>
 * <p>
 * Usage:
 *  Instantiate a calculator instance:
 *        Calculator calculator = new Calculator();
 *  obtain the amortization payment schedules as a list of payment objects:
 *     List<Payment> payments = 
               calculator.getPayments(principle, interest, termYears);
 *  Total monthly payments and total paid interest amounts are accessible 
 * via the two instance variables: totalPayments and totalInterestPayments
 * <p>
 * 
 * @author      Haytham Mohamed
 * @version     1.0
 */

package amortizer;

import java.math.BigDecimal;
import java.util.List;


public class Calculator {
    
    // To keep the total payments made
    private BigDecimal totalPayments;
    
    // To keep the total payments towards the interest
    private BigDecimal totalInterestPayments;  

    public BigDecimal getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(BigDecimal totalPayments) {
        this.totalPayments = totalPayments;
    }

    public BigDecimal getTotalInterestPayments() {
        return totalInterestPayments;
    }

    public void setTotalInterestPayments(BigDecimal totalInterestPayments) {
        this.totalInterestPayments = totalInterestPayments;
    }
    
    public Calculator () {}
    
    /**
     * This Method returns a list of payments during the course of the loan
     * term. Each monthly payment object has information about the number of 
     * payment, the payment amount, the interest payment and the balance.
     * 
     * @param principle is the loan principle amount
     * @param apr is the annual percentage rate in decimal point
     * @param termInYears is the loan term in number of years
     * @return a list payments information during the loan term
     */
     public List<Payment> getPayments(double principle, double apr
             , int termInYears) {
         
        // a loan object to keep all evaluated loan values during computation
        Loan loan = new Loan();
        loan.setAnualPercentageRage(apr);
        loan.setPrinciple(new BigDecimal(principle));
        loan.setTermYear(termInYears); 
        loan.setCalculationWanted(CalculationAction.START);

        // a starter calculator 
        StartCalculation starter = new StartCalculation();
        // a monthly payment calculator
        MonthlyPaymentCalculator montlyCalc = new MonthlyPaymentCalculator();
        // a monthly interest payment calculator
        InterestPaymentCalculator interestCalc = new InterestPaymentCalculator();
         // a monthly principle payment calculator
        PrinciplePaymentCalculator principleCacl = new PrinciplePaymentCalculator();
         // a monthly balance amount calculator
        BalanceCalculator balanceCalc = new BalanceCalculator();
        // the end component to add a payment information into the amortization list
        EndCalculator endCalc = new EndCalculator();
        
        /**
         * chaining the calculators together. The chain represents a month payment
         * evaluation. Each month's  computation is performed in a sequence as follows:
         * starter -> monthly payment calculator -> interest payment calculator ->
         * principle payment calculator -> balance calculator -> end component.
         * 
         */
        
        // starter to set monthly calculato as its next component in the chain
        starter.setNextChain(montlyCalc);
        // montly calculator to set interest payment calculato as its next 
        // component in the chain
        montlyCalc.setNextChain(interestCalc);
        // intest calculator to set the principle calculator as its next
        // component in the chain
        interestCalc.setNextChain(principleCacl);
        // principle payment calculator to set the balance calculator as its
        // next component in the change
        principleCacl.setNextChain(balanceCalc);
        // balance calculator to set the terminating component as its next 
        // component in the change
        balanceCalc.setNextChain(endCalc);
        // closing the loop of back to the starter component
        endCalc.setNextChain(starter);
        
        performCalculation(loan, starter); 
        this.setTotalInterestPayments(loan.getTotalInterestPayments().setScale(2, BigDecimal.ROUND_CEILING));
        this.setTotalPayments(loan.getTotalPayments().setScale(2, BigDecimal.ROUND_CEILING));
        
        return loan.getAmortization();
     }
     
     private void performCalculation(Loan loan, Chain chain) {
         if (loan.getPaymentNumber() > (loan.getTermYear() * 12) - 1) {
             return;
         } else {
            // peform a monthly payment calculation from START to END
            while (loan.getCalculationWanted() != CalculationAction.DONE) {
                chain.calculate(loan);                              
            } 
            // perform the last cycle to assempl the amorization
            chain.calculate(loan);
            // cycle back
            performCalculation(loan, chain);
         }
     }
    
}

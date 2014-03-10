/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amortizer;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author hmohamed
 */
public class Calculator {
    
    private BigDecimal totalPayments;
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
    
     public List<Payment> getPayments(double principle, double apr, int termInYears) {
        Loan loan = new Loan();
        loan.setAnualPercentageRage(apr);
        loan.setPrinciple(new BigDecimal(principle));
        loan.setTermYear(termInYears); 
        loan.setCalculationWanted(CalculationAction.START);

        StartCalculation starter = new StartCalculation();
        MonthlyPaymentCalculator montlyCalc = new MonthlyPaymentCalculator();
        InterestPaymentCalculator interestCalc = new InterestPaymentCalculator();
        PrinciplePaymentCalculator principleCacl = new PrinciplePaymentCalculator();
        BalanceCalculator balanceCalc = new BalanceCalculator();
        EndCalculator endCalc = new EndCalculator();
        
        starter.setNextChain(montlyCalc);
        montlyCalc.setNextChain(interestCalc);
        interestCalc.setNextChain(principleCacl);
        principleCacl.setNextChain(balanceCalc);
        balanceCalc.setNextChain(endCalc);
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

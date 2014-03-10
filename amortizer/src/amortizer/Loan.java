/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amortizer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hmohamed
 */
public class Loan extends Payment{
    
    private BigDecimal principle;  
    private int termYear;     
    private double anualPercentageRage;    
    private CalculationAction calculationWanted;
    
    List<Payment> amortization;
    
    public Loan() {  
        super();
        principle = new BigDecimal(0d);
    }
     
    public void addAmotizationPayment() {
        Payment payment = new Payment();
        payment.setPaymentNumber(this.getPaymentNumber());
        payment.setBalance(this.getBalance().setScale(2, BigDecimal.ROUND_CEILING));
        payment.setMonthlyPayment(this.getMonthlyPayment().setScale(2, BigDecimal.ROUND_CEILING));
        payment.setInterestPayment(this.getInterestPayment().setScale(2, BigDecimal.ROUND_CEILING));
        payment.setTotalInterestPayments(this.getTotalInterestPayments().setScale(2, BigDecimal.ROUND_CEILING));
        payment.setTotalPayments(this.getTotalPayments().setScale(2, BigDecimal.ROUND_CEILING));
        amortization.add(payment);
    } 

    public List<Payment> getAmortization() {
        return amortization;
    }

    public void setAmortization(List<Payment> amortization) {
        this.amortization = amortization;
    }
       
    public CalculationAction getCalculationWanted() {
        return calculationWanted;
    }

    public void setCalculationWanted(CalculationAction calculationWanted) {
        this.calculationWanted = calculationWanted;
    }         

    public int getTermYear() {
        return termYear;
    }

    public void setTermYear(int term) {
        this.termYear = term;
    }

    public BigDecimal getPrinciple() {
        return principle;
    }

    public void setPrinciple(BigDecimal principle) {
        this.principle = principle;
        setBalance(this.principle);
    }    

    public double getAnualPercentageRage() {
        return anualPercentageRage;
    }

    public void setAnualPercentageRage(double interest) {
        this.anualPercentageRage = interest;
    }

}

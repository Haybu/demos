package amortizer;
/**
 * A POJO (model) component to represent the initial loan information: principle,
 * APR, and term of the loan.
 * 
 * It also keep a state of the calculation actions over the cycle of the monthly 
 * computation.
 * 
 * @author Haytham Mohamed
 */

import java.math.BigDecimal;
import java.util.List;

public class Loan extends Payment{
    
    // loan principle amount
    private BigDecimal principle;  
    // loan term in years
    private float termYear;   
    // Annual Percentage Rate, in decimal point (example: 0.05)
    private double annualPercentageRage;  
    // Action taken in each cycle's step    
    private CalculationAction calculationWanted;
    
    // a list to keep the scheduled payment information during the loan term
    List<Payment> amortization;
    
    public Loan() {  
        super();
        principle = new BigDecimal(0d);
        termYear = 0;
        annualPercentageRage = 0d;
    }
     
    public void addAmotizationPayment() {
        Payment payment = new Payment();
        payment.setPaymentNumber(this.getPaymentNumber());
        payment.setBalance(this.getBalance().setScale(2, BigDecimal.ROUND_CEILING));
        payment.setMonthlyPayment(this.getMonthlyPayment().setScale(2, BigDecimal.ROUND_CEILING));
        payment.setInterestPayment(this.getInterestPayment().setScale(2, BigDecimal.ROUND_CEILING));
        payment.setTotalInterestPayments(this.getTotalInterestPayments().setScale(2, BigDecimal.ROUND_CEILING));
        payment.setTotalPayments(this.getTotalPayments().setScale(2, BigDecimal.ROUND_CEILING));
        
        // if this is the last payment, and there is a remaining balance 
        // add it to the monthly payment, and total payments and set the balance
        // to zero
        if (payment.getPaymentNumber() == this.getNumberOfMonths()) {
            payment.setMonthlyPayment(
                    payment.getMonthlyPayment().add(payment.getBalance()));
            payment.setTotalPayments(
                    payment.getTotalPayments().add(payment.getBalance()));
            payment.setBalance(BigDecimal.ZERO);
        }
                        
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

    public float getTermYear() {
        return termYear;
    }

    public void setTermYear(float term) {
        this.termYear = term;
    }

    public BigDecimal getPrinciple() {
        return principle;
    }

    public void setPrinciple(BigDecimal principle) {
        this.principle = principle;
        setBalance(this.principle);
    }    

    public double getAnnualPercentageRage() {
        return annualPercentageRage;
    }

    public void setAnnualPercentageRage(double interest) {
        this.annualPercentageRage = interest;
    }
    
    public int getNumberOfMonths() {
       return (int)Math.ceil(this.getTermYear() * 12);      
    }

}

package amortizer;
/**
 * A POJO (model) component to represent the loan monthly payment calculation.
 * 
 * @author Haytham Mohamed
 */

import java.math.BigDecimal;

/**
 *
 * @author hmohamed
 */
public class Payment {
    
    // payment number
    private int paymentNumber;
    // monthly payment amount. constant over the period of the loan
    private BigDecimal monthlyPayment;
    // payment twoards interest
    private BigDecimal interestPayment;
    // a monhtly loan balance amount
    private BigDecimal balance;  
    // payment towards the principle amount of the loan
    private BigDecimal principlePayment; 
    // total amount of payments made
    private BigDecimal totalPayments;
    // total payments made towards the interest
    private BigDecimal totalInterestPayments;
          
    
    public Payment() {
        monthlyPayment = new BigDecimal(0d);
        interestPayment = new BigDecimal(0d);
        balance = new BigDecimal(0d);
        principlePayment = new BigDecimal(0d); 
        totalPayments = new BigDecimal(0d);
        totalInterestPayments = new BigDecimal(0d);
    }
    
    public BigDecimal getPrinciplePayment() {
        return principlePayment;
    }

    public void setPrinciplePayment(BigDecimal principlePayment) {
        this.principlePayment = principlePayment;
    }

    public int getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(int paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

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
  
     public BigDecimal getInterestPayment() {
        return interestPayment;
    }

    public void setInterestPayment(BigDecimal interestPayment) {
        this.interestPayment = interestPayment;
    }
    
    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }   

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }           
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amortizer;

import java.math.BigDecimal;

/**
 *
 * @author hmohamed
 */
public class Payment {
    
    private int paymentNumber;
    private BigDecimal monthlyPayment;
    private BigDecimal interestPayment;
    private BigDecimal balance;  
    private BigDecimal principlePayment;  
    private BigDecimal totalPayments;
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

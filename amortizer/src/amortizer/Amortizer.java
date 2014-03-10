/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amortizer;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hmohamed
 */
public class Amortizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {              
       //Console console = System.console();
      
       System.out.println("Welcome to Paypal Amortization Calculator Demo.");
       System.out.println("This application is for demo purpose only.");
       System.out.println("For any help please contace Haytham Mohamed 773.454.3447");
       System.out.println("---------------------------------------------------------");
       System.out.println();

       // prompt for input
       Scanner scanner = new Scanner (System.in);
       System.out.print("Please Enter the loan amount: ");  
       String principle_str = scanner.next();
       System.out.println();
       System.out.print("Please Enter the annual percentage rate in decimal point (example: 0.05) : ");
       String apr_str = scanner.next();
       System.out.println();
       System.out.print("Please Enter the loan term in years: ");
       String termYears_str = scanner.next();
       
       // Loan pricinple amount
       double principle = 
               (principle_str != null)? Double.parseDouble(principle_str): 0d;
      
       // APR in decimal point
       double interest = 
               (apr_str != null)? Double.parseDouble(apr_str): 0d;
       
       // Loan term in years
       int termYears = 
               (termYears_str != null)? Integer.parseInt(termYears_str): 0;  // years
       
       Calculator calculator = new Calculator();
       
       List<Payment> payments = 
               calculator.getPayments(principle, interest, termYears);
       
        System.out.printf("\n%-20.20s %-20.20s %-22.20s %-20.20s"
                , "Payment#", "Monthly_Payment", "Interest_Paid", "Balance");
        System.out.printf("\n%-20.20s %-20.20s %-22.20s %-20.20s"
                , "--------", "---------------", "-------------", "-------");
       for (Payment payment: payments) {
           System.out.printf("\n%-20d $%,-20.2f $%,-20.2f $%,-9.2f",
                   payment.getPaymentNumber(),
                   payment.getMonthlyPayment(),
                   payment.getInterestPayment(),
                   payment.getBalance() );                        
       }
        System.out.printf("\n%-20.20s %-20.20s %-22.20s %-20.20s"
                , "--------", "---------------", "-------------", "-------");
        System.out.printf("\n%-20.20s $%-20.2f $%-22.2f"
                , "Total", calculator.getTotalPayments() 
                , calculator.getTotalInterestPayments());
       System.out.println();    
    }
    
}

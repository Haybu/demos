package amortizer;
/*
This is a stand along program and antry point to run the Amortizer demo 
application

The application display a list of payments information (amortization scheduled 
payments) of a loan amount in a course of a loan period.

When runs, the application prompts a user for a loan amount, the annual interest 
rate (in decimal format) and the number of the years for the loan term.

The program then lists a tabulated payment information of the number of payment,
the monthly payment, payment towards the interest and the balance amount for 
every month in the loan's period. At the end of the table, the program list
the total amounts of all payments made, and the total paid toward the interest.

@auther Haythm Mohamed (773.454.3447)
@version 1.0
*/

import java.util.List;
import java.util.Scanner;

public class Amortizer {

    /**
     * @param args the command line arguments
     * 
     * This program does not expect command line arguments, instead it prompts
     * for input data.
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
       
        // loan principle amount
       System.out.print("Please Enter the loan amount: ");  
       String principle_str = scanner.next();
       System.out.println();
       
       while (principle_str == null) {
           System.out.println("No input for loan amount is given. Please run the application again");
           System.exit(0);
       }
       
       // interest rate in decimal point
       System.out.print("Please Enter the annual percentage rate in decimal point (example: 0.05) : ");
       String apr_str = scanner.next();
       System.out.println();
       
       while (apr_str == null) {
           System.out.println("No input for loan annua percentage rate is given."
                     +" Please run the application again");
           System.exit(0);
       }
       
       // loan term in number of years
       System.out.print("Please Enter the loan term in years: ");
       String termYears_str = scanner.next();
       
        while (termYears_str == null) {
           System.out.println("No input for loan term in years is given."
                     + " Please run the application again");
           System.exit(0);
       }
        
       System.out.println();
       
       // Loan pricinple amount
       double principle = 0d;
       
       try {
               principle = 
                       (principle_str != null)? 
                       Double.parseDouble(principle_str): 0d;
               
               if (principle <= 0) {
                   System.out.println("loan amount should be greater than zero");
                   System.exit(0);
               }
       } catch (NumberFormatException ex) {
           System.out.println("Please enter a valid loan principle amount.");
           System.exit(0);
       }
      
       // APR in decimal point
       double interest = 0d;
       
       try {
            interest = (apr_str != null)? Double.parseDouble(apr_str): 0d;
            
             if (interest > 1 || interest < 0) {
                   System.out.println("loan annual percentage rate should be "
                           + "in a positive decimal number format");
                   System.exit(0);
               }
        } catch (NumberFormatException ex) {
           System.out.println("Please enter a valid annual percentage rate.");
           System.exit(0);
        }    
       
       // Loan term in years
       int termYears = 0;         // in years
       
       try {
            termYears = (termYears_str != null)? 
                    Integer.parseInt(termYears_str): 0; 
            
            if (termYears <= 0) {
                System.out.println("Loan term should a zero or a (postive) number of years");
                System.exit(0);
            }
       } catch (NumberFormatException ex) {
           System.out.println("Please enter a valid loan term in years.");
           System.exit(0);
       }     
       
       // the calculator object that performs the computation during the 
       // loan period. It uses a chain of computation components.
       Calculator calculator = new Calculator();
       
       // amortization, scheduled payments for each month
       List<Payment> payments = 
               calculator.getPayments(principle, interest, termYears);
       
       // tabulated report for each month's payment
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
       
       // totals
        System.out.printf("\n%-20.20s %-20.20s %-22.20s %-20.20s"
                , "--------", "---------------", "-------------", "-------");
        System.out.printf("\n%-20.20s $%-20.2f $%-22.2f"
                , "Total", calculator.getTotalPayments() 
                , calculator.getTotalInterestPayments());
       System.out.println();    
    }
    
}

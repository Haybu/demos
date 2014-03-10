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

public class Amortizer {

    /**
     * @param args the command line arguments
     * 
     * This program does not expect command line arguments, instead it prompts
     * for input data.
     */
    public static void main(String[] args) 
    {              
       Loan loan = null;
       try {
            Prompt prompt = new Prompt();
            loan = prompt.promptForLoanInformation();
       } catch (LoanEntryException ex) {
           System.out.println(ex.getMessage());
           System.exit(1);
       }
       
       if (loan != null) {
            // the calculator object that performs the computation during the 
            // loan period. It uses a chain of computation components.
            Calculator calculator = new Calculator();

            // amortization, scheduled payments for each month
            List<Payment> payments = 
                    calculator.getPayments(loan.getPrinciple().doubleValue()
                            , loan.getAnnualPercentageRage()
                            , loan.getTermYear());
            
           if (payments != null && payments.size() > 0) {
               AmortizerPrinter.print(payments, calculator.getTotalPayments()
                       , calculator.getTotalInterestPayments());
           }
       }

    }
    
}

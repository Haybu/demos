package amortizer;

/**
 * A helper class to prompt application users for loan inputs.
 * The application prompts a user to enter the following:
 * 1- Loan Amount
 * 2- Annual percentage rate (in percentage format with or without % sign)
 * 3- The loan period in number of years
 * 
 * @author Haytham Mohamed
 */

import java.math.BigDecimal;
import java.util.Scanner;


public class Prompt {
    // prompt for input
    private static Scanner scanner = new Scanner (System.in);
    
    public Prompt() { }
    
    /**
     * This method prompt users for the loan information
     * @return the loan object with loan principle, APR and term
     */
    public Loan promptForLoanInformation () throws LoanEntryException {
        Loan loan = new Loan();
        // show a welcome message
        showWelcomeMessage();
        // set the loan principle amount
        setPrincipleAmount(loan);
        // set the APR
        setAPR(loan);
        // set the loan term in years
        setLoanTermInYears(loan);
        
        return loan;
    }
    
    private String readPrincipleAmount() throws LoanEntryException {
       String principle_str = prompt("Please Enter the loan amount: ");
       
       if (principle_str == null) {
           throw new LoanEntryException("No input for loan amount is given. "
                   + "Please run the application again");
       }
       
       return principle_str;
    }
    
    private void setPrincipleAmount(Loan loan) throws LoanEntryException {
        // Loan pricinple amount
       String principle_str = readPrincipleAmount();
       
       double principle = 0d;
       
       try {
               principle = 
                       (principle_str != null)? 
                       Double.parseDouble(principle_str): 0d;
               
               if (principle <= 0) {
                   throw new LoanEntryException (
                           "loan amount should be greater than zero");
               }
               
               loan.setPrinciple(new BigDecimal(principle));
       } catch (NumberFormatException ex) {
           throw new LoanEntryException (
                   "Please enter a valid loan principle amount.");
       }
    }
    
     // loan term in number of years
    private String readLoanTermInYears() throws LoanEntryException {        
       String termYears_str = prompt("Please Enter the loan term in years: ");
       
       if (termYears_str == null) {
           throw new LoanEntryException(
                    "No input for loan term in years is given."
                     + " Please run the application again");
       }
       
       return termYears_str;
    }
    
    private void setLoanTermInYears(Loan loan) throws LoanEntryException {
        String termYears_str = readLoanTermInYears();
        
        // Loan term in years
       float termYears = 0;         // in years
       
       try {
            termYears = (termYears_str != null)? 
                    Float.parseFloat(termYears_str): 0; 
            
            if (termYears <= 0) {
                throw new LoanEntryException(
                     "Loan term should a zero or a (postive) number of years");
            }
            
            loan.setTermYear(termYears);
       } catch (NumberFormatException ex) {
           throw new LoanEntryException(
                   "Please enter a valid loan term in years.");
       }   
    }
    
    // interest rate percentage
    // could be 5 or 5%
    private String readAPR() throws LoanEntryException {       
       String apr_str = prompt("Please Enter the annual percentage rate: ");
       
       if (apr_str == null) {
           throw new LoanEntryException (
                    "No input for loan annua percentage rate is given."
                     +" Please run the application again");
       } else {
           // strip the '%' sign out if any
           apr_str = apr_str.replaceAll("%", "");
       }
       
       return apr_str;
    }
    
    private void setAPR(Loan loan) throws LoanEntryException {
       String apr_str = readAPR();
        
        // APR in decimal point
       double interest = 0d;
       
       try {
            interest = Double.parseDouble(apr_str);
            
             if (interest < 0) {
                   throw new LoanEntryException(
                           "loan annual percentage rate should be "
                           + "a positive percentage number format");
               }
            
            interest = 
                    (interest > 0)? Double.parseDouble(apr_str) / 100 : 0d;                        
             
             loan.setAnnualPercentageRage(interest);
        } catch (NumberFormatException ex) {
           throw new LoanEntryException(
                   "Please enter a valid annual percentage rate.");
        }   
    }
    
    private String prompt (String message) {
        System.out.print(message);         
        String value = scanner.next();
        System.out.println();
        return value;
        
    }
    
    private void showWelcomeMessage() {
       System.out.println("\nWelcome to Paypal Amortization Calculator Demo.");
       System.out.println("This application is for demo purpose only.");
       System.out.println("For any help please contace Haytham Mohamed 773.454.3447");
       System.out.println("---------------------------------------------------------");
       System.out.println();
    }
    
}

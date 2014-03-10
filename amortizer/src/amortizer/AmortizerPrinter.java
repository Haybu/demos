/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
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
public class AmortizerPrinter {
    
    private AmortizerPrinter() {}
    
    public static void print (List<Payment> payments, BigDecimal totalPrinciplePayouts
            , BigDecimal totalInterestPayout) {
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
                , "Total", totalPrinciplePayouts 
                , totalInterestPayout);
       System.out.println();   
       System.out.println();
    }
    
}

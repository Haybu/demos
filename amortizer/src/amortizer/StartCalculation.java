package amortizer;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author hmohamed
 */
public class StartCalculation extends AbstractChain {
    @Override
     public void calculate(Loan loan) 
    {       
        if(loan.getCalculationWanted() == CalculationAction.START) {
            if(loan.getAmortization() == null) {                
                loan.setAmortization(new ArrayList<Payment>());
            }
            loan.setCalculationWanted(CalculationAction.MONTHLY_PAYMENT);
        } else {
            getNextChain().calculate(loan);    
        }
    }
}

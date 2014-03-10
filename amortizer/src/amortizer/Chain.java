/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amortizer;

/**
 *
 * @author hmohamed
 */
public interface Chain {
    
    public void setNextChain(Chain next);
    
    public Chain getNextChain();
    
    public void calculate(Loan loan);
    
}

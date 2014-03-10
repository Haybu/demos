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
public abstract class AbstractChain implements Chain {
    
    Chain nextChain;
    
    @Override
    public void setNextChain(Chain next) {
        nextChain = next;
    }
    
    @Override
    public Chain getNextChain() { return nextChain; }
    
    @Override
    abstract public void calculate(Loan loan);
    

    
}

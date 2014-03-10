package amortizer;
/**
 * Abstract class to implement the chain interface. It houses methods to set
 * and retrieve the next component in the chain.
 * 
 * @author Haytham Mohamed
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

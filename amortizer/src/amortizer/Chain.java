package amortizer;
/**
 * An interface to implement a chain of command to help cycle through
 * each month's payment computations.
 * 
 * @author Haytham Mohamed
 */

public interface Chain {
    
    public void setNextChain(Chain next);
    
    public Chain getNextChain();
    
    public void calculate(Loan loan);
    
}

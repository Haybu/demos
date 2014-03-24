package tutorial.pat.behavior.chain;

/**
 * 
 * @author hmohamed
 *
 */

public interface Associate {
	
	public void approve(double amount);
	public void setManager (Associate mgr);
	public Associate getManager();
	public void setApprovalLimit(double amount);

}

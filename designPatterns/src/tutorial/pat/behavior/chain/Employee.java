package tutorial.pat.behavior.chain;

public class Employee implements Associate {
	
	Associate manager;
	double approvalLimit;
	
	public Employee(int limit){
		this.setApprovalLimit(limit);
	}

	@Override
	public Associate getManager() {
		return manager;
	}

	@Override
	public void approve(double amount) {
		if (amount > approvalLimit) {
			manager.approve(amount);
		} else {
			System.out.println("I'm approving the amount of $" + amount);
			printInfo();
		}
		
	}

	@Override
	public void setManager(Associate mgr) {
		manager = mgr;
		
	}

	@Override
	public void setApprovalLimit(double amount) {
		approvalLimit = amount;
		
	}
	
	public void printInfo() {
		System.out.println("I'm an employee with approval limit of $" + approvalLimit);	
	}
	
}

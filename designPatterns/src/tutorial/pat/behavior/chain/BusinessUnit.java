package tutorial.pat.behavior.chain;

public class BusinessUnit {

	public static void main(String[] args) {
		Associate employee1 = new Employee(3000);
		Associate employee2 = new Employee(5000);
		Associate employee3 = new Employee(6000);
		
		Associate manager1 = new Employee(12000);
		employee1.setManager(manager1);
		employee2.setManager(manager1);
		employee3.setManager(manager1);
		
		Associate manager2 = new Employee(20000);
		manager1.setManager(manager2);
		
		Associate employee4 = new Employee(200); 
		employee4.setManager(manager2);
		
		employee1.approve(17500);

	}

}

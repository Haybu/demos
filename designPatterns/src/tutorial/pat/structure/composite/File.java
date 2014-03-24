package tutorial.pat.structure.composite;

public class File extends FileComponent {
	
	String name, description;
	
	public File(String _name, String _description) {
		name = _name;
		description = _description;
	}

	public String getName() { return name; }
	public String getDescription() { return description; }
	
	public void printInfo() {
		System.out.println("This is a file with name: " + getName() + " and description: " + getDescription());
	}
}

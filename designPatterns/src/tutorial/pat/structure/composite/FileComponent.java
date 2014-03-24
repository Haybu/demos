package tutorial.pat.structure.composite;

public abstract class FileComponent {
	
	public String getName() { throw new RuntimeException("Unsupported method"); }
	public String getDescription() { throw new RuntimeException("Unsupported method"); }
	
	public void add(FileComponent file) { throw new RuntimeException("Unsupported method"); }
	public void remove(FileComponent file) { throw new RuntimeException("Unsupported method"); }
	
	public FileComponent getFile(int index) { throw new RuntimeException("Unsupported method"); }

	
	public void printInfo() { throw new RuntimeException("Unsupported method"); }
		

}

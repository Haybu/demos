package tutorial.pat.structure.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileComponent {
	
	String name, description;
	List<FileComponent> files;
	
	public Directory(String _name, String _description) {
		name = _name;
		description = _description;
		files = new ArrayList<>();
	}

	public String getName() { return name; }
	public String getDescription() { return description; }
	
	public void add(FileComponent file) { 
		files.add(file);
	}
	public void remove(FileComponent file) {  
		files.remove(file);
	}
	
	public FileComponent getFile(int index) {  
		return files.get(index);
	}

	
	public void printInfo() {
		System.out.println("This is a directory with name: " + getName() + " and description: " + getDescription());
		
		for (FileComponent file: files) {
			file.printInfo();
		}
	}
}

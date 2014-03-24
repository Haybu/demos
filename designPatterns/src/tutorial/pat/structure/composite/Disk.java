package tutorial.pat.structure.composite;

public class Disk {

	public void configure() {
		FileComponent file1 = new File("myfile.html", "html file");
		FileComponent file2 = new File("myfile.xml", "xml file");
		FileComponent file3 = new File("myfile.pdf", "pdf file");
		
		FileComponent Dir1 = new Directory("myDir1", "my first directory");
		Dir1.add(file1);
		Dir1.add(file2);
		Dir1.add(file3);
		
		FileComponent Dir2 = new Directory("myDir2", "my second directory");
		Dir2.add(Dir1);
		Dir2.add(new File("myfile.java", "java file"));
		
		Dir2.printInfo();
	}
	
	public static void main (String[] args) {
		Disk myDisk = new Disk();
		myDisk.configure();
	}
}

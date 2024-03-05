package files;

import java.io.FileWriter;
import java.io.IOException;

public class CustomWriteFile extends FileWriter implements ICustomWriteFile {

	public CustomWriteFile(String fileName) throws IOException {
		super(fileName);
	}
	
	public void closeWriteFile() {
		
	}
	public void writePlayers(String _chain) {
		
	}
}

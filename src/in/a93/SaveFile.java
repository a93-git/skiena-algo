package in.a93;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveFile {
	public static void saveFile(String stringToSave, String filePath) {
		Charset charset = Charset.forName("UTF-16");
		Path p = Paths.get(filePath);
		
		try (BufferedWriter writer = Files.newBufferedWriter(p, charset)) {
		    writer.write(stringToSave, 0, stringToSave.length());
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
}

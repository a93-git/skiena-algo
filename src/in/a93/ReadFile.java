package in.a93;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
	public static ArrayList<String> readFile(String filePath) {
		Charset charset = Charset.forName("UTF-16");
		Path p = Paths.get(filePath);
		ArrayList<String> retval = new ArrayList<String>();
		
		try (BufferedReader reader = Files.newBufferedReader(p, charset)) {
			String line;
			while ((line = reader.readLine()) != null) {
				retval.add(line);
			}
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		
		return retval;
	}

	public static ArrayList<Integer> readIntFile(String filePath) {
		Path p = Paths.get(filePath);
		ArrayList<Integer> retval = new ArrayList<Integer>();
		
		try (Scanner reader = new Scanner(p)) {
			while (reader.hasNextInt()) {
				retval.add(reader.nextInt());
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
		
		return retval;
	}
}

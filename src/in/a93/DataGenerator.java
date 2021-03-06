package in.a93;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Random;

public class DataGenerator {
	public static void generateRandomIntegers(String filePath, int size) {
		// Create an array list of given size
		ArrayList<Integer> intArray = new ArrayList<Integer>(size);
		
		Random rand = new Random();
		
		while (size > 0) {
			intArray.add(rand.nextInt());
			size = size - 1;
		}
		
		StringBuilder s = new StringBuilder();
		for (int i : intArray) {
			s.append(i + "\n");
		}
		
		String stringToSave = s.toString();
		
		SaveFile.saveFile(stringToSave, filePath);
	}
	
	
	/***
	 * 
	 * @param filePath
	 * @param size
	 * @param stringSize
	 * @throws Exception
	 * 
	 * Gathers strings of the given {@code stringSize} from Homer's Odyssey retrieved from Project Gutenberg's website.
	 * The count of strings created is equal to {@code size}. The strings are stored in an UTF-16 encoded file at the given {@code filePath}
	 * 
	 * @author Abhishek
	 * 
	 */
	public static void generateRandomStrings(String filePath, int size, int stringSize) throws Exception {
		int sizeVal = size;
		ArrayList<String> stringArray = new ArrayList<String>(size);
		
		URL url = new URL("https://www.gutenberg.org/files/1727/1727-0.txt");
		URLConnection connection = url.openConnection();
		InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
		BufferedReader reader = new BufferedReader(streamReader);
		
		CharBuffer cb = CharBuffer.allocate(stringSize);
		StringBuilder s = new StringBuilder();

		while (size > 0) {
			reader.read(cb);
			for (char c : cb.array()) s.append(c);
			cb.clear();
			stringArray.add(s.toString().replaceAll("\r\n", "."));
			s.delete(0, s.toString().length());
			size = size - 1;
		}
		reader.close();		
		
		StringBuilder s2 = new StringBuilder();
		for (String i : stringArray) {
			s2.append(i + "\n");
		}
		
		String stringToSave = s2.toString();
		
		System.out.println("String to save is: \n" + stringToSave);
		
		SaveFile.saveFile(stringToSave, filePath);
		
		System.out.printf("Read and stored %s strings of length %s to file %s\n", sizeVal, stringSize, filePath);
	}
}

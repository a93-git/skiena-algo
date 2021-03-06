package in.a93;

import java.util.ArrayList;

import in.a93.sort.*;
public class Executor {
	public static void main(String[] args) throws Exception {
		int size = 500;
		int stringSize = 14;
		
		DataGenerator.generateRandomStrings("E:\\randomStrings.txt", size, stringSize);
		ArrayList<String> dataSet = ReadFile.readFile("E:\\randomStrings.txt");
		String[] dataSetArray = new String[dataSet.size()];
		
		InsertionSort a = new InsertionSort();
		
		
		String[] sortedDataSet = a.sort(dataSet.toArray(dataSetArray), size);
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < sortedDataSet.length; i++) {
			s.append(sortedDataSet[i] + "\n");
		}
		
		SaveFile.saveFile(s.toString(), "E:\\sortedStrings.txt");
	}
}

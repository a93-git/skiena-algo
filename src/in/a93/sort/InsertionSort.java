package in.a93.sort;

public class InsertionSort {
	public <T extends Comparable<T>> T[] sort(T[] data, int size) {
		int i, j;
		T t;
		
		// start from the second element so that we can compare it with the previous element
		// i moves forward whereas j goes back from current i to 0 making sure that the array is sorted till i at the end of every for loop
		long startTime = System.nanoTime();
		for (i = 1; i < size; i++) {
			// j goes in opposite direction 
			// e.g. if i = 3, j will compare 
			// data[3] < data[2] -> update data
			// data[2] < data[1] -> update data 
			// data[1] < data[0] -> update data
			j = i;
			
			while ((j > 0) && (data[j].compareTo(data[j - 1]) < 0 ? true : false)) {
				// swap
				t = data[j];
				data[j] = data[j-1];
				data[j-1] = t;
				j = j - 1;
//				printArray(data);
			}
			
		}
		System.out.printf("Total time to sort %d elements is %d ms\n", size, (System.nanoTime() - startTime) / 1000000);
		
		return data;
	}
	
	@SuppressWarnings("unused")
	private void printArray(Object[] array) {
		StringBuilder s = new StringBuilder();
		
		for (Object i : array) {
			s.append(i + ", ");
		}
		
		System.out.println(s.toString());
	}
}

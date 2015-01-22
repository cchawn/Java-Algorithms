/*
 * Bubble Sort takes O(n^2) time!
 */
public class BubbleSort {
	private int[] myArray;
	private int arraySize;
	static long startTime;
	static long endTime;
	
	BubbleSort(int size){
		arraySize = size;
		myArray = new int[size];
	}//end constructor
	
	public void generateArray() {
		for (int i = 0; i < arraySize; i++){
			myArray[i] = (int) (Math.random() * 1000) + 10;
		}
	}//end generateArray
	
	private void swapValues(int indexOne, int indexTwo){
		int temp = myArray[indexOne];
		myArray[indexOne] = myArray[indexTwo];
		myArray[indexTwo] = temp;
	}//end swapValues
	
	public void sort(){
		startTime = System.currentTimeMillis();
		for(int i = arraySize - 1; i > 1; i--){
			for(int j = 0; j < i; j++){
				if(myArray[j] < myArray[j+1]){
					swapValues(j, j+1);
				}
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Bubble Sort Took: " + (endTime - startTime) + "ms");
	}//end sort

	public static void main(String args[]){
		BubbleSort test1 = new BubbleSort(10000);
		BubbleSort test2 = new BubbleSort(20000);
		
		test1.generateArray();
		test2.generateArray();
		
		test1.sort();
		test2.sort();
		
	}//end main
}

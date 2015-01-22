/*
 * Binary Search is in O(log(n))
 * Uses Quick Sort --> O(n log(n))
 */
public class BinarySearch {
	private int[] myArray;
	private int arraySize;
	static long startTime;
	static long endTime;
	
	BinarySearch(int size){
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
	
	public void quickSort(int left, int right) {
		if (right - left <= 0){
			return;
		}else{
			int pivot = myArray[right];
			int pivotIndex = partitionArray(left, right, pivot);
			quickSort(left, pivotIndex - 1);
			quickSort(pivotIndex + 1, right);
		}
	}// end quickSort
	
	public int partitionArray(int left, int right, int pivot) {
		int leftPointer = left - 1;
		int rightPointer = right;
		while (true) {
			while (myArray[++leftPointer] < pivot)
				;
			while (rightPointer > 0 && myArray[--rightPointer] > pivot)
				;
			if (leftPointer >= rightPointer) {
				break;
			} else {
				swapValues(leftPointer, rightPointer);
			}
		}
		swapValues(leftPointer, right);
		return leftPointer;
	}// end paritionArray
	
	public void search(int value){
		startTime = System.currentTimeMillis();
		
		int low = 0;
		int high = arraySize - 1;
		int mid;
		boolean found = false;
		
		while(low < high){
			mid = (low + high)/2;
			if(myArray[mid] < value){
				low = mid + 1;
			}else if(myArray[mid] > value){
				high = mid - 1;
			}else{
				found = true;
			}
		}
		System.out.println("Value " + value + " found: " + found);
		endTime = System.currentTimeMillis();
		// this algorithm is so fast it's not useful!
		System.out.println("Binary Search took:" + (endTime - startTime) + "ms");
	}// end search
	
	public static void main(String args[]){
		BinarySearch test1 = new BinarySearch(400);
		
		test1.generateArray();
		test1.quickSort(0, test1.arraySize - 1);
		test1.search(10);
	}// end main
}

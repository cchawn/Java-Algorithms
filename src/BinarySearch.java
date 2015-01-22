/*
 * Binary Search is in O(log(n))
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
		
	}// end main
}

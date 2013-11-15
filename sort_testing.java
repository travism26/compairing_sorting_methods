import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class sort_testing {
	public int counter;
	public static boolean isSorted(int[] arr){
	for (int i = 1; i < arr.length; i++){
	    if (arr[i - 1] > arr[i]){
	    	return false;
	    }
	}
	return true;
}
public static boolean linear_search(int[] array, int key){
	for(int i =0; i<array.length; i++){
		if(array[i] == key){
			return true;
		}
	}
	return false;
}

//decided to create a binary search since it requires list to be sorted
public void bineary_search(int[] array, int search_key){
	int[] array2 = array;
	int key = search_key;
	
	//These two variables are unsure if needed
	int beginning;
	int end;
	int middle;

	boolean found = false;
	int length =array2.length;
	//set the end and beginning variables.
	end = length;
	beginning = 0;
	middle = (beginning + end)/2;
	counter = 0;
	while(found !=true){
		if(array2[middle] > search_key){
			end = middle;
			counter++;
		}
		else if(array2[middle] < search_key){
			beginning = middle;
			counter++;
		}
		else if(array2[middle] == key){
			System.out.println("The value you are looking for is in position: " + middle);
			System.out.println("Array[" + middle + "]:" + array2[middle]);
			counter++;
			found = true;
		}
		if(end - beginning <=1 && array[middle] != key){
			if(array[beginning] == key){
				System.out.println("The value you are looking for is in position: " + middle);
				System.out.println("Array[" + middle + "]:" + array2[middle]);
				found = true;
			}
			else{
			System.out.println("That value does not exist in the array");
					break;
					}
				}			
		middle = (beginning + end)/2;
	}
}
public static void main(String[] args) throws NumberFormatException, IOException{
	Scanner input = new Scanner(System.in);   
	Random randomGenerator = new Random();
	sort_testing testing = new sort_testing();
	heap_sort heap = new heap_sort();
	selection_sort selection = new selection_sort();
		
	// we have 2 arrays same values and size
	System.out.print("Please enter array size : ");
	int size = input.nextInt();
	System.out.print("Please enter the random range : ");
	int random = input.nextInt();
	
	// create array
	int[] array = new int[size];
	// fill array
	for(int i=0; i<size; i++) {
	    array[i] = randomGenerator.nextInt(random);
	}
	System.out.println(array.length);
	 
	int[] heap_sort = array;
	int[] selection_sort = array;
	final long startTime = System.currentTimeMillis();
	heap_sort = heap.sort(heap_sort);
	final long endTime = System.currentTimeMillis();
	System.out.println("heap sort done");

	System.out.println();
	System.out.println("Binary Seach: Please enter your search value to find the position within the array: ");
	int key = input.nextInt();
	testing.bineary_search(heap_sort, key);
	System.out.println("The number of computations were: " + testing.counter);
	System.out.println("does the value exist: "+ linear_search(heap_sort, key));
	
	System.out.println("Heap sort:");
	System.out.println("Total execution time: " + (endTime - startTime) +"ms");
	System.out.println("Selection sort:");
	final long startTime2 = System.currentTimeMillis();
	selection_sort = selection.selectionSort(selection_sort);
	final long endTime2 = System.currentTimeMillis();
	System.out.println("Total execution time: " + (endTime2 - startTime2) +"ms" );
	
	//Sanity check
	if(isSorted(heap_sort)){
		 System.out.println("heap_sort list is correctly sorted");
	 }
	if(isSorted(selection_sort)){
		 System.out.println("selection_sort list is correctly sorted");
	 }
}//main method		
}//class

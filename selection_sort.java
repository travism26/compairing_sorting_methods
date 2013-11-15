/**
  * 
  * @author Travis Martin
  * @version 2.0
  *
  */
public class selection_sort {
	
	public int[] selectionSort(int[] unsortedList){
		int[] array = unsortedList;
		/*
		 * This will need a double for loop 'i' and 'j', 'i' will hold the
		 * current position of the sorted list, while 'j' will search for
		 * the next smallest value.
		 */
		int temp;
		int current_smallest;
		for(int i = 0; i<array.length; i++){
			/* this will save the current_smallest values location. Remember we need the
			 * location of these values not the values them selves, we will use the location
			 * to swap them.
			 */
			current_smallest = i;
			for(int j = i+1; j<array.length; j++){
				if(array[current_smallest] > array[j]){
					current_smallest = j;
					
				}else{
					;
				}
			}//second for loop
			//if the next smallest value is already in its place skip to next value
			if(current_smallest ==i){
				;
				//else swap them
			}else{
				temp = array[i];
				array[i] = array[current_smallest];
				array[current_smallest] = temp;
			}
		}//first for loop
		return array;
	}
}//class

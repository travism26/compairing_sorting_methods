/**
  * @author Travis Martin
  * @version 2.0
  * I put in comments to try and help you understand what is happening during that step
  */
import java.util.*;

public class heap_sort {
	
	public static boolean isSorted(int[] arr){
		for (int i = 1; i < arr.length; i++){
		    if (arr[i - 1] > arr[i]){
		    	return false;
		    }
		}
		return true;
	}
    
	public int[] build_heap(int[] array){
	    int[] array2 = array;
		int length=array.length-1;
	    for(int i=length/2;i>=0;i--){
	    	heap_properties(i, length, array2);
	    }
	    return array2;
	}
	    
	public void heap_properties(int i, int length, int[] array){
		/*
		 * When building a heap into an array we need away to identify the child
		 * nodes, the formula for this would be left_child = 2*(parent_index) and
		 * the right_child = (2*(parent_node)) + 1. we can now pass in a parent and
		 * get its children. 
		 */
	    int left_value=2*i;
	    int right_value=2*i+1;
	    /*
	     * This large value will be used to check the children nodes and compare with the parent
	     * to ensure that the graph holds the heap properties. if the large_value equals one of 
	     * the children we will swap them and recall the maxheap function, to ensure that when
	     * we swap the parent and child it still holds the heap properties in the child nodes.
	     */
	    int large_value;
	    /**
	      * Check the left child, make sure that the left child
	      * exist first so we dont receive a null pointer exception
	      * next check if the child > then parent.
	      */
	    if(left_value <= length && array[left_value] > array[i]){
	        large_value=left_value;
	    }
	    /**
	      * else assign the large value = to parent 
	      */
	    else{
	        large_value=i;
	    }
	    /**
	      * check the right child does right child exist? if so is it
	      * larger then the parent?
	      */
	    if(right_value <= length && array[right_value] > array[large_value]){
	        large_value=right_value;
	    }
	    /**
	      * If the large_value is not the parent we need to swap
	      * and re-run the function on the large_value to ensure
	      * that we didn't break the heap property when we swapped
	      * the child and parent.
	      */
	    if(large_value!=i){
	        swap(i,large_value, array);
	        heap_properties(large_value, length, array);
	    }
	}

	public int[] sort(int[] array_sort){
    	
    	int[] sorted = array_sort;
        build_heap(sorted);
        //the length of the array -1 because the array starts at 0
        int length = sorted.length-1;
        /*
         * essentially we want to swap the last element in the array with the root heap (largest value)
         * this will put the biggest value in the array in the back. Then you want to run the maxheap function
         * to re-organize the array to keep the heap properties O(log n) and then you decrement to the second
         * last position in the array and repeat move the root array[0] to second last, run maxheap decrement...
         */
        for(int i=length;i>0;i--){
            swap(0, i, sorted);
            length=length-1;
            heap_properties(0, length, sorted);
        }
		return sorted;
    }

	public void swap(int i, int j, int[] array){
	    int temp=array[i];
	    array[i]=array[j];
	    array[j]=temp;
	}

}
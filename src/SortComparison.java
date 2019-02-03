/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2019
 */

 class SortComparison {
	 //Use comparable T to use ints and chars (only used in partition)
	 //may be redundant if all using doubles
    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
	 double[] insertionSort (double a[]){
    	double temp;
    	if(a==null) {
    		return a;
    	}
		for (int i = 1; i < a.length; i++) 
		{
			for(int j = i ; j > 0 ; j--)
			{
				if(a[j] < a[j-1])	//if it is smaller then an preceding entry
				{
					temp = a[j];	//swap sequence
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		return a;
    }//end insertion sort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
	 double[] quickSort(double a[]){
		 if(a==null) {
			 return a;
		 }
		 else {
			 quickSortRecursion(a,0,a.length-1);
			 return a;
		 }
	 }
    void quickSortRecursion (double a[],double lo, double hi){
    	//recursive implementation of quickSort using partition function

    	if(hi <= lo) {
    		return;
    		}
    	int pivot = partition(a, lo, hi);
    	quickSortRecursion(a, lo, pivot-1);
    	quickSortRecursion(a, pivot+1, hi);
    }//end quicksort

    private static int partition(double[] numbers, double lo, double hi) {//comparable might not be needed
    	//function to find the pivot in quickSort
    	//the int casts are needed for the double array
    	int i = (int) lo;
    	int j = (int) (hi+1);
    	double pivot = numbers[(int) lo];
    	while(true) {
    		while(numbers[++i]<pivot) {
    			if(i == hi) {
    				break;
    			}
    		}
    		while(pivot<numbers[--j]) {
    			if(j == lo) {
    				break;
    			}
    		}
    		if(i >= j) {
    			break;
    		}
    		double temp = numbers[i];
    		numbers[i] = numbers[j];
    		numbers[j] = temp;
    		}
    	numbers[(int) lo] = numbers[j];
    	numbers[j] = pivot;
    	return j;
    	}
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
		return a;

		 //TODO: implement the sort
	
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
		return a;
    	

    	//TODO: implement the sort
	
   }//end mergeSortRecursive
    	
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
		return a;

         //TODO: implement the sort

    }//end selectionsort

   


    public static void main(String[] args) {

        //TODO: do experiments as per assignment instructions
    }

 }//end class
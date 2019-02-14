import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Liam Collins
 *  @version HT 2019
 */



/**
 * QUESTIONS TO ANSWER
 * @author Liam
 *
 *RESULTS:
 *
 *
 *
a. Which of the sorting algorithms does the order of input have an impact on? Why?


b. Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?


c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
based on the input size? Please consider only input files with random order for this answer.


d. Did you observe any difference between iterative and recursive implementations of merge
sort?


e. Which algorithm is the fastest for each of the 7 input files? 


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
	 static double[] insertionSort (double a[]){
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
	 static double[] quickSort(double a[]){
		 if(a==null) {
			 return a;
		 }
		 else {
			 quickSortRecursion(a,0,a.length-1);
			 return a;
		 }
	 }
    private static void quickSortRecursion (double a[],double lo, double hi){
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

    public static double[] mergeSortIterative (double a[]) {
      	if(a==null) {
    		return a;
    	}
    	mergeSortIterativeSort(a);
    	return a;
    }
    
    private static void mergeSortIterativeSort(double[] a) {
    	int N = a.length;
    	double[] copy = new double[N];
    	for(int k=1;k<N;k=k+k) {
    		for(int lo=0;lo<N-k;lo+=k+k) {
    			mergeSortIterativeMerge(a,copy,lo,lo+k-1,Math.min(lo+k+k-1, N-1));
    		}
    	}
    }
    
    private static void mergeSortIterativeMerge(double[]a,double[]copy,int lo,int mid, int hi) {
    	for(int k=lo;k<=hi;k++) {
    		copy[k]=a[k];
    	}
    	int i=lo;
    	int j=mid+1;
    	for(int k=lo;k<=hi;k++) {
    		if(i>mid) {
    			a[k] = copy[j++];
    		}else if(j>hi){
    			a[k]=copy[i++];
    		}else if(copy[j]<copy[i]) {
    			a[k]=copy[j++];
    		}else {
    			a[k]=copy[i++];
    		}
    	}
    }
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    public static double[] mergeSortRecursive (double a[]) {
    	if(a==null) {
    		return a;
    	}
    	double[] copy = new double[a.length];
    	mergeSortRecursiveSort(a,copy,0,a.length-1);
    	return a;
   }//end mergeSortRecursive
    	
    private static void mergeSortRecursiveSort(double[]a,double[]copy,int lo,int hi) {
    	if(hi<=lo) {
    		return;
    	}
    	int mid = lo+(hi-lo)/2;
    	mergeSortRecursiveSort(a,copy,lo,mid);//left sort
    	mergeSortRecursiveSort(a,copy,mid+1,hi);//right sort
    	mergeSortRecursiveMerge(a,copy,lo,mid,hi);
    }
    
    private static void mergeSortRecursiveMerge(double[]a,double[]copy,int lo,int mid, int hi) {
    	for(int k=lo;k<=hi;k++) {
    		copy[k]=a[k];
    	}
    	int i=lo;
    	int j=mid+1;
    	for(int k=lo;k<=hi;k++) {
    		if(i>mid) {
    			a[k] = copy[j++];
    		}else if(j>hi){
    			a[k]=copy[i++];
    		}else if(copy[j]<copy[i]) {
    			a[k]=copy[j++];
    		}else {
    			a[k]=copy[i++];
    		}
    	}
    }
    
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
   public static double [] selectionSort (double a[]){
    	if(a==null) {
    		return a;
    	}
    	selectionSortSort(a);
    	return a;

    }//end selectionsort

    private static void selectionSortSort(double a[]) {
    	int n = a.length;
    	// One by one move boundary of unsorted subarray
    	for (int i = 0; i < n-1; i++)
    	{
    		// Find the minimum element in unsorted array
    		int min_idx = i;
    		for (int j = i+1; j < n; j++)
    			if (a[j] < a[min_idx]) {
    				min_idx = j;
    			}
    		// Swap the found minimum element with the first element
    		double temp = a[min_idx];
    		a[min_idx] = a[i];
    		a[i] = temp;
    	}

    }

 }//end class
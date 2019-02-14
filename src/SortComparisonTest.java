import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Liam Collins
 *  @version HT 2019
 *  
 *  
 
 * QUESTIONS TO ANSWER
 *
 *
 *RESULTS:
 *						|Insert |  Quick| MergeR| MergeI|	Select
 *						|-------|-------|-------|-------|-------------
 *10					|2		|5		|11		|17		|5
 *						|-------|-------|-------|-------|-------------
 *100					|90		|39		|79		|62		|116
 *						|-------|-------|-------|-------|-------------
 *1000					|3359	|339	|160	|226	|5291
 *						|-------|-------|-------|-------|-------------
 *1000 unique			|502	|2537	|54		|116	|268
 *						|-------|-------|-------|-------|-------------
 *1000 nearly ordered	|500	|111	|33		|66		|180
 *						|-------|-------|-------|-------|-------------
 *1000 reversed			|473	|112	|47		|416	|251
 *						|-------|-------|-------|-------|--------------
 *1000 sorted			|306	|70		|32		|66		|181
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
	10-
	100-
	1000-
	unique-
	nearlyOrdered-
	reversed-
	sorted-

 */
 
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	SortComparison testSort = new SortComparison();
    	double a[]=null;
    	double result[] = null;
    	result = testSort.insertionSort(a);
    	assertEquals("Insertion Sort Test if Empty",a,result);	//insertionSort empty test 	
    	testSort.quickSort(a);
    	assertEquals("Quick Sort Test if Empty",a,result);		//quickSort empty test
    	result = testSort.mergeSortIterative(a);
    	assertEquals("Merge Sort Iterative if Empty",a,result);	//mergeSortIterative empty test
    	result = testSort.mergeSortRecursive(a);
    	assertEquals("Merge Sort Recursive if Empty",a,result); //mergeSortRecusive empty test
    	result = testSort.selectionSort(a);
    	assertEquals("Selection Sort if Empty",a,result);		//selectionSort empty test
    }


    // TODO: add more tests here. Each line of code and each decision in SortComparison.java should
    // be executed at least once from at least one test.
    @Test
    public void testInsertionSort() {
    	SortComparison testSort = new SortComparison();
    	double a[] = {8,4,7,3,2,5,6,9,10,1};
    	double sorted[] = {1,2,3,4,5,6,7,8,9,10};
    	double result[]=testSort.insertionSort(a);
    	/*for(int i=0;i<a.length;i++) {
    		System.out.println(a[i]);
    	}*/
    	boolean equals = true;
    	for(int i=0;i<sorted.length;i++) {
    		if(result[i]!=sorted[i]) {
    			equals = false;				//for loop to check if arrays are equal
    		}
    	}
    	//System.out.println(equals);
    	assertTrue("Testing insertionSort",equals);		//WORKS
    }
    
    @Test
    public void testQuickSort() {
    	SortComparison testSort = new SortComparison();
    	double a[] = {8,4,7,3,2,5,6,9,10,1};
    	double sorted[] = {1,2,3,4,5,6,7,8,9,10};
    	double result[] = testSort.quickSort(a);
    	boolean equals = true;
    	for(int i=0;i<sorted.length;i++) {
    		if(result[i]!=sorted[i]) {
    			equals = false;				//for loop to check if arrays are equal
    		}
    	}
    	assertTrue("Testing quickSort",equals);	//WORKS
    }
    
    @Test
    public void testMergeSortIterative(){
    	SortComparison testSort = new SortComparison();
    	double a[] = {8,4,7,3,2,5,6,9,10,1};
    	double sorted[] = {1,2,3,4,5,6,7,8,9,10};
    	double result[]=testSort.mergeSortIterative(a);
    	boolean equals = true;
    	for(int i=0;i<sorted.length;i++) {
    		if(result[i]!=sorted[i]) {
    			equals = false;				//for loop to check if arrays are equal
    		}
    	}
    	assertTrue("Testing mergeSortIterative",equals);	//WORKS
    }
    
    @Test
    public void testMergeSortRecursive() {
    	SortComparison testSort = new SortComparison();
    	double a[] = {8,4,7,3,2,5,6,9,10,1};
    	double sorted[] = {1,2,3,4,5,6,7,8,9,10};
    	double result[] = testSort.mergeSortRecursive(a);
    	boolean equals = true;
    	for(int i=0;i<sorted.length;i++) {
    		if(result[i]!=sorted[i]) {
    			equals = false;				//for loop to check if arrays are equal
    		}
    	}
    	assertTrue("Testing mergeSortRecursive",equals);	//WORKS
    }
    
    @Test
    public void testSelectionSort() {
    	SortComparison testSort = new SortComparison();
    	double a[] = {8,4,7,3,2,5,6,9,10,1};
    	double sorted[] = {1,2,3,4,5,6,7,8,9,10};
    	double result[] = testSort.selectionSort(a);
    	boolean equals = true;
    	for(int i=0;i<sorted.length;i++) {
    		if(result[i]!=sorted[i]) {
    			equals = false;				//for loop to check if arrays are equal
    		}
    	}
    	assertTrue("Testing selectionSort",equals);	//WORKS
    }

	// ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args) 
	   {
	    	double unsort[];
	    	System.out.println("NUMBERS 10 TEST");
	    	unsort = readArray(10,"numbers10.txt");
	    	runTests(unsort);
	    	System.out.println("NUMBERS 100 TEST");
	    	unsort = readArray(100,"numbers100.txt");
	    	runTests(unsort);
	    	System.out.println("NUMBERS 1000 TEST");
	    	unsort = readArray(1000,"numbers1000.txt");
	    	runTests(unsort);
	    	System.out.println("NUMBERS 1000 DUPLICATES TEST");
	    	unsort = readArray(1000,"numbers1000Duplicates.txt");
	    	runTests(unsort);
	    	System.out.println("NUMBERS 1000 NEARLY ORDERED TEST");
	    	unsort = readArray(1000,"numbersNearlyOrdered1000.txt");
	    	runTests(unsort);
	    	System.out.println("NUMBERS 1000 REVERSE TEST");
	    	unsort = readArray(1000,"numbersReverse1000.txt");
	    	runTests(unsort);
	    	System.out.println("NUMBERS 1000 SORTED TEST");
	    	unsort = readArray(1000,"numbersSorted1000.txt");
	    	runTests(unsort);
	    	
	   }    
public static void runTests(double[] unsort) {
	SortComparison testSort = new SortComparison();
	insertRun(unsort,testSort);
	quickRun(unsort,testSort);
	mergeRRun(unsort,testSort);
	mergeIRun(unsort,testSort);
	selectionRun(unsort,testSort);
}


public static void insertRun(double[] unsort,SortComparison testSort) {
 	double[] test = unsort;
 	long avgTime = 0;
 	for(int i=0;i<3;i++) {
 		long startTime = System.nanoTime();
 		testSort.insertionSort(test);
 		long endTime = System.nanoTime();
 		long runTime = endTime-startTime;
 		avgTime+=runTime;
	    	test = unsort;
 	}
 	avgTime= avgTime/3;
 	avgTime = avgTime/1000;
 	System.out.println("Average Run Time for Insertion Sort"
 			+ " is: "+avgTime+" milliseconds");
}

public static void quickRun(double[] unsort,SortComparison testSort) {
 	double[] test = unsort;
 	long avgTime=0;
 	for(int i=0;i<3;i++) {
 		long startTime = System.nanoTime();
 		test = testSort.quickSort(test);
 		long endTime = System.nanoTime();
 		long runTime = endTime-startTime;
 		avgTime+=runTime;
	    	test = unsort;	//reset test
 	}
 	avgTime= avgTime/3;
 	avgTime = avgTime/1000;
 	System.out.println("Average Run Time for Quick Sort "
 			+ "is : "+avgTime+" milliseconds");
}

public static void mergeRRun(double[] unsort,SortComparison testSort) {
	double[] test = unsort;
	long avgTime=0;
	for(int i=0;i<3;i++) {
		long startTime = System.nanoTime();
		test = testSort.mergeSortRecursive(test);
		long endTime = System.nanoTime();
		long runTime = endTime-startTime;
		avgTime+=runTime;
 	test = unsort;	//reset test
	}
	avgTime= avgTime/3;
	avgTime = avgTime/1000;
	System.out.println("Average Run Time for Merge Sort Recursive"
			+ " is: "+avgTime+" milliseconds");
}
public static void mergeIRun(double[] unsort,SortComparison testSort) {
	double[] test = unsort;
	long avgTime=0;
	for(int i=0;i<3;i++) {
		long startTime = System.nanoTime();
		test = testSort.mergeSortIterative(test);
		long endTime = System.nanoTime();
		long runTime = endTime-startTime;
		avgTime+=runTime;
 	test = unsort;	//reset test
	}
	avgTime= avgTime/3;
	avgTime = avgTime/1000;
	System.out.println("Average Run Time for Merge Sort Iterative"
			+ " is: "+avgTime+" milliseconds");
}

public static void selectionRun(double[] unsort,SortComparison testSort) {
	double[] test = unsort;
	long avgTime=0;
	for(int i=0;i<3;i++) {
		long startTime = System.nanoTime();
		test = testSort.selectionSort(test);
		long endTime = System.nanoTime();
		long runTime = endTime-startTime;
		avgTime+=runTime;
 	test = unsort;	//reset test
	}
	avgTime= avgTime/3;
	avgTime = avgTime/1000;
	System.out.println("Average Run Time for Selection Sort "
			+ " is: "+avgTime+" milliseconds");
}


public static double[] readArray(int size, String filename) 
	{
		double result[] = new double[size];
		FileReader fr;
		try {
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			for(int i=0;i<size;i++) {
				double tmp = br.read();
				result[i] = tmp;
			}
			br.close();
		} catch (IOException e) {
			System.out.println("ERROR: File read fail");
			e.printStackTrace();
		}
		
		return result;	
 }

}

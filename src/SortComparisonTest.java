import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2019
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
    	
    }


    // TODO: add more tests here. Each line of code and each decision in SortComparison.java should
    // be executed at least once from at least one test.
    @Test
    public void testInsertionSort()
    {
    	SortComparison testSort = new SortComparison();
    	double a[] = {8,4,7,3,2,5,6,9,10,1};
    	double sorted[] = {1,2,3,4,5,6,7,8,9,10};
    	double result[]=testSort.insertionSort(a);
    	for(int i=0;i<a.length;i++) {
    		System.out.println(a[i]);
    	}
    	boolean equals = true;
    	for(int i=0;i<sorted.length;i++) {
    		if(result[i]!=sorted[i]) {
    			equals = false;				//for loop to check if arrays are equal
    		}
    	}
    	System.out.println(equals);
    	assertTrue("Testing insertionSort",equals);		//WORKS
    }

	// ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}

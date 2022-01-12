package ie.gmit.dip;

import java.util.Random; 

    /*	int low = 4000;
		int high = 6000;
		Object r;
		int result = ((Object) r).nextInt(high-low) + low;
		System.out.println(array.toString());*/
//code block to solve the issue with input array in benchmark in countingSort and MergeSort.
//Improvement to be made with 7 classes utilising inheritance or extension of a parent superclass as extends class Randomise. 

public class Randomise {
	
	public static void main(String[] args) {
		 Random rand = new Random();  //declare a random function 
		    int[] list = new int[10];  //declare a list of integers of 10 integers
		    for (int r = 0; r < list.length; r++) {    //for loop to increment the counter r++
		    	list[r] =  rand.nextInt(10000) + 1;     //list called r is declared and the random function generates next integers to a maxima.
		            System.out.print(list[r] + " "); // print on this line
		        }
		        System.out.println();
		}
}  											// entire method for randomising an array of integers using a Class in java using one dimension array.



//to figure out a method to have a series of array sizes
//int sizes[] = { 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000 };

public class Sorting {

	private static int key;

	public static int[] randomArray(int n) { // CTA project specification to generate 100 random numbers sample size
		int[] array = new int[n];            //array of integers declared
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 100);  //generates 100 integers.
		}
		return array;
	}

	public static void bubbleSort(int[] arr) { // bubbleSort sorting algorithm
		int n = arr.length;                     //integer n in array of a length
		for (int outer = n - 1; outer > 0; outer--) {   //decrement from the end of the array
			for (int inner = 0; inner < outer; inner++) {   //increment from the start index
				if (arr[inner] > arr[inner + 1]) {          //if loop if the inner integer is greater than inner integer
					int temp = arr[inner]; 				 //call temp arr[inner]
					arr[inner] = arr[inner + 1];		//bubbleSort the inner array forwards in the array until it is one more than the next integer
					arr[inner + 1] = temp;               //temp integer bubbleSort towards the end of the array if it is greater than next integer in array
				}
			}
		}  
	}
	
	public static void selectionSort(int[] a){    //selectionSort coding algorithm 
		for (int outer = 0; outer < a.length-1; outer++){  //for loop
			System.out.println("outer is " + outer);
			int min = outer;
			for(int inner = outer+1; inner < a.length; inner++){   //for loop stating that outer integer is greater than inner integer in array
				if (a[inner] < a[min]){        //if leftmost integer is less than outer than swap over with outermost integer
					min = inner;
				}
			}
			int temp = a[outer];
			a[outer] = a[min];    //cross swap the elements closest to each other
			a[min] = temp;  //a[min] is known as temp
		}
	}
	
	
	private static int a(int i) {  //part of the insertionSort code in Eclipse IDE. Insertion sort algorithm
		return 0;
	}
	public static void insertionSort(int a[]) { //moodleCode from lecture notes
		for (int i = 1; i < a.length; i++) {
			int key = a[i]; // value to be inserted is the key variable
			int j = i - 1;   //integer j is less than the i counter
								
			while (j > 0 && a[j] > key) {     //move all elements > key right one position past key integer
				a[j] = a(j + 1);              
				j = j - 1;
			}
		}
		int j = 0;
		a[j + 1] = key; //insert key to new position
	}


	
	public static void main(String[] args) { // method of counting time and obtaining the average.
		int numRuns = 10;
		double total = 0d; // variable for storing total of 10 sorts
		for (int run = 0; run < numRuns; run++) {  //for loop to reach the numRuns of 10
			long startTime = System.nanoTime();      //log the start time in nanoseconds
			
			insertionSort(randomArray(10000));  //alter this line of code to input an array of a maximum size after processing by an algorithm
			
			long endTime = System.nanoTime();   // log the end time in nanoseconds
			long timeElapsed = endTime - startTime;   //calculate the time elapsed in nanoseconds
			double elapsedMillis = timeElapsed / 1000000.0;  //obtains the value in decimal division  after milliseconds conversion
			total += elapsedMillis; // add total to variable 10 times, then divide when you exit the loop
		}  //end of loop
		System.out.format("%.3f", + total / numRuns); // Divide total by count of 10 to get the average
	}
}

//https://stackoverflow.com/questions/24813663/testing-mergesort-algorithm-by-generating-random-numbers
public int[] mergeSort(int [] list) {   //mergeSort algorithm code from eclipse IDE manipulation
			mergeSort(randomArray(100));
		    if (list.length <= 1) {
		        return list;
		    }

		    // Split the array in half
		    int[] first = new int[list.length / 2];
		    int[] second = new int[list.length - first.length];
		    System.arraycopy(list, 0, first, 0, first.length);
		    System.arraycopy(list, first.length, second, 0, second.length);

		    // Sort each half
		    mergeSort(first);
		    mergeSort(second);

		    // Merge the halves together, overwriting the original array
		    merge(first, second, list);
		    return list;
		}

		private static void merge(int[] first, int[] second, int [] result) {
		    // Merge both halves into the result array
		    // Next element to consider in the first array
		    int iFirst = 0;
		    // Next element to consider in the second array
		    int iSecond = 0;

		    // Next open position in the result
		    int j = 0;
		    // As long as neither iFirst nor iSecond is past the end, move the
		    // smaller element into the result.
		    while (iFirst < first.length && iSecond < second.length) {
		        if (first[iFirst] < second[iSecond]) {
		            result[j] = first[iFirst];
		            iFirst++;
		        } else {
		            result[j] = second[iSecond];
		            iSecond++;
		        }
		        j++;
		    }
		    // copy what's left
		    System.arraycopy(first, iFirst, result, j, first.length - iFirst);
		    System.arraycopy(second, iSecond, result, j, second.length - iSecond);
		}
		
		
		
		
		// Counting sort in Java programming
//https://www.programiz.com/dsa/counting-sort
import java.util.Arrays;

class CountingSort {                //countingSortAlgorithm with a separate class
  void countSort(int array[], int size) {
    int[] output = new int[size + 1];

    // Find the largest element of the array
    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max)
        max = array[i];
    }
    int[] count = new int[max + 1];

    // Initialize count array with all zeros.
    for (int i = 0; i < max; ++i) {
      count[i] = 0;
    }

    // Store the count of each element
    for (int i = 0; i < size; i++) {
      count[array[i]]++;
    }

    // Store the cummulative count of each array
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    // Find the index of each element of the original array in count array, and
    // place the elements in output array
    for (int i = size - 1; i >= 0; i--) {
      output[count[array[i]] - 1] = array[i];
      count[array[i]]--;
    }

    // Copy the sorted elements into original array
    for (int i = 0; i < size; i++) {
      array[i] = output[i];
    }
  }

  // Driver code for counting sort
  public static void main(String args[]) {
    int[] data = { 4, 2, 2, 8, 3, 3, 1 };
    int size = data.length;
    CountingSort cs = new CountingSort();
    cs.countSort(data, size);
    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(data));
  }
}



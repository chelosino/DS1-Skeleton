import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Main implements DS1Interface  {

    /* Implement these methods */

    @Override
    
    /* This implementation is based on the pseudocode viewed in the lectures*/
    
    public int[] insertionSort(int[] input) {	/* Implementation "in situ" of the insertionSort algorithm */
    	for (int i = 1; i <= input.length - 1; i++){	/* Outer loop goes through all the item in the input array */
    		int key = input[i];	/* We set the key with the value of the first non-sorted element */
    		int j = i-1;
    		while (j >= 0 && input[j] > key){	/* Inner loop goes through the sorted part of the array */
    			input[j+1] = input[j];	/* We copy the value of the compared item to the right position */
    			j = j-1;	/* Doing this inner loop we "move" the sorted part to the right until we create a free spot for the key */
    		input[j+1] = key;	/* We insert the key value in the free spot on the sorted part */
    		}
    	}
        return input;	/* Because this sorting is "in situ" we can return the same array */
        
    /* We can see that the outer loop goes through the whole array so it takes n times to complete.
     * The inner loop, in the worst case, goes through all the sorted part so in the end the complexity of the algorithm
     * is O(n^2) */
    }

    @Override
    
    /* This implementation is based on the pseudocode viewed in the lectures */
    
    /* In mergeSort we use recursive calls.
     * While the sequence is non-empty, we split the array in 2 parts and we make the recursive call with each of them.
     * When the recursive call hits the base case, the algorithm starts to merge the sorted pieces until we have the sorted full array */
    
    public int[] mergeSort(int[] input) {	/* Implementation "ex situ" of the mergeSort algorithm */
    	
        if (input.length <=1){	/* This is the base case. An array of 0 or 1 element is always sorted */
    		return input;
    	}
        /* We have to divide the array in 2 parts (almost equal) */
    	int q = Math.floorDiv(input.length, 2);	/* We decide the point that is going to split the array */
    	int[] left = Arrays.copyOfRange(input, 0, q);	/* We create the first new array from the start to the splitting point */
    	int[] right = Arrays.copyOfRange(input, q, input.length);	/* We create the second new array with the rest of the input array */
    	/* Now we make the recursive call */
        left = mergeSort(left);	/* Recursive call for the fist array */
    	right = mergeSort(right);	/* Recursive call for the second array */
    	return merge(left, right);	/* This method is explained below */
    }

    /* The "merge" method is going to merge 2 different sorted arrays */  
    
    private int[] merge(int[] left, int[] right) {	/* The input are the 2 sorted arrays we are going to merge */
    	int i = 0;
    	int j = 0;
    	int[] result = new int[left.length+right.length];	/* The length of the new array is the sum of the length of the 2 input arrays */
    	while (i < left.length && j < right.length){	/* The algorithm is going to enter to the loop only if we still have elements in both arrays that hasn't been merged yet */
    		if (left[i] <= right[j]){	/* We evaluate if the fist non-merged value of the left part is lower than the first non-sorted value of the right part */
    			result[i+j] = left[i];	/* We append this value (left[i]) to the merged array in the first empty position */
    			i++;
    		}

    		else{
    			result[i+j] = right[j];	/* We append this value (right[j]) to the merged array in the first empty position */
    			j++;
    		}
    	}

        /* When we don't have more elements in one of the input arrays we just append the remaining elements to the new array */

    	if (i == left.length && j < right.length){	/* We check if the left array is already been merged completely */
    		while (j < right.length){	/* We append the whole right array to the end of the merged array */
    			result[i+j] = right[j];
    			j++;
    		}
    	}
    	else if (j == right.length && i < left.length){
    		while (i < left.length){	/* We append the whole left array to the end of the merged array */
    			result[i+j] = left[i];
    			i++;
    		}
    	}
    	return result;	/* We return the new merged array that is going to work as input to the next recursive calls river up */
    }

    /* If we assume that the length of the algorithm has the form 2^i, the recursion tree that is being creating has log(n+1) layers.
     * The work per layer is O(n) so we can conclude that in the worst case, the algorithm will have a complexity of O(n*log(n))
     * and in the best case the algorithm will also have an O(n*log(n)) complexity because it will always have to make the recursive calls and create the tree.*/

    @Override

<<<<<<< Updated upstream
=======
<<<<<<< HEAD
    /* The HeapSort can be divided in three parts.
     * The first part is to convert the array into a max-heap,
     * then we have to swap the position of the last element with the first one and exclude it from the heap,
     * and finally, we have to reconstruct the max-heap and repeat the algorithm. */
=======
>>>>>>> Stashed changes
    /*The HeapSort can be divided in three parts*/
    /*The first part is convert the array into a max-heap*/
    /*Then we have to swap the position of the last element with the first one, and exclude it from the heap*/
    /*Finally, we have to reconstruct the max-heap and repeat the algorithm*/
>>>>>>> origin/master

    public int[] heapSort(int[] input) {
    	buildHeap(input);	/* First we need to build the max-heap (algorithm below) */
    	for (int i = n; i > 0; i--){	/* We repeat this loop n times (one time for each element in the heap) */
    		swap(input,0,i);	/* We swap the first element (the root) with the last one */
    		n--;
    		buildMaxHeap(input,0); /* We reconstruct the max-heap */
    	}
        return input;	/* We return the input array but now sorted. This is an "in situ" sorting algorithm */
    }

    private static int n;	/* We'll use this static variable so we can share the value between the methods */
    
    /* This method change the position of 2 elements of one array by swapping them */
	private static void swap(int[] input, int i, int i2) {	/* The inputs are the array and the 2 positions of the elements we want to swap */
		int tmp = input[i];	/* This is the common swapping method */
        input[i] = input[i2];
        input[i2] = tmp; 
	}
<<<<<<< HEAD
	
	/* This algorithm sort an array as a max-heap */
	private static void buildHeap(int[] input) {	/* We build the heap using the algorithm below */
=======

    /*This algorithm sort an array as a max-heap*/
	private static void buildHeap(int[] input) {
>>>>>>> origin/master
		n = input.length-1;
        for (int i = n/2; i >= 0; i--){
            buildMaxHeap(input,i);	/* We ensure that our heap is a max-heap */
        }
	}

    /* This method is also called "maxHeapify" */
	private static void buildMaxHeap(int[] input, int i) {
		{ 
<<<<<<< Updated upstream
	        int left = 2*i ; /*The left son of the node*/
	        int right = 2*i + 1; /*The right son of the node*/
	        int max = i; /*The variable "max" is going to be the faher node*/
	        if (left <= n && input[left] > input[i]) /*If the left son is bigger, it will be the new father*/
	            max = left;
=======
<<<<<<< HEAD
			int left = 2*i ;	/* The left son of the node i */
			int right = 2*i + 1;	/* The right son of the node i */
			int max = i;	/* The variable "max" is going to be the father node */
			if (left <= n && input[left] > input[i])	/* If the left son is bigger than the father then it will become the new father */
	            max = left;
			if (right <= n && input[right] > input[max])	/* If the right son is bigger than the father then it will become the new father */       
	            max = right;
			if (max != i)	/* If we made a change */
	        {
	            swap(input, i, max);	/* We swap the former father with the new one */
	            buildMaxHeap(input, max);	/* We make the recursive call */
=======
	        int left = 2*i ; /*The left son of the node*/
	        int right = 2*i + 1; /*The right son of the node*/
	        int max = i; /*The variable "max" is going to be the faher node*/
	        if (left <= n && input[left] > input[i]) /*If the left son is bigger, it will be the new father*/
	            max = left;
>>>>>>> Stashed changes
	        if (right <= n && input[right] > input[max]) /*If the right son is bigger, it will be the new father*/       
	            max = right;
	 
	        if (max != i) /*If we need to make a change*/
	        {
	            swap(input, i, max); /*We swap them*/
	            buildMaxHeap(input, max); /*We make the recursive call*/
<<<<<<< Updated upstream
=======
>>>>>>> origin/master
>>>>>>> Stashed changes
	        }
	    }  
    }

<<<<<<< Updated upstream
    /* The complexity of the buildMaxHeap() is O(log(n)), and the algorithm calls this methos "n" times.*/
    /* For those reasons, the complexity of the algorithm is O(log(n)*n), in both worst case and best case.
=======
    /* The complexity of the buildMaxHeap() is O(log(n)) and the algorithm calls this method n times no matter what
     * so, for those reasons, the complexity of the algorithm is O(log(n)*n), in both worst and best scenario. */
>>>>>>> Stashed changes


    /* BEGIN UTIL FUNCTION. DO NOT TOUCH */

    int[] readInput(String file) throws FileNotFoundException {

        InputStream inputStream;
        if (file == null) {
            inputStream = System.in;
        } else {
            inputStream = new FileInputStream(file);
        }
        Scanner in = new Scanner(inputStream);

        List<Integer> list = new ArrayList<Integer>();
        while (in.hasNext()) {
            int e = in.nextInt();
            list.add(e);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    void start(String algorithm, String file) throws FileNotFoundException {
        int[] toBeSorted = readInput(file);
        int[] sortedResult = null;
        switch (algorithm) {
            case "insertion":
                sortedResult = insertionSort(toBeSorted);
                break;
            case "merge":
                sortedResult = mergeSort(toBeSorted);
                break;
            case "heap":
                sortedResult = heapSort(toBeSorted);
                break;
            default:
                System.out.printf("Invalid algorithm provided: %s\n", algorithm);
                printHelp(null);
                System.exit(1);
        }

        printArray(sortedResult);
    }

    static void printArray(int[] array) {
        for (int e: array) {
            System.out.printf("%d ", e);
        }
    }

    static void printHelp(String[] argv) {
        System.out.printf("Usage: java -jar DS1.jar <algorithm> [<input_file>]\n");
        System.out.printf("\t<algorithm>: insertion, merge, heap\n");
        System.out.printf("E.g.: java -jar DS1.jar insertion example.txt\n");
    }

    public static void main(String argv[]) {
        if (argv.length == 0) {
            printHelp(argv);
        }
        try {
            (new Main()).start(argv[0], argv.length < 2 ? null : argv[1]);
        } catch (FileNotFoundException e) {
            System.out.printf("File not found: %s", e.getMessage());
        }

    }
    
}
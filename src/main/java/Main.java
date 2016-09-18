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
    public int[] insertionSort(int[] input) {
    	for (int i = 1; i <= input.length - 1; i++){
    		int key = input[i];
    		int j = i-1;
    		while (j >= 0 && input[j] > key){
    			input[j+1] = input[j];
    			j = j-1;
    		input[j+1] = key;
    		}
    	}
        return input;
    }

    @Override
    public int[] mergeSort(int[] input) {
    	if (input.length <=1){
    		return input;
    	}
    	int q = Math.floorDiv(input.length, 2);
    	int[] left = Arrays.copyOfRange(input, 0, q);
    	int[] right = Arrays.copyOfRange(input, q, input.length);
    	left = mergeSort(left);
    	right = mergeSort(right);
    	return merge(left, right);
    }
    
    private int[] merge(int[] left, int[] right) {
    	int i = 0;
    	int j = 0;
    	int[] result = new int[left.length+right.length];
    	while (i < left.length && j < right.length){
    		if (left[i] <= right[j]){
    			result[i+j] = left[i];
    			i++;
    		}
    		else{
    			result[i+j] = right[j];
    			j++;
    		}
    	}
    	if (i == left.length && j < right.length){
    		while (j < right.length){
    			result[i+j] = right[j];
    			j++;
    		}
    	}
    	else if (j == right.length && i < left.length){
    		while (i < left.length){
    			result[i+j] = left[i];
    			i++;
    		}
    	}
    	return result;
    }

    @Override
    public int[] heapSort(int[] input) {
    	buildHeap(input);
    	for (int i = n; i > 0; i--){
    		swap(input,0,i);
    		n--;
    		buildMaxHeap(input,0);
    	}
        return input;
    }

    private static int n;
    
	private static void swap(int[] input, int i, int i2) {
		int tmp = input[i];
        input[i] = input[i2];
        input[i2] = tmp; 
	}

	private static void buildHeap(int[] input) {
		n = input.length-1;
        for (int i = n/2; i >= 0; i--){
            buildMaxHeap(input,i);
        }
	}

	private static void buildMaxHeap(int[] input, int i) {
		{ 
	        int left = 2*i ;
	        int right = 2*i + 1;
	        int max = i;
	        if (left <= n && input[left] > input[i])
	            max = left;
	        if (right <= n && input[right] > input[max])        
	            max = right;
	 
	        if (max != i)
	        {
	            swap(input, i, max);
	            buildMaxHeap(input, max);
	        }
	    }  
    }




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
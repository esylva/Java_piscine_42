// package ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
// import java.util.stream.Collectors;
// import java.util.concurrent.Future;
// import java.util.concurrent.Executors;
// import java.util.concurrent.ExecutionException;
// import java.util.concurrent.ExecutorService;



public class Program {
	private static final int VALUE_IN_ARRAY = 1000;
	private static int arraySize = 30;
	private static int countOfThreads = 4;
	
	public static void main(String[] args) {  

		// if(checkingArgs(args) == false) {
		// 	System.out.println("Usage:\njava Program --arraySize=<int > 0> --count=<(int > 0) && (int < 2000000)>");
		// 	System.exit(-1);
		// }
		int [] array = generateRandomArray();

		AThread first = new AThread(array, 0, arraySize - 1);
		System.out.println("Sum: " + first.sum());

		List<AThread> threads = new ArrayList<>(arraySize);
		int countOfElements = (arraySize/countOfThreads > 0 ? arraySize/countOfThreads : 1);
		int start;
		int end;
		for (int i = 0; i < countOfThreads; i++) {
			start = countOfElements * i;
			if (i == countOfThreads - 1){
				end = arraySize - 1;
			}
			else {
				end = (start + countOfElements) - 1;
			}
			AThread thread = new AThread(array, start, end);
			threads.add(thread);
		}
		for (AThread a : threads) {
            a.start();
        }
        long answer = 0;
        for (AThread a : threads) {
            try{
				a.join();
            	answer += a.getSum();
			}
			catch (Exception e) {
				System.out.println("Beda");
			}
        }
		System.out.println("Sum by threads: " + answer);
	}

	private static boolean checkingArgs(String[] args) {

		if (args.length != 2) {
            return false;
        }
		if (!args[0].startsWith("--arraySize=") || !args[1].startsWith("--count=")) {
			return false;
		}
		String[] size = args[0].split("=");
		String[] count = args[1].split("=");
        if ((count.length != 2) || (size.length != 2)) {
            return false;
        }
        try {
            arraySize = Integer.parseInt(size[1]);
			countOfThreads = Integer.parseInt(count[1]);
        } 
		catch (Exception e) {
            return false;
        }
		if (arraySize < 1 || countOfThreads < 1) {
			return false;
		}
        return true;
    }

    private static int[] generateRandomArray() {
        int []arr = new int[arraySize];
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            arr[i] = random.nextInt(VALUE_IN_ARRAY);
		}
        return arr;
    }
}


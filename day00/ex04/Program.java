import java.util.Scanner;

public class Program {

    private static int MAX_CODE_VALUE = 65535;
    private static int NUMBER_OF_BEST_VALUES = 10;
	private static int MIN_INDEX = 9;
	private static int MAX_INDEX = 0;
    private static int HIGHEST_GRAPH_VALUE = 10;


    public static void main(String[] args) {
		System.out.println("Input a string to calculate symbols.");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        char []str = scanner.nextLine().toCharArray();
        if (str.length == 0) {
            System.exit(0);
        }
		
        int []alphabeth = new int[MAX_CODE_VALUE];
        for (char c : str) {
            alphabeth[c]++;
        }

        int []bestValues = new int[NUMBER_OF_BEST_VALUES];
        for (int i = 0; i < alphabeth.length; i++) {
            if (alphabeth[i] == 0 || alphabeth[i] < alphabeth[bestValues[MIN_INDEX]]) {
                continue;
            }
			for (int j = 0; j < NUMBER_OF_BEST_VALUES; j++) {
				if (alphabeth[i] > alphabeth[bestValues[j]]) {
					for (int k = NUMBER_OF_BEST_VALUES - 1; k > j; k--){
						bestValues[k] = bestValues[k - 1];
					}
					bestValues[j] = i;
					break;
				}
			}
        }

		int size = 1;
        for (int i = 0; i < NUMBER_OF_BEST_VALUES; i++) {
            if (alphabeth[bestValues[i]] == 0) {
                break;
            }
        	size = i + 1;
        }
// max_value
        if (alphabeth[bestValues[MAX_INDEX]] > 999) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
//print
        System.out.printf("% 3d", alphabeth[bestValues[MAX_INDEX]]);
		for (int i = 1; i < size; i++) {
			if (alphabeth[bestValues[i]] == alphabeth[bestValues[MAX_INDEX]]) {
				System.out.printf("% 3d", alphabeth[bestValues[i]]);
			}
		}
		System.out.print("\n");
        for (int i = NUMBER_OF_BEST_VALUES; i > 0; i--) {
            int height = (alphabeth[bestValues[MAX_INDEX]] * i);
            int heightNext = (alphabeth[bestValues[MAX_INDEX]] * (i - 1));
            for (int j = 0; j < size; j++) {
                if (alphabeth[bestValues[j]] * HIGHEST_GRAPH_VALUE >= height) {
                    System.out.printf("%3c",  '#');
                } else if (alphabeth[bestValues[j]] * HIGHEST_GRAPH_VALUE >= heightNext) {
                    System.out.printf("% 3d", alphabeth[bestValues[j]]);
                } else {
                    break;
                }
            }
            System.out.println("");
        }
        for (int i = 0; i < size; i++) {
            System.out.printf("%3c", (char) bestValues[i]);
        }
        System.out.println("");
        scanner.close();
    }
}

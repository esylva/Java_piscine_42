import java.util.Scanner;

public class Program {

    private static int iterations = 0;
    private static boolean isPrime(int number){
        if (number <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        iterations++;
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0){
            return false;
        }
        for (int i = 5; i * i <= number; i = i + 6) {
            iterations += 1;
            if (number % i == 0 || number % (i + 2) == 0) {                
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Input a number:");
        Scanner scanner = new   Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(isPrime(number) + " " + iterations);
        scanner.close();
    }
}
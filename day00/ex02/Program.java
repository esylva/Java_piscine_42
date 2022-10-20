import java.util.Scanner;

public class Program {
    private static int sumOfDigits(int number){
        if (number < 10)
            return number;
        else
            return (number % 10) + sumOfDigits(number / 10);
    }

    private static boolean isPrime(int number){
        if (number <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0){
            return false;
        }
        for (int i = 5; i * i <= number; i = i + 6) {
            if (number % i == 0 || number % (i + 2) == 0) {                
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int quantity = 0;
        int request = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a request:");
        while (request != 42){
            if (isPrime(sumOfDigits(request = scanner.nextInt()))){
            quantity++;
            }
        }
        System.out.println("Count of coffee-request - " + quantity);
        scanner.close();
    }
}

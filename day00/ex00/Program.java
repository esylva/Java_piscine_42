public class Program {

    static private int sumOfDigits(int number){
        if (number < 10)
            return number;
        else
            return (number % 10) + sumOfDigits(number / 10);
    }

    public static void main(String[] args) {

        int number = 479598;
        int sum = 0;
        if (number < 0){
            number = -number;
        }
        sum = sumOfDigits(number);
        System.out.println(sum);
    }
}

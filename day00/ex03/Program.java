import java.util.Scanner;

public class Program {
    private static void plotGraph (int numOfWeek, int len){
        System.out.println("Week " + numOfWeek);
        while(len != 0){
            System.out.print("=");
            len--;
        }
        System.out.println(">");
    }

    private static int getDigit(int saver, int numOfWeeks, int currentWeek) {
        currentWeek = numOfWeeks - currentWeek;
        while (--currentWeek > 0) {
            saver /= 10;
        }
        return (saver % 10);
    }
    public static void main(String[] args) {
		System.out.println("Enter number of the week and then results of 5 tests. The end is \"42\".\nExample:\n");
		System.out.println("Week 1\n1 2 3 4 5\n42\n");
        Scanner scanner = new Scanner(System.in);
        String curWeekNum;
        int weekCount = 1;
        int saver = 0;
        while (!(curWeekNum = scanner.nextLine()).equals("42")){
            if (!curWeekNum.equals("Week " + weekCount)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            weekCount++;
            int grade;
            int minGrade = 9;
            for (int i = 0; i < 5; i++) {
                grade = scanner.nextInt();
                if (grade < minGrade){
                    minGrade = grade;
                }
            }
            saver = minGrade + 10 * saver;
            scanner.nextLine();
        }

        for (int i = 1; i < weekCount; i++) {
            plotGraph(i, getDigit(saver, weekCount, i));
        }
        scanner.close();
    }
}

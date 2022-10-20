import java.util.Scanner;

public class Program {

	public static void printError() {
		System.err.println("Illegal Argument");
		System.exit(-1);
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String studentsNames[] = new String[10];

        int i = 0;
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            if (str.equals(".")) {
                break;
            }

            if (i >= 9 || str.length() > 10) {
				scanner.close();
				Program.printError();
            }

            studentsNames[i] = str;
            i++;
        }

        int studentNamesCount = i;

        if (studentsNames[0] == null) {
            scanner.close();
            Program.printError();
        }


        String[] daysOfWeek = {" MO", " TU", " WE", " TH", " FR", " SA", " SU"};
        int timeTable[][] = new int[7][7];


        i = 0;
        while (scanner.hasNext()) {
            String str = null;

            if (!scanner.hasNextInt()) {
                str = scanner.nextLine();
                if (str.equals(".")) {
                    break;
                } else {
					scanner.close();
					Program.printError();
                }
            } 
			 else {
                if (i == 10) {
					scanner.close();
					Program.printError();
                }


                int lessonTime = scanner.nextInt();

                if (lessonTime > 6 || lessonTime < 1) {
					scanner.close();
					Program.printError();
                }


                int dayId = -1;
                str = scanner.nextLine();
                for (int j = 0; j < daysOfWeek.length; j++) {
                    if (daysOfWeek[j].equals(str)) {
                        dayId = j;
                    }
                }
                if (dayId == -1) {
					scanner.close();
					Program.printError();
                }

                if (timeTable[dayId][lessonTime] > 0) {
					scanner.close();
					Program.printError();
                }
                timeTable[dayId][lessonTime]++;
                timeTable[dayId][0]++;
            }
            i++;
        }

        int day[] = new int[30];
        int isHere[][][] = new int[studentNamesCount][32][10];

        while (scanner.hasNext()) {

            String name = null;

            name = scanner.next();
            if (name.equals(".")) {
                scanner.nextLine();
                break;
            }

            int time = scanner.nextInt();
            int date = scanner.nextInt();
            day[date] = 1;

            int id = -1;
            for (int j = 0; j < studentNamesCount; j++) {
                if (name.equals(studentsNames[j])) {
                    id = j;
                    break;
                }
            }

            if (id == -1) {
				scanner.close();
				Program.printError();
            }


            String str = scanner.nextLine();
            if (str.equals(" HERE")) {
                isHere[id][date][time] = 1;
            } else if (str.equals(" NOT_HERE")) {
                isHere[id][date][time] = -1;
            }

        }


 //head of the table
		System.out.print("          ");
		for (int date = 1; date < 31; date++) {
			int dayId = date % 7;
			if  (timeTable[dayId][0] != 0) {
				for (int k = 1; k < 7; k++) {
					if  (timeTable[dayId][k] != 0) {
						System.out.printf("%1d:00%3s%3d|", k, daysOfWeek[dayId], date);
					}
                }
            }
        }
        System.out.println();

        i = 0;
		while (studentsNames[i] != null) {   
            System.out.printf("%10s", studentsNames[i]);

            for (int j = 1; j < 31; j++) {
                int dayId = j % 7;
                if (timeTable[dayId][0] != 0) {
                    for (int k = 1; k < 7; k++) {
                        if (timeTable[dayId][k] != 0) {
                            // if (isHere[i][j][k] == 1) {
                                // System.out.print("         1|");
                            // } else if (isHere[i][j][k] == -1) {
                                // System.out.print("        -1|");
                            // } 
							if  (isHere[i][j][k] != 0) {
								System.out.printf("%10d|", isHere[i][j][k]);
							}
							else {
                                System.out.print("          |");
                            }
                        }
                    }
                }
            }

            System.out.println();
            i++;

        }
	scanner.close();
    }
}

// test example

// Mike
// John
// Vik
// .
// 2 MO
// 4 WE
// .
// Mike 2 28 NOT_HERE
// Mike 4 9 HERE
// John 4 9 HERE
// .
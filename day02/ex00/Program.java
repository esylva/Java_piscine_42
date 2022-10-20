package ex00;

import java.io.*;

public class Program {
	private static final String SIGNATURES = "signatures.txt";
    private static final String RESULT = "result.txt";
	public static void main(String[] args) {
		
	
        FileFinder fileFinder = new FileFinder();

        if (!fileFinder.readFile(SIGNATURES)) {
            System.err.println("Проблема с файлом signatures.txt\nПока-пока!");
            System.exit(-1);
        }

        while (true) {
            String path = readLine(System.in);
            if ("42".equals(path)) {
                return;
            }
            String type = fileFinder.findType(path);
            if (type != null) {
                System.out.println("PROCESSED");
                write(type);
            } else {
                System.err.println("FILE NOT FOUND");
            }
        }
    }

    private static void write(String result) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(RESULT, true)) {
            fileOutputStream.write(result.getBytes());
            fileOutputStream.write('\n');
        } catch (IOException e) {
            System.err.println("Какая-то нездоровая канитель творится с этим файлом " + RESULT);
            System.exit(-1);
        }
    }

    public static String readLine(InputStream stream) {
        StringBuilder string = new StringBuilder();

        try {
            int c = 0;
            while ((c = stream.read()) != -1 && c != '\n') {
                string.append((char) c);
            }
        } catch (IOException e) {
            System.err.println("Can't read from System.in");
            System.exit(-1);
        }
        return string.toString();
    }
}

// package ex00;

public class Program {
	private static int times;
	
	public static void main(String[] args) {
		times = checkingArgs(args); 
		if(times <= 0) {
			System.out.println("Usage:\njava Program --count=<int > 0>");
			System.exit(-1);
		}

		AThread egg = new AThread("Egg", times);
		AThread hen = new AThread("Hen", times);
		egg.start();
		hen.start();
		try{
			egg.join();
			hen.join();
		}
		catch(InterruptedException e) {
			System.out.println("A thread has been interrupted");
		}

		for (int i = 0; i < times; i++) {
			System.out.println("Human");
		}
	}

	private static int checkingArgs(String[] args) {
		if (args.length != 1 || !args[0].startsWith("--count=")) {
            return 0;
        }
		String[] counts = args[0].split("=");
        if (counts.length != 2) {
            return 0;
        }
        try {
            times = Integer.parseInt(counts[1]);
        } catch (Exception e) {
            return 0;
        }
        return times;
    }
	
}

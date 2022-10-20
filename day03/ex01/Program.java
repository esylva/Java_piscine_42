// package ex01;

class Resource {
	public String role;

	Resource(){
		role = "Hen";
	}

	Resource(String a){
		role = a;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	synchronized void printName(String name, Resource res) {
		if (res.role.equals(name)) {
			System.out.println(name);
			try{
				wait();	
			}
			catch(InterruptedException e){}
		}
		else{
			notifyAll();
			this.role = name;
		}
		notifyAll();
	}
}

public class Program {
	private static int times;
	
	public static void main(String[] args) {

		times = checkingArgs(args);
		if(times <= 0) {
			System.out.println("Usage:\njava Program --count=<int > 0>");
			System.exit(-1);
		}
		Resource produser = new Resource();

		AThread hen = new AThread("Hen", times, produser);
		AThread egg = new AThread("Egg", times, produser);

		egg.start();
		hen.start();
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

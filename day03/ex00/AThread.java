// package ex00;

public class AThread extends Thread implements Runnable{
    private String name;
	private int repiteTimes; 

    AThread(String name, int repiteTimes){
		this.name = name;
		this.repiteTimes = repiteTimes;
    }
      
    public void run(){
          
		for (int i = 0; i < repiteTimes; i++) {
			System.out.println(name);
		}
    }
}
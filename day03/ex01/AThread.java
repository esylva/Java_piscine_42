// package ex01;

public class AThread extends Thread implements Runnable{
    private String name;
	private int repiteTimes;
	Resource res;


    AThread(String name, int repiteTimes, Resource produser){
		this.name = name;
		this.repiteTimes = repiteTimes;
		res = produser;
    }
      
    public void run(){
		for (int i = 0; (i < repiteTimes * 2 ); i++) {
			res.printName(name, res);
		}
    }
}
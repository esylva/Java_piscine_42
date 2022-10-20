// package ex02;

// import java.util.concurrent.Callable;

public class AThread extends Thread implements Runnable {

// public class AThread extends Thread implements Callable <AThread>{
    private int []arr;
    private int id;
    private int start;
    private int end;
    private long sum;
	private static int iDGenerator = 0;

    AThread(int arr[], int start, int end){
		this.arr = arr;
		id = iDGenerator++;
		this.start = start;
		this.end = end;
		sum = 0;
    }

    public void run(){
		sum();
		System.out.println("Thread " + id + ": from " + start + " to " + end + " sum is " + sum);
		// return this;
	}

	public long sum(){
		for (int i = start; i <= end; i++) {
			sum = sum + arr[i];
		}
		return sum;
    }
	public long getSum(){
		return sum;
	}
	
	@Override
	public String toString() {
		System.out.println("Thread " + id + ": from " + start + " to " + end + " sum is " + sum);
		return super.toString();
	}
	
}		

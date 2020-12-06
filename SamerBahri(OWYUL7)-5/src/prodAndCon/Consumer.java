package prodAndCon;

import fifo.*;

public class Consumer extends Thread{
	private Fifo f;
	private String s;
	private int n;
	
	public Consumer(Fifo f,String s,int n) {
		this.f=f;
		this.s=s;
		this.n=n;
	}
	
	public void run() {
		while(true) {
			String s2 = "consumed "+s+" "+f.get()+" "+String.format("%05d", System.currentTimeMillis()%100000);
			System.out.println(s2);
			
			try {
				sleep(n);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

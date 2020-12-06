package consumer;

import fifo.Fifo;

public class Consumer extends Thread {
	private Fifo f;
	private String s;
	private int n;
	
	public Consumer(Fifo f, String s, int n) {
		this.f=f;
		this.s=s;
		this.n=n;
	}
	
	public void run() {
		String str = new String();
		while(true) {
			str=f.get();
			System.out.println("consumed "+s+" "+str+" "+String.format("%05d", System.currentTimeMillis()%100000));
			
			try {
				Thread.sleep(n);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

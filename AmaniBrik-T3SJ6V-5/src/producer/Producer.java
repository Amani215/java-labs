package producer;

import java.util.*;
import fifo.Fifo;

public class Producer extends Thread {
	private String text;
	private int number;
	private long waitingTime;
	public Fifo fifo;
	
	public Producer(String text, Fifo fifo, long waitingTime) {
		this.text=text;
		number=0;
		this.fifo=fifo;
		this.waitingTime=waitingTime;
	}
	
	public void go() {	
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				String str = new String(text+" "+number);
				fifo.put(str);
				System.out.println("produced "+str+" "+String.format("%05d", System.currentTimeMillis()%100000));
				number++;
			}
		}, 0, 1000);
		try {
			sleep(waitingTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() { go();}
}

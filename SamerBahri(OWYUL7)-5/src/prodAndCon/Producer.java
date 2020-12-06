package prodAndCon;

import java.util.*;
import fifo.*;

public class Producer extends Thread{
	private String text;
	private int num=0;
	private Fifo f;
	private int n;
	
	public Producer(Fifo f, String text, int n) {
		this.text=text;
		this.f=f;
		this.n=n;
	}
	
	public void go() {
		try {
			sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				String s="produced "+text+" "+num+" "+String.format("%05d", System.currentTimeMillis()%100000);
				System.out.println(s);
				num++;
				f.put(text+" "+num);
			}
		}, 0, 1000);
	}
	
	public void run() {
		go();
	}
}

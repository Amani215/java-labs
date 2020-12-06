package fifo;

import java.util.*;

public class Fifo {
	private ArrayList<String> l = new ArrayList<String>();
	
	public synchronized void put(String s) {
		if(l.size()<10) {
			l.add(s);
			notify();
		}
		else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized String get() {
		if (l.size()==0) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		String s = l.get(0);
		l.remove(0);
		notify();
		return s;
	}
}

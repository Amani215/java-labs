package fifo;

import java.util.*;

public class Fifo {
	private ArrayList<String> list = new ArrayList<String>();
	//private int size=0;
	
	public synchronized void put(String s) {
		if(list.size()==10) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(list.size()<10) {
			list.add(s);
			notifyAll();
		}
	}
	
	public synchronized String get() {
		if(list.size()==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String s="";
		if(list.size()>0) {
			s = list.get(0);
			list.remove(0);
			notifyAll();
		}
		return s;
	}
}

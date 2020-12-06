package prog;

import prodAndCon.*;
import fifo.*;

public class Application {
	public static void main(String[] args) {
		Fifo f = new Fifo();
		Producer prod = new Producer(f,"first",1000);
		Consumer con = new Consumer(f,"second",5000);
		
		prod.start();
		con.start();
	}
}

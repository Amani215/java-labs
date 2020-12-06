package application;

import producer.Producer;
import consumer.Consumer;
import fifo.Fifo;

public class Application {
	public static void main(String[] args) {
		Fifo fifo = new Fifo();
		
		Producer p = new Producer("first",fifo,1000);
		Consumer c = new Consumer(fifo,"demo",2000);
		p.start();
		c.start();
	}
}

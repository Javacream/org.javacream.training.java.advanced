package org.javacream.training.java.aufbau.threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ProducerConsumer {
	static int counter = 0;

	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(5);
		BlockingQueue<Object> queue = new ArrayBlockingQueue<>(4);
		class Product{
			int productCounter;
			{
				productCounter = counter++;
			}
			@Override
			public String toString() {
				return "Product [productCounter=" + productCounter + "]";
			}
		}
		abstract class Base implements Runnable {
			long delay;
			String name;
			Base(String name, long delay) {
				this.name = name;
				this.delay = delay;
			}
			@Override
			public String toString() {
				return "Base [delay=" + delay + ", name=" + name + "]";
			}
		}
		class Producer extends Base{
			Producer(String name, long delay) {
				super(name, delay);
			}
			@Override
			public void run() {
				while (true) {
					Object product = new Product();
					try {
						queue.put(product);
						System.out.println(this + " produces " + product);
						Thread.sleep(delay);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		class Consumer extends Base{

			Consumer(String name, long delay) {
				super(name, delay);
			}

			@Override
			public void run() {
				while (true) {
					try {
						Object product = queue.take();
						System.out.println(this + " consumes " + product);
						Thread.sleep(delay);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		}

		
		//executor.execute(new Producer("Producer 100", 100));
		executor.execute(new Producer("Producer 500", 500));
		executor.execute(new Consumer("Consumer 50", 50));
		executor.execute(new Consumer("Consumer 150", 150));
		executor.execute(new Consumer("Consumer 5000", 5000));

	}

}

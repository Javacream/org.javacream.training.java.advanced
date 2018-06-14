package org.javacream.training.java.aufbau.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadingDemo {

	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();
		// service.execute(() -> System.out.println("Hello"));
		Runnable r = new MyRunnable();
		service.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello");
			}
		});
		
		r.run();
//		ScheduledExecutorService scheduledService = Executors.newSingleThreadScheduledExecutor();	
//		scheduledService.scheduleAtFixedRate(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println(new Date());
//			}
//			
//		}, 0, 999, TimeUnit.MILLISECONDS);
		System.out.println("finished main!");
		service.shutdown();

	
	}
	static class MyRunnable implements Runnable{
		@Override
		public void run() {
			System.out.println("Hello");
		}
	}
}

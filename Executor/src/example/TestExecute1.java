package example;

import java.util.concurrent.ExecutorService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class TestExecute1 {

	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(3);
		List<Future<?>> futures = new ArrayList<Future<?>>();
		for(int i=0;i<10;i++){
			Future<?> future = es.submit(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("Abc");
					try {
						int i=0;
						while(i<10){
							TimeUnit.SECONDS.sleep(1);
							i++;
						}
						System.out.println("=========cbA");
					} catch (InterruptedException e) {
						System.out.println("lalala");
					}
				}
			});
			futures.add(future);
		}
		
		for(Future<?> future:futures){
			try {
				future.get(15, TimeUnit.SECONDS);
//				System.out.println("canceled:"+future.isCancelled()+",done:"+future.isDone());
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				future.cancel(true);
			}
		}
		
		es.shutdown();
	}
	
	
	
	
}

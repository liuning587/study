import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


public class TestFutureTask {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> future = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				TimeUnit.SECONDS.sleep(10);
				return "abc";
			}
		});
		
		new Thread(future).start();
		System.out.println(future.get());
		
	}
}

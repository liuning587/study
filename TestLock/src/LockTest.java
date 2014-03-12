import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;



public class LockTest {

	//1.Write
	//2.Read
	static List<String> values = Collections.synchronizedList(new ArrayList<String>());
	public LockTest(){
		for(int i=0;i<1000000;i++){
			values.add(""+i);
		}	
	}
	
	static class TestThread implements Runnable{

		@Override
		public  void run() {
			long t1 = System.currentTimeMillis();
			Iterator<String> it = values.iterator();
			synchronized (values) {
				while(it.hasNext()){
					it.next();
				}
			}

			long t2 = System.currentTimeMillis();
			System.out.println("use:"+(t2-t1));
		}
		
	}
	
	public static void main(String[] args) {
		LockTest lt = new LockTest();
		for(int i=0;i<50;i++){
			new Thread(new TestThread()).start();
		}
		
	}
}

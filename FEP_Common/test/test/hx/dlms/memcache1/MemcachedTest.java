package test.hx.dlms.memcache1;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hx.dlms.aa.DlmsContext;
import com.meetup.memcached.MemcachedClient;

public class MemcachedTest {

	private MemcachedClient client ;
	
	private static int MAX=200000;
	
	private static int THREAD_SIZE=5;
	
	private static String BASEID="100000000000";
//	PrintWriter out;

	@Before
	public  void beforeClass() throws IOException{
		ApplicationContext context = new ClassPathXmlApplicationContext("memcached.xml");
		client=(MemcachedClient) context.getBean("memcachedClient");
//		out = new PrintWriter(new BufferedWriter(new FileWriter(new File("D:\\output.txt"),true)));
//		out = new PrintWriter(new FileOutputStream(new File("D:\\output.txt"),true));
	}
	public enum OPERATION {SET,GET};

	private class ClientThread implements Runnable{

		public int startNum = 0;
		public String name;
		public OPERATION operation;
		CountDownLatch cdl;
		public boolean onlyMeter=false;
		public ClientThread(int startNum,OPERATION op,CountDownLatch cdl){
			this.startNum = startNum;
			this.name =op.name()+"("+startNum+")";
			this.cdl = cdl;
			this.operation  =op;
		}
		
		public ClientThread(int startNum,OPERATION op,CountDownLatch cdl,boolean onlyMeter){
			this(startNum,op,cdl);
			this.onlyMeter=onlyMeter;
		}

		
		@Override
		public void run() {
			long t1 = System.currentTimeMillis();
			int count=0;
			for(int i=startNum*MAX;i<MAX*(startNum+1);i++){
				String meterId=BASEID.substring(0,BASEID.length()-(""+i).length())+""+i;
				if(operation == OPERATION.SET){
					DlmsContext dc = new DlmsContext();
					dc.setMeterId(meterId);
					if(!client.set(""+i, onlyMeter?""+i:dc)){
						count++;
					}					
				}else{
					if(onlyMeter){
						String id=(String) client.get(""+i);
						if(id==null){
							count++;
						}
					}else{
						DlmsContext dc=(DlmsContext) client.get(meterId);
						if(dc==null){
							count++;
						}						
					}
				}
			}
			long t2 = System.currentTimeMillis();
			System.out.println("Thread-"+name+" count:"+MAX+" use time:"+(t2-t1)+",fail:"+count);
			cdl.countDown();
				
		}
		
	}
	@Test
	public void testSetSingle(){
		DlmsContext dc = new DlmsContext();
		dc.setMeterId(BASEID);
		long t1 = System.currentTimeMillis();
		client.set(BASEID, dc);
		long t2 = System.currentTimeMillis();
		System.out.println("use time:"+(t2-t1));
	}
	@Test
	public void testGetSingle() throws IOException {
		for (int i = 0; i < 1000; i++) {
			long t1 = System.currentTimeMillis();
			client.get(BASEID);
			long t2 = System.currentTimeMillis();
			System.out.println("use time:" + (t2 - t1));
//			out.write("" + (t2 - t1) + "\n");
		}
//		out.close();
	}
	
	@Test
	public void testSet() throws InterruptedException{
		CountDownLatch cdl = new CountDownLatch(THREAD_SIZE);
		long s1 = System.currentTimeMillis();
		for(int i=0;i<THREAD_SIZE;i++){
			new Thread(new ClientThread(i, OPERATION.SET,cdl)).start();
		}
		cdl.await();
		long s2 = System.currentTimeMillis();
		System.out.println(s2-s1);
		Toolkit.getDefaultToolkit().beep();
	}
	
	@Test
	public void testSetMeter() throws InterruptedException{
		CountDownLatch cdl = new CountDownLatch(THREAD_SIZE);
		long s1 = System.currentTimeMillis();
		for(int i=0;i<THREAD_SIZE;i++){
			new Thread(new ClientThread(i, OPERATION.SET,cdl,true)).start();
		}
		cdl.await();
		long s2 = System.currentTimeMillis();
		System.out.println(s2-s1);
		Toolkit.getDefaultToolkit().beep();
	
	}
	
	@Test
	public void testGet() throws InterruptedException{
		CountDownLatch cdl = new CountDownLatch(THREAD_SIZE);
		long s1 = System.currentTimeMillis();

		for(int i=0;i<THREAD_SIZE;i++){
			new Thread(new ClientThread(i, OPERATION.GET,cdl)).start();
		}
		cdl.await();
		long s2 = System.currentTimeMillis();
		System.out.println(s2-s1);
		Toolkit.getDefaultToolkit().beep();
	}
	@Test
	public void testGetMeter() throws InterruptedException{
		CountDownLatch cdl = new CountDownLatch(THREAD_SIZE);
		long s1 = System.currentTimeMillis();

		for(int i=0;i<THREAD_SIZE;i++){
			new Thread(new ClientThread(i, OPERATION.GET,cdl,true)).start();
		}
		cdl.await();
		long s2 = System.currentTimeMillis();
		System.out.println(s2-s1);
		Toolkit.getDefaultToolkit().beep();
	}
	
	@Test
	public void testM(){
	}
//	
}

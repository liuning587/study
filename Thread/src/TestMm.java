import java.util.ArrayList;
import java.util.List;


public class TestMm {

		
	public byte[] placeholder=new byte[64*1024];

	public static void main(String[] args) throws InterruptedException {
		fillheap(1000);
	}
	public static void fillheap(int size) throws InterruptedException{
		List<TestMm> values = new ArrayList<TestMm>();
		
		for(int i=0;i<size;i++){
			Thread.sleep(50);
			System.out.println("add");
			values.add(new TestMm());
		}
		System.gc();
	}
		
}

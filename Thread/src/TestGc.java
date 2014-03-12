
public class TestGc {
	public static TestGc save_hook = null;
	
	public void isAlive(){
		System.out.println("still alive");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize execute");
		TestGc.save_hook=this;
	}
	
	public static void main(String[] args) throws InterruptedException {
		save_hook = new TestGc();
		save_hook = null;
		System.gc();
		Thread.sleep(500);
		if(save_hook !=null){
			save_hook.isAlive();
		}else{
			System.out.println("save_hook dead");
		}
		
		save_hook = null;
		System.gc();
		Thread.sleep(500);
		if(save_hook !=null){
			save_hook.isAlive();
		}else{
			System.out.println("save_hook dead");
		}
		
	}
	
}

public class Main {

	Integer i = 1;

	public Main() {
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		final Main t = new Main();
		synchronized (t.i) {
			Thread thread = new Thread() {
				public void run() {
					for (;;) {
						synchronized (t.i) {
							System.out.println("a:" + (++t.i));
							try {
								Thread.sleep(100);
							} catch (InterruptedException ex) {
								ex.printStackTrace();
							}
							t.i.notifyAll();
						}
					}
				}
			};
			thread.start();
			t.i.wait();
			System.out.println("b:" + (++t.i));
		}

	}

}
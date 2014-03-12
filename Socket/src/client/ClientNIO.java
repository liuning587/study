package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ClientNIO {

	private Selector selector;
	SocketChannel channel;
	ByteBuffer readBuffer;
	String msg ="";
	public ClientNIO(int port,String ip) {
		try {
			channel = SocketChannel.open();
			channel.configureBlocking(false);
			selector = Selector.open();
			channel.connect(new InetSocketAddress(ip, port));
			channel.register(selector, SelectionKey.OP_CONNECT);
			readBuffer=ByteBuffer.allocate(1024);
			for(int i=0;i<100;i++){
				msg+=UUID.randomUUID().toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class WriteThread implements Runnable{

		@Override
		public void run() {
			while(true){
				if(channel.isConnected()){
					
					try {
						send();
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		
	}
	private void send() {
		System.out.println("send msg:"+msg);
		send(msg);
	
	}
	private void send(String msg) {
		try {
			channel.write(ByteBuffer.wrap(msg.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class WorkThread implements Runnable{

		@Override
		public void run() {
			while(true){
				try {
					int n = selector.select(10);
					if(n<=0)
						continue;
					Set<SelectionKey> keys = selector.selectedKeys();
					Iterator<SelectionKey> iterator = keys.iterator();
					while(iterator.hasNext()){
						SelectionKey key = iterator.next();
						iterator.remove();
						
						if(key.isConnectable()){
							if(channel.isConnectionPending()){
								channel.finishConnect();
							}
							channel.configureBlocking(false);
							channel.register(selector, SelectionKey.OP_READ);
						}else if( key.isReadable() ){
							doReceive();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		
		}
		
	}
	
	
	public static void main(String[] args) {
		new ClientNIO(3111, "localhost").listen();
	}


	public void doReceive() {
		
		int len = readBuffer.remaining();
		if( len == 0 ){
			readBuffer.position(0);
			readBuffer.clear();
			len = readBuffer.remaining();
		}
		
		try {
			channel.read(readBuffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		readBuffer.flip();
		handleBuffer();
		
	}
	int count=0;

	private void handleBuffer() {

		if(++count==5){
			send();
			count=0;
		}
		readBuffer.clear();
			
	}
	private void listen() {
		Executors.newCachedThreadPool().execute(new WorkThread());
		Executors.newCachedThreadPool().execute(new WriteThread());

	}

}

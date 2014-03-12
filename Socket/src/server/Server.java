package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
	
	private int port;
	private ServerSocketChannel ssc ;
	private Selector selector;
	private Map<String,Client> channelMap = new ConcurrentHashMap<String, Client>();
	
	public Server(int port){
		this.port = port;
		new AcceptThread().start();
		new WriteThread().start();
	}
	
	public void connectd(String peerAddr,Client sc){
		channelMap.put(peerAddr, sc);
	}
	public void disconnected(String peerAddr){
		channelMap.remove(peerAddr);
	}
	

	public static void main(String[] args) {
		new Server(3111);
	}
	
	class WriteThread extends Thread{
		
		@Override
		public void run(){
			this.setName("Server-WriteThread");
			while(true){
				for(Client c : channelMap.values()){
					c.sendMsg();
				}
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	class AcceptThread extends Thread{
		
		@Override
		public void run(){
			this.setName("Server-AcceptThread");
			try {
				ssc = ServerSocketChannel.open();
				ssc.socket().setReuseAddress(true);
				ssc.socket().bind(new InetSocketAddress(port));
				ssc.configureBlocking(false);
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				selector=Selector.open();
				ssc.register(selector, SelectionKey.OP_ACCEPT);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			while(true){
				
				try {
					tryAccept();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}
			
		}
		
		public void tryAccept() throws IOException{
			int n=selector.select(50);
			
			Set<SelectionKey> keys = selector.selectedKeys();
			for(SelectionKey key:keys){
				if(key.isAcceptable())
					doAccept();
			}
			keys.clear();
			
		}

		private void doAccept() throws IOException {
			SocketChannel sc = ssc.accept();
			new Client(sc,Server.this);
		}
	}

	public ServerSocketChannel getServerSocketChannel() {
		return ssc;
	}
	
	
	
}

import java.io.*;
import java.net.*;
import java.lang.*;

class Reception extends Thread
{
	String name;
	String massage;
	DatagramSocket serverSocket;
	InetAddress ipAddress;
	
	Reception(DatagramSocket socket) {
		name = "";
		serverSocket = socket;
		try{
			ipAddress = InetAddress.getByName("localhost");
		} catch(Throwable e){}
	}
	
	public void run(){	
		try {
			while(true){
				
				byte[] reciveData = new byte[1024];
				
				DatagramPacket recivePacket = new DatagramPacket(reciveData, reciveData.length);
				
				serverSocket.receive(recivePacket);
				String modifiedSentence = new String(recivePacket.getData());
				System.out.println("User: " + modifiedSentence);
				
			}
			} catch (Throwable m){
				
			}
		
	}
	
}

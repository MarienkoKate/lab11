import java.io.*;
import java.net.*;
import java.lang.*;

class ReceptionClient extends Thread
{
	String name;
	String massage;
	int portServer;
	DatagramSocket clientSocket;
	InetAddress ipAddress;
	
	ReceptionClient(int port, DatagramSocket clientSocket) {
		name = "";
		portServer = port;
		this.clientSocket = clientSocket;
		try{
			ipAddress = InetAddress.getByName("localhost");
		} catch(Throwable e){}
	}
	
	public void run(){	
		try {
			while(true){
				
				byte[] reciveData = new byte[1024];
				
				DatagramPacket recivePacket = new DatagramPacket(reciveData, reciveData.length);
				
				clientSocket.receive(recivePacket);
				
				String modifiedSentence = new String(recivePacket.getData());
				System.out.println("User:" + modifiedSentence);
			}
		} catch (Throwable m){
			
		}
	}
	
}

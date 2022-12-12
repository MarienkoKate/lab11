import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

class InputClient extends Thread {
	
	String name;
	String massage;
	int port;
	InetAddress ipAddress;
	
	int status;
	
	DatagramSocket clientSocket;
	InputClient(int port, DatagramSocket clientSocket) {
		this.port = port;
		name = "";
		status = 1;
		this.clientSocket = clientSocket;
		try{
			ipAddress = InetAddress.getByName("localhost");
		} catch(Throwable e){}
	}
	
	public void run()	
	{
		while (status != -1) {
			massage = "";
			
			Scanner massage = new Scanner(System.in);
			command(massage.nextLine());
			send();
			
		}
		System.exit(0);
		
	}
	void command(String m){
		
		Scanner scanner = new Scanner(m);
		
		String str = "";

		while (scanner.hasNext()) {
			
           str = scanner.next();
		  
		   if (str.equals("@name") && scanner.hasNext()) name = scanner.next();
		   else if (str.equals("@quit")) status = -1; 
		   else massage = m;
		   
        }
		
	}
	void send(){
		try {
					
			if (massage.length() != 0) {
				
				byte[] sendData = new byte[1024]; byte[] reciveData = new byte[1024];
				sendData = massage.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
				
				clientSocket.send(sendPacket);
				massage = "";
			
			}
				

		} catch (Throwable m){}
		
	}
}

import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;


class Input extends Thread {
	
	String name;
	String massage;
	int port;
	DatagramSocket serverSocket;
	int clientPort;
	int serverPort;
	InetAddress IPAddress;
	
	int status;
	Input(int clientPort, int serverPort, InetAddress IPAddress, DatagramSocket socket) {
		this.port = port;
		name = "";
		status = 1;
		serverSocket = socket;
		this.clientPort = clientPort;
		this.serverPort = serverPort;
		this.IPAddress = IPAddress;

	}
	
	public void run() {
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
				
				byte[] sendData = new byte[1024];
				int port = this.port;
				
				sendData = massage.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, clientPort);

				serverSocket.send(sendPacket);
				massage = "";
			}

		} catch (Throwable m){
		}
		
	}
}


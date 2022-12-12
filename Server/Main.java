import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;


public class Main {
	
	
	public static void main(String[] args)
	{
		
		System.out.print("input port number: ");
		Scanner massage = new Scanner(System.in);
		
		try {
		
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];
			
			
			
			Integer serverPort = Integer.valueOf(massage.nextLine());
			
			DatagramSocket serverSocket = new DatagramSocket(serverPort);
			
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);

			String sentence = new String( receivePacket.getData());
			System.out.println(sentence);
				
			InetAddress IPAddress = receivePacket.getAddress();
			int clientPort = receivePacket.getPort();
			
			Input th1;
			th1 = new Input(clientPort, serverPort, IPAddress, serverSocket);	
			th1.start();
			
			Reception th2;
			th2 = new Reception(serverSocket);
			th2.start();
		
		} catch (Throwable m){
			
		}
		
	}
}

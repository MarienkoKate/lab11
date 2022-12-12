import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class MainClient {
	
	
	public static void main(String[] args)
	{
		System.out.print("input port number: ");
		Scanner massage = new Scanner(System.in);
		
		try {
			
		Integer serverPort = Integer.valueOf(massage.nextLine());
		DatagramSocket clientSocket = new DatagramSocket();
	
		InputClient th1;
		th1 = new InputClient(serverPort, clientSocket);	
		th1.start();
		
		ReceptionClient th2;
		th2 = new ReceptionClient(serverPort, clientSocket);
		th2.start();
		} catch(Throwable m) {
			
		}
		
	}
}

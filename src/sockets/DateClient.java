package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class DateClient {
	
	
	public static void main(String[] args)
	{
		try {
			InetAddress host = InetAddress.getByName("127.0.0.1");
			Socket client = new Socket(host, 8090);
			BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String answer = input.readLine();
			System.out.println(answer);
			client.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

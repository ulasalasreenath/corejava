package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
	
	BufferedReader in;
	PrintWriter out;
	
	public void run()
	{
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			socket = new Socket("127.0.0.1", 8090);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			while(true)
			{
				String line = in.readLine();
				
				if(line.startsWith("SUBMITNAME"))
				{
					String name = scanner.nextLine();
					out.println(name);
				} else if(line.startsWith("NAME ACCEPTED"))
				{
					out.println("Sending 1st message");
					System.out.println("sent message");
				} else if(line.startsWith("MESSAGE"))
				{
					System.out.println(line);
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		ChatClient client = new ChatClient();
		client.run();
	}
}

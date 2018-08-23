package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
	
	/**
	 * program execution starts from here
	 * @param args
	 */
	public static void main(String[] args)
	{
		Socket client = null;
		BufferedReader inputReader = null; 
		PrintWriter writer = null;
		
		// scnner to read input
		Scanner sc = new Scanner(System.in);
		
		try {
			
			// connecting to Game Server on port 8090
			client = new Socket("127.0.0.1", 8090);
			System.out.println("Connected to local server on 127.0.0.1");
			System.out.println("Message from server");
			
			// Reader for reading messages from server
			inputReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			// Writer for sending messages to server
			writer = new PrintWriter(client.getOutputStream(), true);
			
			String message = inputReader.readLine(); 
			while(message != null && !message.isEmpty()){
				
				if(message.equals("Client's Turn")) {
					
					int clientInput = sc.nextInt();
					writer.println(clientInput);
					
				} else if(message.equals("Game is finished")) {
					break;
				}
				else
				{
					System.out.println(message);
				}
				message = inputReader.readLine();
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally
		{
			if(client != null)
			{
				try {
					//closing client socket
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(sc != null)
			{
				// closing scanner
				sc.close();
			}
		}
				
	}

}

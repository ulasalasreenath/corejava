package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CapitalizeServer {

	public static void main(String[] args) {
		ServerSocket server = null;
		int clientNumber = 1;
		try {
			server = new ServerSocket(8090);
			while(true)
			{
				Socket clientSocket = server.accept();
				new Capitalizer(clientSocket, clientNumber++).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally
		{
			try {
				if(server != null)
					server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

class Capitalizer extends Thread
{
	
	private Socket socket;
	private int clientNumber;
	
	public Capitalizer(Socket socket, int clientNumber)
	{
		this.socket = socket;
		this.clientNumber = clientNumber; 
	}
	
	public void run()
	{
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println("Enter a line with only a period to quit");
			
			while(true)
			{
				String input = in.readLine();
				System.out.println(input);
				if(input == null || input.equals("."))
				{
					break;
				}
				out.println(input.toUpperCase());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally
		{
			try{
				socket.close();
			} catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}

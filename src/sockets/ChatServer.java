package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class ChatServer {

	
	private static final int PORT = 8090;
	
	public static HashSet<String> names = new HashSet<String>();
	
	public static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
	
	public static void main(String[] args) {
		
		System.out.println("The chat server is running");
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(PORT);
			
			while(true)
			{
				new Handler(server.accept()).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally
		{
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}

class Handler extends Thread
{
	
	private Socket socket = null;
	private String name;
	private BufferedReader in;
	private PrintWriter out;
	
	public Handler(Socket socket)
	{
		this.socket = socket;
	}
	
	public void run()
	{
		try
		{
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			while(true)
			{
				out.println("SUBMITNAME");
				name = in.readLine();
				if(name == null)
				{
					return;
				}
				
				synchronized(ChatServer.names)
				{
					if(!ChatServer.names.contains(name))
					{
						ChatServer.names.add(name);
						break;
					}
				}
			}
			out.println("NAME ACCEPTED");
			ChatServer.writers.add(out);
			
			while(true)
			{
				String input = in.readLine();
				if(input == null)
				{
					return;
				}
				
				synchronized(ChatServer.writers) {
					for(PrintWriter writer : ChatServer.writers)
					{
						writer.println("MESSAGE " + name + ": " + input);
					}
				}
				
			}
		} catch(IOException ie)
		{
			ie.printStackTrace();
		} finally
		{
			if(name != null)
			{
				ChatServer.names.remove(name);
			}
			
			if(out != null)
			{
				ChatServer.writers.remove(out);
			}
			
			try{
				socket.close();
			} catch(IOException e)
			{
				
			}
		}
	}
}

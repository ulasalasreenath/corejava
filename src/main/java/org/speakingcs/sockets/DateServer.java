package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
	
	public static void main(String[] args)
	{
		ServerSocket server = null;
		try {
			server = new ServerSocket(8090);
			while(true)
			{
				Socket socket = server.accept();
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println(new Date().toString());
				//socket.close();
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

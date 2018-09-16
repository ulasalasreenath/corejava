package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CapitalizeClient {
	
	private BufferedReader in;
	private PrintWriter out;

	public static void main(String[] args) {
		
		CapitalizeClient client = new CapitalizeClient();
		client.connectToServer();
		
	}

	private void connectToServer() {
		
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		try {
			socket = new Socket("127.0.0.1", 8090);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			/*for(int i = 0; i < 3; i++)
			{
				System.out.println(in.readLine()); 
			}
*/			
			String response = in.readLine();
			System.out.println(response);
			while( response!= null || !response.isEmpty())
			{
				System.out.println("Enter String to captitalize");
				String input = sc.next();
				
				out.println(input);
				response = in.readLine();
				System.out.println(response);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally
		{
				try {
					if(socket != null)
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
	}

}

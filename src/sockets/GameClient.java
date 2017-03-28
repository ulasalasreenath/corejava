package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {

	public static void main(String[] args) {
		Socket client = null;
		BufferedReader inputReader = null;
		PrintWriter writer = null;
		Scanner sc = new Scanner(System.in);

		try {
			client = new Socket("127.0.0.1", 8090);
			System.out.println("Connected to local server on 127.0.0.1");
			System.out.println("Message from server");
			inputReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(client.getOutputStream(), true);

			String message = inputReader.readLine();
			while (message != null && !message.isEmpty()) {

				if (message.equals("Client's Turn")) {

					int clientInput = sc.nextInt();
					writer.println(clientInput);

				} else if (message.equals("Game is finished")) {
					break;
				} else {
					System.out.println(message);
				}
				message = inputReader.readLine();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (sc != null) {
				sc.close();
			}
		}

	}

}

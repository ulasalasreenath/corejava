package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class GameServer {

	public static void main(String[] args) {

		ServerSocket server = null;

		try {
			server = new ServerSocket(8090);
			System.out.println("Server started successfully");
			while (true) {

				Socket socket = server.accept();
				new ClientThread(socket).start();

			}

		} catch (IOException e) {
			System.out.println("Server failed to start");
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

class ClientThread extends Thread {
	Socket socket;
	BufferedReader reader = null;
	PrintWriter writer = null;

	public ClientThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		int[] serverScores = new int[10];
		int[] clientScores = new int[10];
		int serverWinScore = 0;
		int clientWinScore = 0;

		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);

			writer.println("Let's play some random game, game rules are as follows");
			writer.println("Select some random number in between 1 to 10");
			writer.println("At the same time, server also selects some random number");
			writer.println(
					"If the number selected by server is greater than clients then server wins, else client wins");
			writer.println("If the number selected by server and client are same, then its tie. No one wins");

			for (int i = 0; i < 10; i++) {
				writer.println("Turn: " + (i + 1) + " Enter some random number");
				writer.println("-----------------------------------------");

				writer.println("Client's Turn");

				int clientTurn = Integer.parseInt(reader.readLine());
				int serverTurn = new Random().nextInt(10);

				writer.println("Server's score " + serverTurn);
				writer.println("Client's score " + clientTurn);

				if (serverTurn > clientTurn) {
					serverScores[i] = serverTurn;
					clientScores[i] = clientTurn;
					serverWinScore = serverWinScore + 1;
					writer.println("Server Wins");
				} else if (serverTurn == clientTurn) {
					serverScores[i] = serverTurn;
					clientScores[i] = clientTurn;
					writer.println("It's a tie");
				} else {
					serverScores[i] = serverTurn;
					clientScores[i] = clientTurn;
					clientWinScore = clientWinScore + 1;
					writer.println("Client wins");
				}
			}

			writer.println("Final Result");
			writer.println("Server scores are as follows");
			for (int i = 0; i < 10; i++) {
				writer.print(serverScores[i] + " ");
			}
			writer.println();
			writer.println("Client scores are as follows");
			for (int i = 0; i < 10; i++) {
				writer.print(clientScores[i] + " ");
			}
			writer.println();
			writer.println("Total Server's score is " + serverWinScore);
			writer.println("Total Client's score is " + clientWinScore);
			writer.println("The winner is ");
			if (serverWinScore > clientWinScore) {
				writer.print("Server");
			} else if (serverWinScore < clientWinScore) {
				writer.print("Client");
			} else {
				writer.println("\n Its a tie, both server and client are winners");
			}
			writer.println("\nGame is finished");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
